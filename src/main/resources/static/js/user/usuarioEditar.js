$(document).ready(function() {
	perfil();
});

function perfil() {
	var idPerfil = $('#perfil option:selected').val();
	if (idPerfil != 0) {
		$.ajax({
			"url": "findTipoPerfil/" + idPerfil,
			"type": "GET",
			success: function(respuesta) {

				if (respuesta.data == 5) {
					$("#area").removeClass("addAreaHidden");
					$("#area").addClass("addAreaShow");
				} else {
					$("#area").removeClass("addAreaShow");
					$("#area").addClass("addAreaHidden");
				}
			},
			error: function(data) {

			},
		});
	}
}


$("#perfil").change(function() {
	var idPerfil = $('#perfil option:selected').val();

	$.ajax({
		"url": "findTipoPerfil/" + idPerfil,
		"type": "GET",
		success: function(respuesta) {

			if (respuesta.data == 5) {
				$("#area").removeClass("addAreaHidden");
				$("#area").addClass("addAreaShow");
				$("#catArea").val(0).change();
			} else {
				$("#area").removeClass("addAreaShow");
				$("#area").addClass("addAreaHidden");
				$("#catArea").val(0).change();
			}
		},
		error: function(data) {

		},
	});
});