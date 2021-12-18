package model;

public class JavaBeansDashboardProdutos {

	private String id_produto;
	private String nome_produto;
	private String quantidade_produto;
	private String descricao_produto;
	private String valor_produto;

	public JavaBeansDashboardProdutos() {
		super();
	}

	public JavaBeansDashboardProdutos(String id_produto, String nome_produto, String quantidade_produto,
			String descricao_produto, String valor_produto) {
		super();
		this.id_produto = id_produto;
		this.nome_produto = nome_produto;
		this.quantidade_produto = quantidade_produto;
		this.descricao_produto = descricao_produto;
		this.valor_produto = valor_produto;
	}

	public String getId_produto() {
		return id_produto;
	}

	public void setId_produto(String id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getQuantidade_produto() {
		return quantidade_produto;
	}

	public void setQuantidade_produto(String quantidade_produto) {
		this.quantidade_produto = quantidade_produto;
	}

	public String getDescricao_produto() {
		return descricao_produto;
	}

	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}

	public String getValor_produto() {
		return valor_produto;
	}

	public void setValor_produto(String valor_produto) {
		this.valor_produto = valor_produto;
	}
}
