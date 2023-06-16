$(document).ready(function() {
	$("select.TipoPerfil").change(function() {
		var idTipoPerfil = $(this).children("option:selected").val();
		$.ajax({
			url: 'framentPermisos',
			"data": { "idTipoPerfil": idTipoPerfil },
			success: function(data) {
				$('#framentPermisos').html(data);
			}
		});
	});
});