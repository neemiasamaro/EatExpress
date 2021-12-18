/*$(document).ready(function() {
	$("#myTableModal").hide();
	$("button.add").on("click", function() {
		$("#myTableModal").show();

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
		});

		$("#tBody2").append('<tr><td class="name">' + name + '</td>\n<td class="valores">' + valorReal + '</td>\n<td style="text-align: center;"><button class="sub1"><img src = "./img/sub.png" alt = "Remover Produto" title = "Remover" ></button > </tr>');

		$("button.sub").on("click", function() {
			$(this).closest('tr').remove();
		});

	});

	$("#registrar").on("click", function() {

		var valorCalculado = 0;

		$(".valores").each(function() {
			valorCalculado += (parseInt($(this).text()).toFixed(2) / 2);
			console.log("Valor somado:" + valorCalculado);
		});
		$("#qtdtotal").text("Valor Total: R$ " + valorCalculado);
	});
});

*/