<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeansDashboardUsers"%>
<%@ page import="model.JavaBeansDashboardProdutos"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeansDashboardUsers> tabela = (ArrayList<JavaBeansDashboardUsers>) request.getAttribute("funcionarios");
@SuppressWarnings("unchecked")
ArrayList<JavaBeansDashboardProdutos> lista = (ArrayList<JavaBeansDashboardProdutos>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Dashboard</title>
<link rel="icon" href="img/icon.png">
<link href="styles/dashboard.css" type="text/css" rel="stylesheet">
</head>

<body>
	<header>
		<nav class="navbar bg-light navbar-light navbar-expand-md fixed-top">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#conteudoNavbarSuportado"
				aria-controls="conteudoNavbarSuportado" aria-expanded="false"
				aria-label="Alterna navegação">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item" style="margin-left: 10px;"><a
						class="nav-link" href="Home">Home</a></li>
					<li class="nav-item dropdown" style="margin-left: 10px;"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Opções</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="novo-produto">Cadastrar
								Produtos</a> <a class="dropdown-item" href="produtos">Ver
								Produtos</a>
						</div></li>
					<li class="nav-item" style="margin-left: 10px;"><a
						class="nav-link btn-nav" href="registrar-venda">Registrar
							Venda</a></li>
				</ul>
			</div>
			<div>
				<ul class="navbar-nav mr-auto">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Usuário</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdown2">
							<a class="dropdown-item" href="sair">Sair</a>
						</div></li>
				</ul>
			</div>
		</nav>
	</header>
	<main>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12" style="text-align: center; margin-top: 25px;">
					<a href="Home"><img alt="Logo" src="img/mini.png"
						class="logo img-fluid"></a>

				</div>
				<div class="col-md-12" id="funcionarios">
				<a href="relatorio" id="relatorio">Gerar Relatório</a>
					<h1>Funcionários</h1>
					<table class="table-sm">
						<thead>
							<tr>
								<th scope="col">Nome</th>
								<th scope="col">Email</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (int i = 0; i < tabela.size(); i++) {
							%>
							<tr>
								<td><%=tabela.get(i).getNome_user()%></td>
								<td><%=tabela.get(i).getEmail_user()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				<div class="col-md-12" id="produtos">
					<h1>Produtos</h1>
					<table class="table-sm">
						<thead>
							<tr>
								<th scope="col">Nome</th>
								<th scope="col">Quant.</th>
								<th scope="col">Valor</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (int n = 0; n < lista.size(); n++) {
							%>
							<tr>
								<td><%=lista.get(n).getNome_produto()%></td>
								<td><%=lista.get(n).getQuantidade_produto()%></td>
								<td><%="R$ " + lista.get(n).getValor_produto()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<footer class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h6 class="mt-2">
					<strong>EatExpress.</strong> <small>Todos os direitos
						reservados.</small>
				</h6>
				<a href="https://github.com/neemiasamaro/EatExpress.git" id="link"
					class="mt-5">Repositório do Projeto</a>
				<hr />
				<h6 class="mt-2">Fale conosco</h6>
				<ul
					style="list-style-type: none; margin: 0; padding: 0; overflow: hidden; text-align: left;">
					<li class="socials"><a href="facebook.com"><img
							src="img/facebook.png" alt="facebook"
							style="width: 18px; height: 18px;"></a></li>
					<li class="socials"><a href="instagram.com"><img
							src="img/instagram.png" alt="instagram"
							style="width: 18px; height: 18px;"></a></li>
					<li class="socials"><a href="twitter.com"><img
							src="img/twitter.png" alt="twitter"
							style="width: 18px; height: 18px;"></a></li>
					<li class="socials"><a href="web.whatsapp.com"><img
							src="img/whatsapp.png" alt="whatsapp"
							style="width: 18px; height: 18px;"></a></li>
				</ul>
				<h6 class="mt-2" style="text-align: right;">
					<strong>Versão 1.0</strong>
				</h6>
			</div>
		</div>
	</footer>
	<script src="scripts/selector.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>