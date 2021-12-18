/*$(document).ready(function() {
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
});*/

