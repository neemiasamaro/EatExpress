<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ page import="model.JavaBeansPainel"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Editar Produto</title>
<link rel="icon" href="img/icon.png">
<link href="styles/editar.css" type="text/css" rel="stylesheet">
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
	<main class="container">
		<div class="row">
			<div class="col-md-12"
				style="margin-top: 150px; margin-bottom: 50px;">
				<div class="card container-fluid">
					<form name="frmProduto" action="update-produto"
						style="margin-top: 25px;">
						<table>
							<tr>
								<td><input type="hidden" name="id"
									value="<%out.print(request.getAttribute("id"));%>"></td>
							</tr>
							<tr>
								<td><label>Nome:</label> <input type="text" name="nome"
									required value="<%out.print(request.getAttribute("nome"));%>"></td>
							</tr>
							<tr>
								<td><label>Quantidade:</label> <input type="number"
									name="quantidade" required maxlength="3" min="1"
									value="<%out.print(request.getAttribute("quantidade"));%>"></td>
							</tr>
							<tr>
								<td><label>Descrição:</label> <input name="descricao"
									required
									value="<%out.print(request.getAttribute("descricao"));%>"></td>
							</tr>
							<tr>
								<td><label>Valor:</label> <input type="text" name="valor"
									required value="<%out.print(request.getAttribute("valor"));%>"></td>
							</tr>
						</table>
						<div style="text-align: center; margin-top: 20px;">
							<a href="produtos" class="btn voltar">Voltar</a> <input
								type="button" value="Salvar" class="btn" onclick="validar()">
						</div>
					</form>
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
	<script src="scripts/validador_produto.js" type="text/javascript"></script>
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