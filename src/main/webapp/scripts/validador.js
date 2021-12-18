function validarCadastroFunc() {
	let nome = frmCadastro.nome.value
	let email = frmCadastro.email.value
	let password = frmCadastro.senha.value
	let idloja = frmCadastro.idloja.value

	if (nome == "" && email == "" && password == "") {
		alert('Preencha todos os campos!')
		frmCadastro.nome.focus()
		return false
	} else if (nome == "") {
		alert('Preencha o campo Nome!')
		frmCadastro.nome.focus()
		return false
	} else if (email == "") {
		alert('Preencha o campo Email!')
		frmCadastro.email.focus()
		return false
	} else if (password == "") {
		alert('Preencha o campo Senha!')
		frmCadastro.senha.focus()
		return false
	} else if (nome == "" && email == "") {
		alert('Preencha os campos Nome e Email!')
		frmCadastro.nome.focus()
		return false
	} else if (email == "" && senha == "") {
		alert('Preencha os campos Email e Senha!')
		frmCadastro.email.focus()
		return false
	} else if (nome == "" && senha == "") {
		alert('Preencha os campos Nome e Senha!')
		frmCadastro.nome.focus()
		return false
	} else if (idloja == "777") {
		document.forms["frmCadastro"].submit()
	} else {
		alert('Id não confere com a Loja!\nPreencha novamente!')
		frmCadastro.idloja.focus()
	}
}