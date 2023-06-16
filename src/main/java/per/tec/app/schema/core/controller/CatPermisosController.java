package per.tec.app.schema.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import per.tec.app.schema.core.entities.CatPermiso;
import per.tec.app.schema.core.pojos.DataTable;
import per.tec.app.schema.core.service.CatPermisoService;
import per.tec.app.schema.core.service.CatSchemaService;
import per.tec.app.schema.core.view.View;

@Controller
public class CatPermisosController {

	private static final Logger logger = Logger.getLogger(CatPermisosController.class);

	@Autowired
	private CatPermisoService catPermisoService;

	@Autowired
	private CatSchemaService catSchemaService;

	@Secured("ROLE_CORE_CAT_PERMISOS")
	@GetMapping("/permisos")
	public String permisos(Model model) {
		model.addAttribute("lstCatSchema", catSchemaService.findAllCatSchema());
		model.addAttribute("fragment", "fragment/core/cat_permisos/cat_permisos.html");
		return View.INDEX;
	}

	/*** PAGEABLE ****/
	@Secured("ROLE_CORE_CAT_PERMISOS")
	@GetMapping("/listAllCatPermisos")
	public ResponseEntity listAllCatPermisos(@RequestParam(value = "draw") int draw,
			@RequestParam(value = "start") int start, @RequestParam(value = "length") int length,
			HttpServletRequest request) {

		DataTable dataTable = new DataTable();
		String search = request.getParameter("search[value]");
		String tipoOrder = "";
		String colum = "";
		try {
			tipoOrder = request.getParameter("order[0][dir]");
			colum = request.getParameter("order[0][column]");
		} catch (Exception e) {
			tipoOrder = "";
			colum = "";
		}

		int page = start / length;
		Pageable pageable = PageRequest.of(page, length);
		Page<CatPermiso> responseData = null;

		if (!search.equals("")) {
			if (!tipoOrder.equals("")) {
				responseData = catPermisoService.listarLikeOrder(pageable, search.toUpperCase(), tipoOrder, colum);
			} else {
				responseData = catPermisoService.listarLike(pageable, search.toUpperCase());
			} // end of if-else tipoOrder
		} else {
			if (!tipoOrder.equals("")) {
				responseData = catPermisoService.listarOrder(pageable, tipoOrder, colum);
			} else {
				responseData = catPermisoService.listar(pageable);
			} // end of if-else tipoOrder
		} // end of if-else search

		try {
			dataTable.setData(responseData.getContent());
			dataTable.setRecordsTotal(responseData.getTotalElements());
			dataTable.setRecordsFiltered(responseData.getTotalElements());

			dataTable.setDraw(draw);
			dataTable.setStart(start);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ResponseEntity.ok(dataTable);
	}// END OF PAGEABLE
}
