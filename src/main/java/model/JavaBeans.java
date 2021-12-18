package model;

public class JavaBeans {
	private String id;
	private String nome_cadastro;
	private String email_cadastro;
	private String senha_cadastro;
	private String email_user;
	private String senha_user;

	public JavaBeans() {
		super();
	}

	public JavaBeans(String id, String nome_cadastro, String email_cadastro, String senha_cadastro,
			String email_user, String senha_user) {
		super();
		this.id = id;
		this.nome_cadastro = nome_cadastro;
		this.email_cadastro = email_cadastro;
		this.senha_cadastro = senha_cadastro;
		this.email_user = email_user;
		this.senha_user = senha_user;
	}

	// Dados Cadastro

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome_cadastro() {
		return nome_cadastro;
	}

	public void setNome_cadastro(String nome_cadastro) {
		this.nome_cadastro = nome_cadastro;
	}

	public String getEmail_cadastro() {
		return email_cadastro;
	}

	public void setEmail_cadastro(String email_cadastro) {
		this.email_cadastro = email_cadastro;
	}

	public String getSenha_cadastro() {
		return senha_cadastro;
	}

	public void setSenha_cadastro(String senha_cadastro) {
		this.senha_cadastro = senha_cadastro;
	}

	/*
	 * 
	 * Dados Login
	 * 
	 */

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

	public String getSenha_user() {
		return senha_user;
	}

	public void setSenha_user(String senha_user) {
		this.senha_user = senha_user;
	}

}
