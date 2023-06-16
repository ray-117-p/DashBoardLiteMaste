package per.tec.app.schema.core.restController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import per.tec.app.schema.core.entities.Menu;
import per.tec.app.schema.core.entities.MenuVista;
import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.PerfilMenu;
import per.tec.app.schema.core.entities.Vista;
import per.tec.app.schema.core.service.MenuService;
import per.tec.app.schema.core.service.MenuVistaService;
import per.tec.app.schema.core.service.PerfilMenuService;
import per.tec.app.schema.core.service.VistaService;

@RestController
public class RestControllerMenu {

	private static final Log LOG = LogFactory.getLog(RestControllerMenu.class);

	@Autowired
	private MenuService menuService;

	@Autowired
	private VistaService vistaService;

	@Autowired
	private MenuVistaService menuVistaService;

	@Autowired
	private PerfilMenuService perfilMenuService;

	@RequestMapping(value = "/saveNewSegmento", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response saveNewSegmento(@RequestParam String newSegmento, @RequestParam int orden,
			@RequestParam int idPerfil) {

		Menu Segmento = new Menu();
		Segmento.setDescripcion(newSegmento);
		Segmento = menuService.saveMenu(Segmento);

		PerfilMenu perfilMenu = new PerfilMenu();

		Perfil perfil = new Perfil();
		perfil.setIdPerfil(idPerfil);

		perfilMenu.setPerfil(perfil);
		perfilMenu.setMenu(Segmento);
		perfilMenu.setEstatus(true);
		perfilMenu.setOrden(orden);
		perfilMenuService.savePerfilMenu(perfilMenu);

		return new Response("OK", "OK");
	}

	@RequestMapping(value = "/saveEditSegmento", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response saveEditSegmento(@RequestParam int id, @RequestParam String descripcion, @RequestParam int orden,
			@RequestParam int idPerfilMenu) {

		// LOG.info("id :: " + id);
		// LOG.info("descripcion :: " + descripcion);

		Menu segmento = menuService.findByIdMenu(id).get(0);
		segmento.setDescripcion(descripcion);
		menuService.saveMenu(segmento);

		PerfilMenu perfilMenu = perfilMenuService.findByIdPerfilMenu(idPerfilMenu).get(0);
		perfilMenu.setOrden(orden);
		perfilMenuService.savePerfilMenu(perfilMenu);

		return new Response("OK", "OK");
	}

	@RequestMapping(value = "/saveNuevoItem", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response saveNuevoItem(@RequestParam int id, @RequestParam String tipo, @RequestParam String descripcion,
			@RequestParam String icono, @RequestParam String url, @RequestParam int orden) {

		int bandera = 0;
		Menu menu = new Menu();
		menu.setIdMenu(id);
		switch (tipo) {
		case "I":
			try {
				Vista itemLink = new Vista();
				itemLink.setDescripcion(descripcion);
				itemLink.setTipo(tipo);
				itemLink.setIcono(icono);
				itemLink.setUrl(url);
				vistaService.saveVista(itemLink);

				MenuVista menuVista = new MenuVista();

				menuVista.setMenu(menu);
				menuVista.setVista(itemLink);
				menuVista.setOrden(orden);
				menuVistaService.saveMenuVista(menuVista);
				bandera = 1;

			} catch (Exception e) {
				bandera = 0;
			}
			break;

		case "S":
			try {
				Vista item = new Vista();
				item.setDescripcion(descripcion);
				item.setTipo(tipo);
				item.setIcono(icono);
				item.setUrl("");
				vistaService.saveVista(item);

				MenuVista menuVista = new MenuVista();
				menuVista.setMenu(menu);
				menuVista.setVista(item);
				menuVista.setOrden(orden);
				menuVistaService.saveMenuVista(menuVista);
				bandera = 1;

			} catch (Exception e) {
				bandera = 0;
			}
			break;

		default:
			break;
		}

		return new Response("OK", bandera);
	}

	@RequestMapping(value = "/saveNuevoSubItem", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response saveNuevoSubItem(@RequestParam int id, @RequestParam String descripcion, @RequestParam String icono,
			@RequestParam String url) {

		int bandera = 0;
		Vista principal = new Vista();
		principal.setIdVistas(id);

		try {
			Vista itemLink = new Vista();
			itemLink.setDescripcion(descripcion);
			itemLink.setTipo("I");
			itemLink.setIcono(icono);
			itemLink.setUrl(url);
			itemLink.setVista(principal);
			vistaService.saveVista(itemLink);

			bandera = 1;

		} catch (Exception e) {
			bandera = 0;
		}

		return new Response("OK", bandera);
	}

	@RequestMapping(value = "/saveEditSubMenu", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response saveEditSubMenu(@RequestParam int id, @RequestParam int idVistaSub,
			@RequestParam String descripcion, @RequestParam String icono, @RequestParam String url) {

		int bandera = 0;
		Vista principal = new Vista();
		principal.setIdVistas(idVistaSub);

		try {
			Vista itemLink = vistaService.findByIdVistas(id).get(0);
			itemLink.setDescripcion(descripcion);
			itemLink.setTipo("I");
			itemLink.setIcono(icono);
			itemLink.setUrl(url);
			itemLink.setVista(principal);
			vistaService.saveVista(itemLink);

			bandera = 1;

		} catch (Exception e) {
			bandera = 0;
		}

		return new Response("OK", bandera);
	}

	@RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response saveEdit(@RequestParam int id, @RequestParam String tipo, @RequestParam String descripcion,
			@RequestParam String icono, @RequestParam String url, @RequestParam int orden,
			@RequestParam int idVistaMenu) {

		// LOG.info("id :: " + id);
		// LOG.info("tipo :: " + tipo);
		// LOG.info("descripcion :: " + descripcion);
		int bandera = 0;
		switch (tipo) {
		case "I":
			try {
				Vista itemLink = vistaService.findByIdVistas(id).get(0);
				if (itemLink.getVistas() == null || itemLink.getVistas().isEmpty()) {
					itemLink.setDescripcion(descripcion);
					itemLink.setTipo(tipo);
					itemLink.setIcono(icono);
					itemLink.setUrl(url);
					vistaService.saveVista(itemLink);

					MenuVista menuVista = menuVistaService.findByIdMenuVistas(idVistaMenu).get(0);
					menuVista.setOrden(orden);
					menuVistaService.saveMenuVista(menuVista);
					bandera = 1;
				} else {
					bandera = 0;
				}
			} catch (Exception e) {
				bandera = 0;
			}
			break;

		case "S":
			try {
				Vista item = vistaService.findByIdVistas(id).get(0);
				item.setDescripcion(descripcion);
				item.setTipo(tipo);
				item.setIcono(icono);
				item.setUrl("");
				vistaService.saveVista(item);

				MenuVista menuVista = menuVistaService.findByIdMenuVistas(idVistaMenu).get(0);
				menuVista.setOrden(orden);
				menuVistaService.saveMenuVista(menuVista);
				bandera = 1;

			} catch (Exception e) {
				bandera = 0;
			}
			break;

		default:
			break;
		}

		return new Response("OK", bandera);
	}

	@RequestMapping(value = "/deleteSegmento", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response deleteSegmento(@RequestParam int idMenu) {

		int bandera = 0;
		Menu segmento = menuService.findByIdMenu(idMenu).get(0);
		if (segmento.getMenuVistas().isEmpty()) {
			try {
				PerfilMenu perfilMenu = new PerfilMenu();
				perfilMenu = segmento.getPerfilMenus().get(0);

				perfilMenuService.deletePerfilMenu(perfilMenu);

				menuService.deleteMenu(segmento);

				bandera = 1;
			} catch (Exception e) {
				bandera = 2;
			}
		} else {
			bandera = 0;
		}

		return new Response("OK", bandera);
	}

	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response deleteItem(@RequestParam int idVistas) {

		int bandera = 0;

		Vista vistas = vistaService.findByIdVistas(idVistas).get(0);

		if (vistas.getVistas().isEmpty()) {
			try {
				MenuVista menuVista = new MenuVista();
				menuVista = vistas.getMenuVistas().get(0);

				menuVistaService.deleteMenuVista(menuVista);

				vistaService.deleteVista(vistas);

				bandera = 1;
			} catch (Exception e) {
				bandera = 2;
			}
		} else {
			bandera = 0;
		}

		return new Response("OK", bandera);
	}

	@RequestMapping(value = "/deleteItemSub", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.REQUIRED)
	public Response deleteItemSub(@RequestParam int idVistas) {

		int bandera = 0;

		Vista vistas = vistaService.findByIdVistas(idVistas).get(0);

		try {

			vistaService.deleteVista(vistas);

			bandera = 1;
		} catch (Exception e) {
			bandera = 2;
		}

		return new Response("OK", bandera);
	}

}
