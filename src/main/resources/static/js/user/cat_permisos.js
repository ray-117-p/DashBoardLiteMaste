var url = "";
$(document).ready(function() {
	url = document.getElementById('url').value;
	tableAllCatPermisos();

});

function tableAllCatPermisos() {
	if ($.fn.DataTable.isDataTable('#tableCatPermisos')) {
		$('#tableCatPermisos').DataTable().destroy();
	}//end of if
	$('#tableCatPermisos' + " tbody").empty();
	$('#tableCatPermisos')
		.DataTable(
			{
				'processing': true,
				'serverSide': true,
				'paging': true,
				"pageLength": 15,
				'searching': true,
				'ordering': true,
				'info': true,
				language: {
					"decimal": "",
					"emptyTable": "No hay información",
					"info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
					"infoEmpty": "Mostrando 0 de 0",
					"infoFiltered": "(Filtrado de _MAX_ total entradas)",
					"infoPostFix": "",
					"thousands": ",",
					"lengthMenu": "Mostrar _MENU_ Entradas",
					"loadingRecords": "Cargando...",
					"processing": "Procesando...",
					"search": "Buscar:",
					"zeroRecords": "Sin resultados, Utilize el criterio de busqueda principal.",
					"paginate": {
						"first": "Primero",
						"last": "Ultimo",
						"next": "Siguiente",
						"previous": "Anterior"
					}
				},
				"ajax": {
					"url": "listAllCatPermisos",
					"method": "get",
					"dataSrc": function(
						response) {
						var data = response.data;
						var all = [];
						if (data !== null) {
							for (var i = 0; i < data.length; i++) {
								var row = {
									rows: response.start
										+ i + 1,
									permiso: data[i].descripcion,
									catSchema: data[i].catSchema.nombre,
									idPermiso: data[i].idPermiso,

								};
								all.push(row);
							}
						}
						return all;
					}
				},
				"columns": [
					{
						"data": "permiso"
					},
					{
						"data": "catSchema"
					},
					{
						"data": null,
						render: function(
							data, type,
							row) {
							return "<a href='#' onclick='editarPermiso(" + data['idPermiso'] + ")' ><b><i class='fa fa-edit'></i></b></a>"
						},
						"targets": -1
					}],
				"columnDefs": [{
					"targets": 0,
				}, {
					"targets": 1,
					"className": "text-center"
				}, {
					"targets": 2,
					"className": "text-center",
					"orderable": false
				}],
			});//end of tableCatPermisos
}//end function tableAllCatPermisos()

function addPermiso() {
	$('#idCatPermisos').val("");
	$('#schema').change().val(0);
	$('#permiso').val("");
	$('#Modal').modal('show');
}

function editarPermiso(idPermiso) {
	$.ajax({
		"url": "findCatPermisoById/" + idPermiso,
		"type": "GET",
		success: function(respuesta) {
			if (respuesta === "error") {
				errorToast("Ha ocurrido un error, Intenta de nuevo.");
			} else {
				$('#idCatPermisos').val(respuesta.data.idPermiso);
				$('#schema').change().val(respuesta.data.catSchema.idSchema);
				$('#permiso').val(respuesta.data.descripcion);
				$('#Modal').modal('show');
			}//end of if-else
		},
		error: function(data) {
			console.log(data);
			errorToast("Ha ocurrido un error, Intenta de nuevo.");
		},
	});
}


function text_cat(valor) {
	var idInput = valor.id;
	var texto = valor.value;
	texto = texto.toUpperCase();
	texto = texto.replace(/[^A-Z.\s () _  ]/g,
		'');
	$('#' + idInput).val(texto);
}

$('#btnSavePermiso').click(function() {
	var valid = $("#formAddPermiso").validate();
	if (valid.form()) {
		var schema = $('#schema').val();
		if (schema == "0") {
			warningToast('Seleccione un schema.');
		} else {
			var permiso = $('#permiso').val();
			var idPermiso = $('#idCatPermisos').val();
			$.ajax({
				"url": "saveCatPermiso",
				"type": "POST",
				"data": { "idPermiso": idPermiso, "schema": schema, "permiso": permiso },
				success: function(respuesta) {
					if (respuesta.data === "success") {
						successToast("Registro agregado.");
						$('#Modal').modal('hide');
						tableAllCatPermisos();
					} else {
						$('#Modal').modal('hide');
						errorToast("Ha ocurrido un error, Intenta de nuevo.");
					}//end of if-else
				},
				error: function(data) {
					$('#Modal').modal('hide')
					errorToast("Ha ocurrido un error, Intenta de nuevo.");
				},
			});
		}
	} else {
		warningToast("Faltan campos, que son requeridos...");
	}
});