package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbdados?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "neemias0210.,";

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

	// CRUD INSERT

	public void inserirProduto(JavaBeansPainel produto) {
		String create = "insert into produtos (nome,quantidade,descricao,valor) values (?,?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros

			pst.setString(1, produto.getNome_produto());
			pst.setString(2, produto.getQuantidade_produto());
			pst.setString(3, produto.getDescricao_produto());
			pst.setString(4, produto.getValor_produto());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<JavaBeansPainel> listarProdutos() {
		// Criando objeto para acessar classe JavaBeans
		ArrayList<JavaBeansPainel> produtos = new ArrayList<>();
		String read = "SELECT * FROM PRODUTOS ORDER BY NOME";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// While abaixo busca enquanto houver usuarios
			while (rs.next()) {
				// Váriaveis que recebem os dados do banco
				String id_produto = rs.getString(1);
				String nome_produto = rs.getString(2);
				String quatidade_produto = rs.getString(3);
				String descricao_produto = rs.getString(4);
				String valor_produto = rs.getString(5);
				// Popular ArrayList
				produtos.add(new JavaBeansPainel(id_produto, nome_produto, quatidade_produto, descricao_produto,
						valor_produto));
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD Update

	public void selecionarProduto(JavaBeansPainel produto) {
		String read2 = "select * from produtos where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, produto.getId_produto());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				produto.setId_produto(rs.getString(1));
				produto.setNome_produto(rs.getString(2));
				produto.setQuantidade_produto(rs.getString(3));
				produto.setDescricao_produto(rs.getString(4));
				produto.setValor_produto(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// EDITAR PRODUTO

	public void alterarProduto(JavaBeansPainel produto) {
		String update = "update produtos set nome=?,quantidade=?,descricao=?,valor=? where id=?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, produto.getNome_produto());
			pst.setString(2, produto.getQuantidade_produto());
			pst.setString(3, produto.getDescricao_produto());
			pst.setString(4, produto.getValor_produto());
			pst.setString(5, produto.getId_produto());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// DELETAR PRODUTO

	public void deletarProduto(JavaBeansPainel produto) {
		String delete = "delete from produtos where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getId_produto());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
