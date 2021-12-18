function validarCadastroFunc() {
	let nome = frmCadastro.nome.value
	let email = frmCadastro.email.value
	let password = frmCadastro.senha.value
	let password2 = frmCadastro.senha2.value

	if (nome == "") {
		alert('Preencha os campos que faltam!')
		frmCadastro.nome.focus()
		return false
	} else if (email == "") {
		alert('Preencha os campos que faltam!')
		frmCadastro.email.focus()
		return false
	} else if (password == "") {
		alert('Preencha os campos que faltam!')
		frmCadastro.senha.focus()
		return false
	} else if (password2 == "") {
		alert('Preencha os campos que faltam!')
		frmCadastro.senha2.focus()
		return false
	} else if (password != password2) {
		alert('As senhas não coincidem!')
		frmCadastro.senha.focus()
		return false
	} else {
		document.forms["frmCadastro"].submit()
	}
}