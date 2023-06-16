$(document).ready(function() {
	validar_check();
});

function previewInterfaz() {
	nav_top_background = document.getElementById('nav_top_background').value;
	nav_top_font = document.getElementById('nav_top_font').value;
	nav_left_background = document.getElementById('nav_left_background').value;
	lineas_usuario = document.getElementById('lineas_usuario').value;
	nav_left_font_items = document.getElementById('nav_left_font_items').value;
	nav_left_font_segmentos = document.getElementById('nav_left_font_segmentos').value;
	nav_left_cuadro_icono_menu = document.getElementById('nav_left_cuadro_icono_menu').value;
	nav_left_font_icono_menu = document.getElementById('nav_left_font_icono_menu').value;

	//////////////////////////////////////////////
	const sheet = new CSSStyleSheet();
	////////////////////////////////////////////

	var NAV_TOP = '.navbar {background:' + nav_top_background + ';}';
	document.getElementById('NAV_TOP').value = NAV_TOP;
	sheet.insertRule(NAV_TOP);

	////////////////////////////////////////////

	var NAV_TOP_TEXT = '.navbar > .navbar-brand a , .navbar > .dropdown .nav-link{color:' + nav_top_font + '; cursor: pointer;text-decoration:none;}';
	document.getElementById('NAV_TOP_TEXT').value = NAV_TOP_TEXT;
	sheet.insertRule(NAV_TOP_TEXT);

	////////////////////////////////////////////

	var NAV_IZQ = '.chiller-theme .sidebar-wrapper {background: ' + nav_left_background + '; }';
	document.getElementById('NAV_IZQ').value = NAV_IZQ;
	sheet.insertRule(NAV_IZQ);

	////////////////////////////////////////////

	if ($('#colorLineaUsuario').prop('checked')) {
		var NAV_USER = '.chiller-theme .sidebar-wrapper .sidebar-header, .chiller-theme .sidebar-wrapper .sidebar-search,.chiller-theme .sidebar-wrapper .sidebar-menu {border-top: 1px solid ' + lineas_usuario + ';}';
		document.getElementById('NAV_USER').value = NAV_USER;
		sheet.insertRule(NAV_USER);
	}

	////////////////////////////////////////////

	var NAV_ITEM = '.chiller-theme .sidebar-wrapper .sidebar-header .user-info, .chiller-theme .sidebar-wrapper .sidebar-header  .user-info .user-role ,.chiller-theme .sidebar-wrapper .sidebar-header .user-info .user-status, .chiller-theme .sidebar-wrapper .sidebar-search input.search-menu, .chiller-theme .sidebar-wrapper .sidebar-search .input-group-text, .chiller-theme .sidebar-wrapper .sidebar-brand>a, .chiller-theme .sidebar-wrapper .sidebar-menu ul li a, .chiller-theme .sidebar-footer>a {color: ' + nav_left_font_items + ';}';
	document.getElementById('NAV_ITEM').value = NAV_ITEM;
	sheet.insertRule(NAV_ITEM);

	////////////////////////////////////////////

	var NAV_SEGMENTOS = '.chiller-theme .sidebar-wrapper .sidebar-menu .header-menu span {color: ' + nav_left_font_segmentos + ';}';
	document.getElementById('NAV_SEGMENTOS').value = NAV_SEGMENTOS;
	sheet.insertRule(NAV_SEGMENTOS);

	////////////////////////////////////////////

	var NAV_CUADRO_MENU_ICONO = '.chiller-theme .sidebar-wrapper .sidebar-menu ul  li a  i  {background: ' + nav_left_cuadro_icono_menu + ';}';
	document.getElementById('NAV_CUADRO_MENU_ICONO').value = NAV_CUADRO_MENU_ICONO;
	sheet.insertRule(NAV_CUADRO_MENU_ICONO);

	////////////////////////////////////////////

	var NAV_ICONO = '.chiller-theme .sidebar-wrapper .sidebar-menu ul  li a  i {color: ' + nav_left_font_icono_menu + ';}';
	document.getElementById('NAV_ICONO').value = NAV_ICONO;
	sheet.insertRule(NAV_ICONO);

	////////////////////////////////////////////

	document.adoptedStyleSheets = [sheet];

	colorPrincipal = document.getElementById('colorPrincipal').value;
	colorSecundario = document.getElementById('colorSecundario').value;
	colorTexto = document.getElementById('colorTexto').value;


	var styleLogin = 'body{background-image:linear-gradient(to bottom,' + colorPrincipal + ',' + colorSecundario + ');} '
		+ ' .header-image svg {position: relative; fill: '+colorPrincipal+' !important;}'
		+ ' .header-image-particle {position: absolute; border-radius: 50%; background-color: '+colorPrincipal+' !important; opacity: 0.8;}'
		+ ' .button {width: 100%; padding: 16px 16px; margin: 16px 0; border-radius: 8px; border: none; font-weight: 500; font-size: 16px; '
		+ ' color: var(--white); background-color: '+colorSecundario+'; -webkit-appearance: none; cursor: pointer; font-family: inherit; transition: background-color 200ms, color 200ms;}'
		+ ' .titulo_login{font-family: "Poppins", sans-serif; flex-direction: column; align-items: flex-start;  justify-content: center; color: '+colorTexto+';}';
	document.getElementById('colorPrincipalLogin').value = styleLogin;
	document.getElementById('colorSecundarioLogin').value = styleLogin;
	document.getElementById('colorTextoLogin').value = styleLogin;

	$("#preview").contents().find("head").append($("<style type='text/css'> " + styleLogin + " </style>"));
}

function validar_check() {
	if ($('#colorLineaUsuario').prop('checked')) {
		$("#lineas_usuario").removeAttr("disabled");
		$("#btnLienasUsuario").removeAttr("disabled");
	} else {
		$("#lineas_usuario").attr("disabled", "disabled");
		$("#btnLienasUsuario").attr("disabled", "disabled");
	}
}




function questionSwalConfigInterfaz(message) {
	Swal.fire({
		title: '¿Estás seguro (a) ?',
		text: message,
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Si,Guardar',
		cancelButtonText: 'No, Cancelar'
	}).then((result) => {
		if (result.value) {
			previewInterfaz();
			$('#formConfigInterfaz').submit();
		} else {
			console.log("XD");
		}
	})
}
