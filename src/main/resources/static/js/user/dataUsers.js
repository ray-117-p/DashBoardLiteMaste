var url = "";
$(document).ready(function() {
	url = document.getElementById('url').value;
	tableAll();

});
function tableAll() {
	if ($.fn.DataTable.isDataTable('#tableUsuarios')) {
		$('#tableUsuarios').DataTable().destroy();
	}//end of if
	$('#tableUsuarios' + " tbody").empty();
	$('#tableUsuarios')
		.DataTable(
			{
				'processing': true,
				'serverSide': true,
				'paging': true,
				"pageLength": 30,
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
					"url": "listAllUsuarios",
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
									nombreUsuario: data[i].nombre + " " + data[i].paterno + " " + data[i].materno,
									userName: data[i].username,
									perfil: data[i].perfil.descripcion,
									estatus: data[i].estatus,
									uuid: data[i].uuid,

								};
								all.push(row);
							}
						}
						return all;
					}
				},
				"columns": [
					{
						"data": "nombreUsuario"
					},
					{
						"data": "userName"
					},
					{
						"data": "perfil"
					},
					{
						"data": null,
						render: function(
							data, type,
							row) {
							if (data['estatus'] == true) {
								return "<span class='fa fa-thumbs-up' style='color: #28a745;'> </span> <span style='color: #28a745;'> Activo</span>";
							} else {
								return "<span class='fa fa-thumbs-down' style='color: #dc3545;'> </span> <span style='color: #dc3545;'> Inactivo</span>";
							}


						},
						"targets": -1
					},
					{
						"data": null,
						render: function(
							data, type,
							row) {
							return "<a href='" + url + "editUser/" + data['uuid'] + "' style='font-size: 18px;'><b><i class='fa fa-edit'></i</b></a>";
						},
						"targets": -1
					}],
				"columnDefs": [{
					"targets": 0
				}, {
					"targets": 3,
					"className": "text-center"
				}, {
					"targets": 4,
					"className": "text-center",
					"orderable": false
				}],
			});//end of tableUsuarios
}//end function tableAll()

function showModalUser() {
	$('#perfil').change().val(0);
	$('#uuid').val('');
	$('#nombre').val('');
	$("#nombre").removeClass("is-valid");
	$("#nombre").removeClass("is-invalid");
	$('#paterno').val('');
	$("#paterno").removeClass("is-valid");
	$("#paterno").removeClass("is-invalid");
	$('#materno').val('');
	$("#materno").removeClass("is-valid");
	$("#materno").removeClass("is-invalid");
	$('#user-name').val('');
	$("#user-name").removeClass("is-valid");
	$("#user-name").removeClass("is-invalid");
	$('#contrasena').val('');
	$("#contrasena").removeClass("is-valid");
	$("#contrasena").removeClass("is-invalid");
	$('#newUser').modal('show');
}//end function showModalUser()


$('#btnSaveUser').click(function() {
	var valid = $("#formUser").validate();
	if (valid.form()) {
		var uuidArea = $('#area').val();
		if (perfil === 0) {
			warningToast('Ha ocurrido un error, Intenta de nuevo.');
		} else {
			$.ajax({
				"url": "saveUser",
				"type": "POST",
				"data": $("#formUser").serialize() + '&uuidArea=' + uuidArea,
				success: function(respuesta) {
					if (respuesta.data === "success") {
						successToast("Usuario creado.");
						$('#newUser').modal('hide');
						tableAll();
					} else {
						errorToast("Ha ocurrido un error, Intenta de nuevo.");
					}//end of if-else
				},
				error: function(data) {
					console.log(data);
					errorToast("Ha ocurrido un error, Intenta de nuevo.");
				},
			});
		}
	} else {
		warningToast("Faltan campos, que son requeridos...");
	}
});
