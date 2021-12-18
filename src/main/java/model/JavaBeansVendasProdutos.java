package model;

public class JavaBeansVendasProdutos {

	private String id_venda;
	private String nome;
	private String valor_final;
	private String cpf_cliente;
	private String forma_pagamento;
	private String cep;
	private String numero_casa;
	private String obs;
	private String produtos[];
	
	public JavaBeansVendasProdutos() {
		super();
	}

	public JavaBeansVendasProdutos(String id_venda, String valor_final,
			String cpf_cliente, String forma_pagamento, String cep, String numero_casa, String[] produtos, String obs, String nome) {
		super();
		this.id_venda = id_venda;
		this.nome = nome;
		this.valor_final = valor_final;
		this.cpf_cliente = cpf_cliente;
		this.forma_pagamento = forma_pagamento;
		this.cep = cep;
		this.numero_casa = numero_casa;
		this.produtos = produtos;
		this.obs = obs;

	}

	public String getId_venda() {
		return id_venda;
	}

	public void setId_venda(String id_venda) {
		this.id_venda = id_venda;
	}

	public String getValor_final() {
		return valor_final;
	}

	public void setValor_final(String valor_final) {
		this.valor_final = valor_final;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero_casa() {
		return numero_casa;
	}

	public void setNumero_casa(String numero_casa) {
		this.numero_casa = numero_casa;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String[] getProdutos() {
		return produtos;
	}

	public void setProdutos(String[] produtos) {
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
