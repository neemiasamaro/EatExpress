function validar(){
	let nome = frmProduto.nome.value
	let quantidade = frmProduto.quantidade.value
	let descricao = frmProduto.descricao.value
	let valor = frmProduto.valor.value
	
	if (nome == "") {
		alert('Preencha os campos que estão faltando')
		frmProduto.nome.focus()
		return false
	} else if (quantidade == "") {
		alert('Preencha os campos que estão faltando')
		frmProduto.quantidade.focus()
		return false
	} else if (descricao == "") {
		alert('Preencha os campos que estão faltando')
		frmProduto.descricao.focus()
		return false
	} else if (valor == "") {
		alert('Preencha os campos que estão faltando')
		frmProduto.valor.focus()
		return false
	}else {
		document.forms["frmProduto"].submit()
	}
}