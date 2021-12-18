function validarLogin() {
	let email = frmLogin.email.value
	let password = frmLogin.senha.value
	if (email == "") {
		alert('Preencha o campo Email!')
		frmLogin.email.focus()
		return false
	} else if (password == "") {
		alert('Preencha o campo Senha!')
		frmLogin.password.focus()
		return false
	} else if (email == "" && password == "") {
		alert('Preencha os campos Email e Senha!')
		frmLogin.email.focus()
		return false
	} else {
		document.forms["frmLogin"].submit()
	}
}