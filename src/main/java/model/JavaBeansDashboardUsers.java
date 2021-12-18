package model;

public class JavaBeansDashboardUsers {
	private String id_user;
	private String nome_user;
	private String email_user;

	public JavaBeansDashboardUsers() {
		super();
	}

	public JavaBeansDashboardUsers(String id_user, String nome_user, String email_user) {
		super();
		this.id_user = id_user;
		this.nome_user = nome_user;
		this.email_user = email_user;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getNome_user() {
		return nome_user;
	}

	public void setNome_user(String nome_user) {
		this.nome_user = nome_user;
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

}