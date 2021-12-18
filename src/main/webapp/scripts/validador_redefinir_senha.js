function validarFormRedefinir() {
	let email = frmRedefinir.email.value

	if (email == "") {
		alert('Preencha o campo E-mail!')
		frmRedefinir.email.focus()
		return false
	} else {
		document.forms["frmRedefinir"].submit()
	}
}
