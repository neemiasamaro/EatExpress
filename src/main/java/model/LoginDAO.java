package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	// Modulo de Conexão

	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbdados?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "neemias0210.,";
	public boolean result = false;
	public String email = "";

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

	public void consultarDados(JavaBeans login) {
		String sql = "select * from usuarios where email=? and senha=?";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(sql);
			// Substituir os parâmetros
			pst.setString(1, login.getEmail_user());
			pst.setString(2, login.getSenha_user());
			email = login.getEmail_user();
			System.out.println(email);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				result = true;
			} else {
				result = false;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
