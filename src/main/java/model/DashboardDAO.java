package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DashboardDAO {
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

	public ArrayList<JavaBeansDashboardUsers> listarFuncionarios() {
		// Criando objeto para acessar classe JavaBeans
		ArrayList<JavaBeansDashboardUsers> funcionarios = new ArrayList<>();
		String read = "SELECT * FROM USUARIOS ORDER BY ID";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// While abaixo busca enquanto houver usuarios
			while (rs.next()) {
				// Váriaveis que recebem os dados do banco
				String id_user = rs.getString(1);
				String nome_user = rs.getString(2);
				String email_user = rs.getString(3);
				// Popular ArrayList
				funcionarios.add(new JavaBeansDashboardUsers(id_user, nome_user, email_user));
			}
			con.close();
			return funcionarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<JavaBeansDashboardProdutos> listarProdutos() {
		// Criando objeto para acessar classe JavaBeans
		ArrayList<JavaBeansDashboardProdutos> produtos = new ArrayList<>();
		String read2 = "SELECT * FROM PRODUTOS ORDER BY ID";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Váriaveis que recebem os dados do banco
				String id_produto = rs.getString(1);
				String nome_produto = rs.getString(2);
				String quantidade_produto = rs.getString(3);
				String descricao_produto = rs.getString(4);
				String valor_produto = rs.getString(5);
				// Popular ArrayList
				produtos.add(new JavaBeansDashboardProdutos(id_produto, nome_produto, quantidade_produto,
						descricao_produto, valor_produto));
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}