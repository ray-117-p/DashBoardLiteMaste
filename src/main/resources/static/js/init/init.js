$(document).ready(function() {
	/******SELECT*****/
	$('.buscar').select2({
		theme: "bootstrap4",
		placeholder: "Seleccione...",
		width: '100%'
	});
	
	$('.buscar-multi').select2({
		placeholder: "Seleccione...",
		width: '100%',
		multiple:true,
		maximumSelectionLength: 3
	});

	/******DATA TABLES*****/
	$(function() {
		$('#tableDatos')
			.DataTable(
				{
					'paging': true,
					'lengthChange': false,
					'searching': true,
					'ordering': true,
					'info': true,
					'autoWidth': false,
					"pageLength": 20,
					language: {
						"decimal": "",
						"emptyTable": "No hay información",
						"info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
						"infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
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
					}
				})
	});

	$(function() {
		$('#tableDatosReporte')
			.DataTable(
				{
					'paging': true,
					'lengthChange': false,
					'searching': true,
					'ordering': true,
					'info': true,
					'autoWidth': false,
					"pageLength": 20,
					language: {
						"decimal": "",
						"emptyTable": "No hay información",
						"info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
						"infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
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
					}
				})
	});

});

