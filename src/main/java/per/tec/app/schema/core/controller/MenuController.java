package per.tec.app.schema.core.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import per.tec.app.schema.core.entities.MenuVista;
import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.PerfilMenu;
import per.tec.app.schema.core.service.PerfilMenuService;
import per.tec.app.schema.core.service.PerfilService;
import per.tec.app.schema.core.view.View;

@Controller
public class MenuController {

	private static final Logger logger = Logger.getLogger(MenuController.class);

	@Autowired
	private PerfilMenuService perfilMenuService;

	@Autowired
	private PerfilService perfilService;

	@Secured("ROLE_CORE_MENU")
	@PostMapping("/administrarMenu")
	public String AdministrarMenu(Model model,
			@RequestParam(name = "idPerfil", required = true, defaultValue = "0") int idPerfil) {

		Perfil nuevoPerfil = perfilService.findByIdPerfil(idPerfil).get(0);
		model.addAttribute("idPerfil", nuevoPerfil.getIdPerfil());
		model.addAttribute("fragment", "fragment/core/menu/menu.html");
		return View.INDEX;
	}

	@Secured("ROLE_CORE_MENU")
	@RequestMapping("/framentMenu")
	public String framentMenu(Model model, @RequestParam int perfil) {

		Perfil i = new Perfil();
		i.setIdPerfil(perfil);
		List<PerfilMenu> lstPerfilMenu = new ArrayList<>();
		lstPerfilMenu.clear();

		lstPerfilMenu = perfilMenuService.findByPerfil(i);

		Collections.sort(lstPerfilMenu, new Comparator<PerfilMenu>() {
			@SuppressWarnings("removal")
			@Override
			public int compare(PerfilMenu p1, PerfilMenu p2) {
				return new Integer(p1.getOrden()).compareTo(new Integer(p2.getOrden()));
			}
		});
		for (PerfilMenu item : lstPerfilMenu) {
			Collections.sort(item.getMenu().getMenuVistas(), new Comparator<MenuVista>() {
				@Override
				public int compare(MenuVista p1, MenuVista p2) {
					return new Integer(p1.getOrden()).compareTo(new Integer(p2.getOrden()));
				}
			});
		}

		model.addAttribute("lstPerfilMenuDinamic", lstPerfilMenu);
		return "fragment/core/menu/menuFrament :: showMenu";
	}

}