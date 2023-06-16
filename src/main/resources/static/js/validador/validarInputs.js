function validarInput(valor) {
	idInput = valor.id;
	//console.log(valor.id);
	if ($("#" + idInput).val().length > 0) {
		// console.log("ddddd");
		$("#" + idInput).removeClass("is-invalid");
		$("#" + idInput).addClass("is-valid");
	} else {
		$("#" + idInput).removeClass("is-valid");
		$("#" + idInput).addClass("is-invalid");
	}
}

function validarInputForm(valor) {
	idInput = valor.id;
	if ($("#" + idInput).val().length > 0) {
		// console.log("ddddd");
		$("#" + idInput).removeClass("is-invalid");
		$("#" + idInput).addClass("is-valid");
	} else {
		$("#" + idInput).removeClass("is-valid");
		$("#" + idInput).addClass("is-invalid");
	}
}


function validarRFCSize() {
	if ($("#rfc").val().length > 0) {
		if ($("#rfc").val().length >= 12 && $("#rfc").val().length <= 13) {
			$("#rfc").removeClass("is-invalid");
			$("#rfc").addClass("is-valid");
		} else {
			$("#rfc").removeClass("is-valid");
			$("#rfc").addClass("is-invalid");
		}
	} else {
		$("#rfc").removeClass("is-valid");
		$("#rfc").addClass("is-invalid");
	}
}

function inputValido(valor) {
	$("#" + valor).removeClass("is-invalid");
	$("#" + valor).addClass("is-valid");
}

function inputInvalido(valor) {
	$("#" + valor).removeClass("is-valid");
	$("#" + valor).addClass("is-invalid");
}

function validarTelefono(valor) {
	idInput = valor.id;
	if ($("#" + idInput).val().length == 10) {
		// console.log("ddddd");
		$("#" + idInput).removeClass("is-invalid");
		$("#" + idInput).addClass("is-valid");
	} else {
		$("#" + idInput).removeClass("is-valid");
		$("#" + idInput).addClass("is-invalid");
	}
}

function validarInputEdad(valor) {
	idInput = valor.id;
	if ($("#" + idInput).val().length > 0) {
		if ($("#" + idInput).val() >= 0 && $("#" + idInput).val() <= 110) {
			$("#" + idInput).removeClass("is-invalid");
			$("#" + idInput).addClass("is-valid");
		} else {
			$("#" + idInput).removeClass("is-valid");
			$("#" + idInput).addClass("is-invalid");
		}
	} else {
		$("#" + idInput).removeClass("is-valid");
		$("#" + idInput).addClass("is-invalid");
	}
}

function telefonoNum(e) {
	var key = window.event ? e.which : e.keyCode;
	if (key < 48 || key > 57) {
		e.preventDefault();
	}
}

function OnlyNum(e) {
	var key = window.event ? e.which : e.keyCode;
	if (key < 48 || key > 57) {
		e.preventDefault();
	}
}



