<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="controller.Controller" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Login</title>
<link rel="icon" href="img/icon.png">
<link href="styles/login.css" type="text/css" rel="stylesheet">
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
				<div class="col-md-12" style="text-align: center;">
					<a href="index.html"><img alt="Logo" src="img/frame.png"
						class="logo img-fluid"></a>
					<form class="mt-3" name="frmLogin" action="consulta" method="get">
						<div class="col-md-12">
							<input type="email" name="email" required
								placeholder="Email">
						</div>
						<div class="col-md-12">
							<input type="password" name="senha" id="pass" maxlength="8"
								required placeholder="Senha"> <img
								src="img/olho.png" id="olho" class="olho">

						</div>
						<div class="col-md-12 mb-2">
							<a href="esqueceu-sua-senha" class="btn-esqueceu">Esqueceu
								sua senha?</a>
						</div>
						<div class="col-md-12">
							<button type="submit" onclick="validarLogin()" class="btn">Entrar</button>
						</div>
						<div class="col-md-12" style="margin-top: 10px;">
							<a href="Home" class="btn voltar">Voltar</a>
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
	<script src="scripts/showpsswd.js"></script>
	<script src="scripts/validador_login.js"></script>
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