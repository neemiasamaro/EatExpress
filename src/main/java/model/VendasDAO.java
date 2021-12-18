package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class VendasDAO {

	// Modulo de Conexão

	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbdados?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "neemias0210.,";
	public boolean result = false;

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void inserirVenda(JavaBeansVendasProdutos vendas_produtos) {
		String[] array = vendas_produtos.getProdutos();
		String create = "insert into vendas_has_produtos (valor_final,cliente_cpf,forma_pagamento,observacoes,produtos_nome,cep,num_casa,nome_cliente) values (?,?,?,?,?,?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros
			for (int i = 0; i < array.length; i++) {
				pst.setString(1, vendas_produtos.getValor_final());
				pst.setString(2, vendas_produtos.getCpf_cliente());
				pst.setString(3, vendas_produtos.getForma_pagamento());
				if (vendas_produtos.getObs() == null) {
					pst.setString(4, "Sem observações");
				} else {
					pst.setString(4, vendas_produtos.getObs());
				}
				pst.setString(5, array[i]);
				pst.setString(6, vendas_produtos.getCep());
				pst.setString(7, vendas_produtos.getNumero_casa());
				pst.setString(8, vendas_produtos.getNome());
				pst.executeUpdate();
				System.out.print(Arrays.toString(array));
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
