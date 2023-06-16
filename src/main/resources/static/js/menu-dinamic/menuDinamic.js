//////// SECCION MENU DINAMIC ///////////
function cargaFramentMenu(valor) {
	var id = valor.id;
	var perfil = $("#" + id).data("perfil");
	$.ajax({
		url: 'framentMenu',
		"data": { "perfil": perfil },
		success: function(data) {
			$('#framentMenu').html(data);
		}
	});
}

function datoNuevo(valor) {
	var id = valor.id;
	var idItem = $("#" + id).data("id");

	$('#idMenuNuevo').val(idItem);

}

function datoNuevoSub(valor) {
	var id = valor.id;
	var idItem = $("#" + id).data("id");

	$('#idMenuNuevoSub').val(idItem);

}

function datoEditSub(valor) {
	var id = valor.id;
	var idItemSub = $("#" + id).data("id");
	var idvista = $("#" + id).data("vista");
	var descripcion = $("#" + id).data("descripcion");
	var icono = $("#" + id).data("icono");
	var url = $("#" + id).data("url");

	$('#idEditSub').val(idItemSub);
	$('#idVistasEdit').val(idvista);
	$('#editSub').val(descripcion);
	$('#editSubIcono').val(icono);
	$('#editSubUrl').val(url);

}

function dato(valor) {
	var id = valor.id;
	var idItem = $("#" + id).data("id");
	var tipo = $("#" + id).data("tipo");
	var descripcion = $("#" + id).data("descripcion");
	var icono = $("#" + id).data("icono");
	var url = $("#" + id).data("url");
	var orden = $("#" + id).data("orden");
	var idVistaMenu = $("#" + id).data("vistamenu");

	$('#idEdit').val(idItem);
	$('#tipoEdit').val(tipo).change();
	$('#edit').val(descripcion);
	$('#editIcono').val(icono);
	$('#editUrl').val(url);
	$('#editOrden').val(orden);
	$('#idMenuVistasEdit').val(idVistaMenu);
}

function datoSegmento(valor) {
	var id = valor.id;
	var index = $("#" + id).data("id");
	var descripcion = $("#" + id).data("value");
	var orden = $("#" + id).data("orden");
	var idPerfilMenu = $("#" + id).data("idmenuperfil");
	$('#idSegmento').val(index);
	$('#editSegmento').val(descripcion);
	$('#idPerfilMenu').val(idPerfilMenu);
	$('#ordenSegmento').val(orden);
}

function saveEditSegmento() {


	var valid = validarForm();
	if (valid) {
		var id = $('#idSegmento').val();
		var descripcion = $('#editSegmento').val();
		var orden = $('#ordenSegmento').val();
		var idPerfilMenu = $('#idPerfilMenu').val();
		$.ajax({
			"url": "saveEditSegmento",
			"type": "POST",
			"data": { "id": id, "descripcion": descripcion, "orden": orden, "idPerfilMenu": idPerfilMenu },
			success: function(rerspuesta) {
				$('body').removeClass('modal-open');
				$('.modal-backdrop').remove();
				successToast("Dato Actualizado");
				$('#refresh').click()
			},
			error: function(data) {
				console.log(data);
				errorToast("Ha ocurrido un error, Intenta de nuevo.");
			},
		});
	} else {
		warningToast("Faltan campos, que son requeridos...");
	}

}

function saveNuevo() {


	var valid = validarForm();
	if (valid) {
		var idMenu = $('#idMenuNuevo').val();
		var tipo = $('#tipoNuevo').val();
		var descripcion = $('#nuevo').val();
		var icono = $('#nuevoIcono').val();
		var url = $('#nuevoUrl').val();
		var orden = $('#nuevoOrden').val();


		$.ajax({
			"url": "saveNuevoItem",
			"type": "POST",
			"data": { "id": idMenu, "tipo": tipo, "descripcion": descripcion, "icono": icono, "url": url, "orden": orden },
			success: function(respuesta) {

				if (respuesta.data === 1) {
					$('body').removeClass('modal-open');
					$('.modal-backdrop').remove();
					successToast("Item Creado");
					$('#refresh').click();
				} else {
					$('body').removeClass('modal-open');
					$('.modal-backdrop').remove();
					errorToast("No ha sido posible crear");
					$('#refresh').click();
				}

			},
			error: function(data) {
				console.log(data);
				errorToast("Ha ocurrido un error, Intenta de nuevo.");
			},
		});
	} else {
		warningToast("Faltan campos, que son requeridos...");
	}

}

function saveNuevoSub() {


	var valid = validarFormSub();
	if (valid) {
		var idMenu = $('#idMenuNuevoSub').val();
		var descripcion = $('#nuevoSub').val();
		var icono = $('#nuevoSubIcono').val();
		var url = $('#nuevoSubUrl').val();


		$.ajax({
			"url": "saveNuevoSubItem",
			"type": "POST",
			"data": { "id": idMenu, "descripcion": descripcion, "icono": icono, "url": url },
			success: function(respuesta) {

				if (respuesta.data === 1) {
					$('body').removeClass('modal-open');
					$('.modal-backdrop').remove();
					successToast("Item Creado");
					$('#refresh').click();
				} else {
					$('body').removeClass('modal-open');
					$('.modal-backdrop').remove();
					errorToast("No ha sido posible crear");
					$('#refresh').click();
				}

			},
			error: function(data) {
				console.log(data);
				errorToast("Ha ocurrido un error, Intenta de nuevo.");
			},
		});
	} else {
		warningToast("Faltan campos, que son requeridos..."); 9
	}

}

