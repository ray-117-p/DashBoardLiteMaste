package per.tec.app.schema.core.restController;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import per.tec.app.schema.core.entities.CatPermiso;
import per.tec.app.schema.core.entities.CatSchema;
import per.tec.app.schema.core.service.CatPermisoService;
import per.tec.app.schema.core.service.CatSchemaService;

@RestController
public class RestControllerCatPermisos {

	private static final Log logger = LogFactory.getLog(RestController.class);

	@Autowired
	private CatPermisoService catPermisoService;

	@Autowired
	private CatSchemaService catSchemaService;

	@Secured("ROLE_CORE_CAT_PERMISOS")
	@GetMapping("/findCatPermisoById/{idPermiso}")
	public Response findCatPermisoById(@PathVariable(name = "idPermiso", required = true) int idPermiso) {

		List<CatPermiso> catPermiso = catPermisoService.findByIdPermiso(idPermiso);

		if (catPermiso.isEmpty()) {
			return new Response("OK", "error");
		} // end of if
		return new Response("OK", catPermiso.get(0));
	}

	@Secured("ROLE_CORE_CAT_PERMISOS")
	@PostMapping("/saveCatPermiso")
	public Response saveCatPermiso(
			@RequestParam(name = "idPermiso", required = true, defaultValue = "") String idPermiso,
			@RequestParam(name = "permiso", required = true, defaultValue = "") String permiso,
			@RequestParam(name = "schema", required = true, defaultValue = "") int schema) {

		try {
			CatSchema catSchema = catSchemaService.findByIdSchema(schema).get(0);
			CatPermiso nuevoPermiso = new CatPermiso();
			catSchema.setIdSchema(schema);
			nuevoPermiso.setCatSchema(catSchema);
			nuevoPermiso.setDescripcion(permiso);
			nuevoPermiso.setPermiso("ROLE_" + catSchema.getDescripcion() + "_" + permiso);
			if (idPermiso != null) {
				nuevoPermiso.setIdPermiso(Integer.parseInt(idPermiso));
			}
			catPermisoService.saveCatPermiso(nuevoPermiso);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response("OK", "error");
		} // end of try-catch
		return new Response("OK", "success");
	}

}
