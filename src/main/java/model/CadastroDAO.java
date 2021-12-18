package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CadastroDAO {

	// Modulo de Conex�o

	// Par�metros de conex�o
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

	// CRUD CREATE
	public void inserirDados(JavaBeans cadastro) {
		String create = "insert into usuarios (nome,email,senha) values (?,?,?)";
		try {
			// abrir a conex�o
			Connection con = conectar();
			// Preparar a query para execu��o no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os par�metros

			pst.setString(1, cadastro.getNome_cadastro());
			pst.setString(2, cadastro.getEmail_cadastro());
			pst.setString(3, cadastro.getSenha_cadastro());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conex�o com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