function saveEdit() {


	var valid = validarForm();
	if (valid) {
		//var id = $('#id').val();
		//var tipo = $('#tipo').val();
		//var descripcion = $('#edit').val();

		var idItem = $('#idEdit').val();
		var tipo = $('#tipoEdit').val();
		var descripcion = $('#edit').val();
		var icono = $('#editIcono').val();
		var url = $('#editUrl').val();
		var orden = $('#editOrden').val();
		var idVistaMenu = $('#idMenuVistasEdit').val();


		$.ajax({
			"url": "saveEdit",
			"type": "POST",
			"data": { "id": idItem, "tipo": tipo, "descripcion": descripcion, "icono": icono, "url": url, "orden": orden, "idVistaMenu": idVistaMenu },
			success: function(respuesta) {
				//console.log("--> " + respuesta.data);
				if (respuesta.data === 1) {
					$('body').removeClass('modal-open');
					$('.modal-backdrop').remove();
					successToast("Dato Actualizado");
					$('#refresh').click();
				} else {
					$('body').removeClass('modal-open');
					$('.modal-backdrop').remove();
					errorToast("No se puede editar");
					$('#refresh').click();
				}

			},
			error: function(data) {
				console.log(data);
				errorToast("Ha ocurrido un error, Intenta de nuevo.");
			},
		});
	} else {
		warningToast("Faltan campos, que son requeridos...");
	}

}

function saveNewSegmento() {
	var valid = validarForm2();
	if (valid) {

		var idPerfil = $('#idPerfil').val();
		var newSegmento = $('#nuevoSegmento').val();
		var orden = $('#newOrden').val();
		$.ajax({
			"url": "saveNewSegmento",
			"type": "POST",
			"data": {
				"newSegmento": newSegmento, "orden": orden, "idPerfil": idPerfil
			},
			success: function(respuesta) {
				$('body').removeClass('modal-open');
				$('.modal-backdrop').remove();
				$('#ModalMenu').modal('hide')
				successToast("Dato Actualizado");
				$('#refresh').click();
				$('#nuevoSegmento').val("");
				$('#newOrden').val(0);


			},
			error: function(data) {
				console.log(data);
				errorToast("Ha ocurrido un error, Intenta de nuevo.");
			},
		});
	} else {
		warningToast("Faltan campos, que son requeridos...");
	}
}

function saveSubEdit() {
	var valid = validarFormSubEdit();
	if (valid) {

		var idVista = $('#idEditSub').val();
		var idVistaSub = $('#idVistasEdit').val();
		var descripcion = $('#editSub').val();
		var icono = $('#editSubIcono').val();
		var url = $('#editSubUrl').val();

		$.ajax({
			"url": "saveEditSubMenu",
			"type": "POST",
			"data": {
				"id": idVista, "idVistaSub": idVistaSub, "descripcion": descripcion, "icono": icono, "url": url
			},
			success: function(respuesta) {
				$('body').removeClass('modal-open');
				$('.modal-backdrop').remove();
				$('#ModalEditSub').modal('hide')
				successToast("Dato Actualizado");
				$('#refresh').click();


			},
			error: function(data) {
				console.log(data);
				errorToast("Ha ocurrido un error, Intenta de nuevo.");
			},
		});
	} else {
		warningToast("Faltan campos, que son requeridos...");
	}
}

function deleteSegmento(valor) {

	$.ajax({
		"url": "deleteSegmento",
		"type": "POST",
		"data": {
			"idMenu": valor
		},
		success: function(respuesta) {
			if (respuesta.data === 0) {
				errorToast("Imposible borrar, tiene contenido");
			} else if (respuesta.data === 1) {
				successToast("Segmento Eliminado");
			} else if (respuesta.data === 2) {
				errorToast("Ha ocurrido, un error");
			}
			$('#refresh').click();

		},
		error: function(data) {
			console.log(data);
			errorToast("Ha ocurrido un error, Intenta de nuevo.");
		},
	});

}

function deleteItem(valor) {

	$.ajax({
		"url": "deleteItem",
		"type": "POST",
		"data": {
			"idVistas": valor
		},
		success: function(respuesta) {
			if (respuesta.data === 0) {
				errorToast("Imposible borrar, tiene contenido");
			} else if (respuesta.data === 1) {
				successToast("Item Eliminado");
			} else if (respuesta.data === 2) {
				errorToast("Ha ocurrido, un error");
			}
			$('#refresh').click();

		},
		error: function(data) {
			console.log(data);
			errorToast("Ha ocurrido un error, Intenta de nuevo.");
		},
	});

}

function deleteItemSub(valor) {

	$.ajax({
		"url": "deleteItemSub",
		"type": "POST",
		"data": {
			"idVistas": valor
		},
		success: function(respuesta) {
			if (respuesta.data === 0) {
				errorToast("Imposible borrar, tiene contenido");
			} else if (respuesta.data === 1) {
				successToast("Item Eliminado");
			} else if (respuesta.data === 2) {
				errorToast("Ha ocurrido, un error");
			}
			$('#refresh').click();

		},
		error: function(data) {
			console.log(data);
			errorToast("Ha ocurrido un error, Intenta de nuevo.");
		},
	});

}

function validarForm2() {
	var validador = $("#newSegmento").validate();

	return validador.form();
}

function validarForm() {
	var validador = $("#formEdit").validate();

	return validador.form();
}

function validarFormSub() {
	var validador = $("#formNuevoSub").validate();

	return validador.form();
}

function validarFormSubEdit() {
	var validador = $("#formEditSub").validate();

	return validador.form();
}