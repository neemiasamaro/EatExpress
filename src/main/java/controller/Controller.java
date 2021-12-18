package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.CadastroDAO;
import model.DashboardDAO;
import model.LoginDAO;
import model.ProdutosDAO;
import model.VendasDAO;
import model.JavaBeans;
import model.JavaBeansDashboardProdutos;
import model.JavaBeansDashboardUsers;
import model.JavaBeansPainel;
import model.JavaBeansVendasProdutos;

@WebServlet(urlPatterns = { "/Controller", "/Home", "/login", "/cadastro", "/insert", "/insert-produto",
		"/novo-produto", "/produtos", "/consulta", "/sair", "/esqueceu-sua-senha", "/dashboard", "/relatorio",
		"/select", "/update-produto", "/registrar-venda", "/delete", "/inserir-venda" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProdutosDAO dao = new ProdutosDAO();
	CadastroDAO cadastro_dao = new CadastroDAO();
	LoginDAO login_dao = new LoginDAO();
	DashboardDAO dashboard_dao = new DashboardDAO();
	VendasDAO vendas_dao = new VendasDAO();
	JavaBeans cadastro = new JavaBeans();
	JavaBeans login = new JavaBeans();
	JavaBeansPainel produto = new JavaBeansPainel();
	JavaBeansDashboardUsers dashboard_users = new JavaBeansDashboardUsers();
	JavaBeansDashboardProdutos dashboard_produtos = new JavaBeansDashboardProdutos();
	JavaBeansVendasProdutos vendas_produtos = new JavaBeansVendasProdutos();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/Home")) {
			main(request, response);
		}

		else if (action.equals("/login")) {
			loginUser(request, response);
		}

		else if (action.equals("/cadastro")) {
			cadastroUser(request, response);
		}

		else if (action.equals("/insert")) {
			insert(request, response);
		}

		else if (action.equals("/novo-produto")) {

			if (login_dao.result == true) {
				novoProduto(request, response);
			} else {
				loginUser(request, response);
			}
		}

		else if (action.equals("/insert-produto")) {
			insertProduto(request, response);
		}

		else if (action.equals("/produtos")) {
			if (login_dao.result == true) {
				produtos(request, response);
			} else {
				loginUser(request, response);
			}
		}

		else if (action.equals("/consulta")) {
			consulta(request, response);
		}

		else if (action.equals("/sair")) {
			sair(request, response);
		}

		else if (action.equals("/esqueceu-sua-senha")) {
			esqueceuSenha(request, response);
		}

		else if (action.equals("/dashboard")) {
			dashboard(request, response);
		}

		else if (action.equals("/relatorio")) {
			relatorio(request, response);
		}

		else if (action.equals("/select")) {
			listarProduto(request, response);
		}

		else if (action.equals("/delete")) {
			excluirProduto(request, response);
		}

		else if (action.equals("/update-produto")) {
			editarProduto(request, response);
		}

		else if (action.equals("/registrar-venda")) {
			if (login_dao.result == true) {
				registrarVenda(request, response);
			} else {
				loginUser(request, response);
			}
		}

		else if (action.equals("/inserir-venda")) {
			insereVenda(request, response);
		}
	}

	// HOME:

	protected void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}

	// LOGIN:

	protected void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	// CADASTRO:

	protected void cadastroUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
	}

	// VER PRODUTOS:

	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira receber os dados JavaBeans
		ArrayList<JavaBeansPainel> lista = dao.listarProdutos();
		// Encaminhar cadastros para ver.jsp
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		rd.forward(request, response);
	}

	// CADASTRAR NOVO PRODUTO:

	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("novo-produto.jsp");
		rd.forward(request, response);
	}

	protected void insertProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setNome_produto(request.getParameter("nome"));
		produto.setQuantidade_produto(request.getParameter("quant"));
		produto.setDescricao_produto(request.getParameter("descricao"));
		produto.setValor_produto(request.getParameter("valor"));
		dao.inserirProduto(produto);
		response.sendRedirect("produtos");
	}

	protected void esqueceuSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("esqueceu-senha.jsp");
		rd.forward(request, response);

	}

	protected void registrarVenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira receber os dados JavaBeans
		ArrayList<JavaBeansPainel> lista = dao.listarProdutos();
		// Encaminhar cadastros para ver.jsp
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("registrar-venda.jsp");
		rd.forward(request, response);
	}

	protected void dashboard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira receber os dados JavaBeans
		ArrayList<JavaBeansDashboardUsers> tabela = dashboard_dao.listarFuncionarios();
		ArrayList<JavaBeansDashboardProdutos> lista = dashboard_dao.listarProdutos();
		// Encaminhar cadastros para ver.jsp
		request.setAttribute("funcionarios", tabela);
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento id que será editado
		String id = request.getParameter("id");
		// Setar variavel JavaBeans
		produto.setId_produto(id);
		// Executar método selecionar produto
		dao.selecionarProduto(produto);
		// Setar os atributos do formulário com o connteúdo JavaBeans
		request.setAttribute("id", produto.getId_produto());
		request.setAttribute("nome", produto.getNome_produto());
		request.setAttribute("quantidade", produto.getQuantidade_produto());
		request.setAttribute("descricao", produto.getDescricao_produto());
		request.setAttribute("valor", produto.getValor_produto());
		// Encaminhar ao documento editar-produto.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar-produto.jsp");
		rd.forward(request, response);
	}

	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setId_produto(request.getParameter("id"));
		produto.setNome_produto(request.getParameter("nome"));
		produto.setQuantidade_produto(request.getParameter("quantidade"));
		produto.setDescricao_produto(request.getParameter("descricao"));
		produto.setValor_produto(request.getParameter("valor"));
		dao.alterarProduto(produto);
		response.sendRedirect("produtos");
	}

	protected void excluirProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		produto.setId_produto(id);
		dao.deletarProduto(produto);
		response.sendRedirect("produtos");
	}

	protected void relatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// tipo de conteúdo
			response.setContentType("application/pdf");
			// nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "dashboard.pdf");
			// criar documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// abrir o documento -> conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de Funcionários"));
			documento.add(new Paragraph(" "));
			PdfPTable table = new PdfPTable(2);
			PdfPCell col_name_user = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col_email_user = new PdfPCell(new Paragraph("Email"));
			table.addCell(col_name_user);
			table.addCell(col_email_user);

			// Popular a tabela com os dados

			ArrayList<JavaBeansDashboardUsers> tabela = dashboard_dao.listarFuncionarios();
			for (int i = 0; i < tabela.size(); i++) {
				table.addCell(tabela.get(i).getNome_user());
				table.addCell(tabela.get(i).getEmail_user());
			}
			documento.add(table);
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph("Estoque"));
			documento.add(new Paragraph(" "));
			PdfPTable estoque = new PdfPTable(3);
			PdfPCell col_name_prod = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col_quantidade_prod = new PdfPCell(new Paragraph("Quantidade"));
			PdfPCell col_valor_prod = new PdfPCell(new Paragraph("Valor"));

			estoque.addCell(col_name_prod);
			estoque.addCell(col_quantidade_prod);
			estoque.addCell(col_valor_prod);
			ArrayList<JavaBeansDashboardProdutos> produtos = dashboard_dao.listarProdutos();
			for (int i = 0; i < produtos.size(); i++) {
				estoque.addCell(produtos.get(i).getNome_produto());
				estoque.addCell(produtos.get(i).getQuantidade_produto());
				estoque.addCell(produtos.get(i).getValor_produto());
			}

			documento.add(estoque);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
	// INSERT FORM:

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cadastro.setNome_cadastro(request.getParameter("nome"));
		cadastro.setEmail_cadastro(request.getParameter("email"));
		login.setEmail_user(request.getParameter("email"));
		cadastro.setSenha_cadastro(request.getParameter("senha"));
		login.setSenha_user(request.getParameter("senha"));
		login_dao.consultarDados(login);
		if (login_dao.result == true) {
			response.sendRedirect("login");
		} else {
			cadastro_dao.inserirDados(cadastro);
			response.sendRedirect("produtos");
		}
	}

	protected void insereVenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vendas_produtos.setNome(request.getParameter("nome"));
		vendas_produtos.setCep(request.getParameter("cep"));
		vendas_produtos.setNumero_casa(request.getParameter("n_casa"));
		vendas_produtos.setCpf_cliente(request.getParameter("cpf_cliente"));
		vendas_produtos.setForma_pagamento(request.getParameter("pagamento"));
		vendas_produtos
				.setProdutos(request.getParameter("produtos").replaceAll(" ", ",").replaceAll("_", " ").split(","));
		vendas_produtos.setValor_final(request.getParameter("valor_final"));
		vendas_dao.inserirVenda(vendas_produtos);
		response.sendRedirect("produtos");
	}

	// CONSULTA LOGIN:

	protected void consulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String file = "C:/Users/neemi/eclipse-workspace/EatExpress/src/main/webapp/logs/log.txt";
		login.setEmail_user(request.getParameter("email"));
		login.setSenha_user(request.getParameter("senha"));
		login_dao.consultarDados(login);
		if (login_dao.result == true) {
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String agoraFormatado = agora.format(formatter);
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("\nEmail usuário: " + login.getEmail_user() + " Login Hora: " + agoraFormatado);
			bw.newLine();
			bw.close();
			fw.close();
			response.sendRedirect("produtos");
		} else {
			response.sendRedirect("login.jsp");
		}

	}

	// BOTÃO SAIR

	protected void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String file = "C:/Users/neemi/eclipse-workspace/EatExpress/src/main/webapp/logs/log.txt";
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String agoraFormatado = agora.format(formatter);

		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("\nEmail usuário: " + login.getEmail_user() + " Logout Hora: " + agoraFormatado);
		bw.newLine();
		bw.close();
		fw.close();
		login.setEmail_user(null);
		if (login.getEmail_user() == null) {
			login_dao.result = false;
			response.sendRedirect("login");
		} else {
			response.sendRedirect("Home");
		}
	}

}
