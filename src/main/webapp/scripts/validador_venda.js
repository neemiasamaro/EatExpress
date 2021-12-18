$(document).ready(function() {
	$("#myTable").hide();
	$("button.add").on("click", function() {
		$("#myTable").show();
		$("#subtitle").hide();

		var $row = $(this).closest("tr"),
			$tds2 = $row.find("td:nth-child(1)"),
			$tds3 = $row.find("td:nth-child(2)");

		var name;

		var valor;

		var valorReal;

		$.each($tds2, function() {
			name = $(this).text();
		});

		$.each($tds3, function() {
			valor = parseFloat($(this).text().replace('R$', '')).toFixed(2);
			valorReal = valor;
			console.log(valorReal);
		});

		$("#tBody").append('<tr><td class="name">' + name + '</td>\n<td class="valores">' + valorReal + '</td>\n<td style="text-align: center;"><button class="sub"><img src = "./img/sub.png" alt = "Remover Produto" title = "Remover" ></button ></tr> ');

		$("button.sub").on("click", function() {
			$(this).closest('tr').remove();
		});

	});
});

function validar() {
	let nome = frmVenda.nome.value
	let cep = frmVenda.cep.value
	let n_casa = frmVenda.n_casa.value
	let obs = frmVenda.obs.value
	let pag = frmVenda.pagamento.value
	let cpf = frmVenda.cpf_cliente.value
	let prod_name = []
	var valorCalculado = 0;
	var valorFinal = 0;

	$("td.name").each(function() {
		prod_name += ($(this).text().replace(/\s+/g, '_') + " ");
		frmVenda.produtos.value = prod_name.toString();
	});
	$(".valores").each(function() {
		valorCalculado += parseFloat($(this).text());
		valorFinal = valorCalculado.toFixed(2);
		frmVenda.valor_final.value = valorFinal;
	});
	$("#qtdtotal").text("Valor Total: R$ " + valorFinal);

	if (nome == "") {
		alert('Preencha os campos que faltam!')
		frmVenda.nome.focus()
		return false
	} else if (cep == "") {
		alert('Preencha os campos que faltam!')
		frmVenda.cep.focus()
		return false
	} else if (n_casa == "") {
		alert('Preencha os campos que faltam!')
		frmVenda.n_casa.focus()
		return false
	} else if (pag == "") {
		alert('Preencha os campos que faltam!')
		frmVenda.pag.focus()
		return false
	} else if (cpf == "") {
		alert('Preencha os campos que faltam!')
		frmVenda.cpf.focus()
		return false
	} else {
		document.forms["frmVenda"].submit()
	}
}