package per.tec.app.schema.core.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import per.tec.app.schema.core.entities.CatSchema;
import per.tec.app.schema.core.entities.ConfiguracionInterfaz;
import per.tec.app.schema.core.pojos.InterfazConfig;
import per.tec.app.schema.core.service.CatSchemaService;
import per.tec.app.schema.core.service.ConfiguracionInterfazService;
import per.tec.app.schema.core.view.View;

@Controller
public class ConfiguracionController {

	private static final Logger logger = Logger.getLogger(ConfiguracionController.class);

	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	private InterfazConfig listConfiguracionInterfaz = (InterfazConfig) context.getBean("configuracionInterfazList");

	@Autowired
	private ConfiguracionInterfazService configuracionInterfazService;

	@Autowired
	private CatSchemaService catSchemaService;

	
	@Secured("ROLE_CORE_INTERFAZ")
	@GetMapping("/interfaz")
	public String interfaz(Model model,
			@SessionAttribute(name = "NombreSchema", required = true) String NombreSchema) {

		List<ConfiguracionInterfaz> lstConfig = configuracionInterfazService.findAllConfiguracionInterfaz();

		Collections.sort(lstConfig, new Comparator<ConfiguracionInterfaz>() {

			@Override
			public int compare(ConfiguracionInterfaz p1, ConfiguracionInterfaz p2) {
				return p1.getIdConfiguracion().compareTo(p2.getIdConfiguracion());
			}
		});

		listConfiguracionInterfaz.setConfiguracionInterfaz(lstConfig);
		model.addAttribute("lstConfig", listConfiguracionInterfaz);
		model.addAttribute("NombreSchema", NombreSchema);
		model.addAttribute("fragment", "fragment/core/configuracion/configuracion.html");
		return View.INDEX;
	}

	@Secured("ROLE_CORE_INTERFAZ")
	@PostMapping("/saveConfiguracionInterfaz")
	public String saveConfiguracionInterfaz(Model model, InterfazConfig listConfiguracionInterfaz,
			@RequestParam("nombreSystem") String nombreSystem, RedirectAttributes redirectAttributes) {

		List<ConfiguracionInterfaz> lstConfig = configuracionInterfazService.findAllConfiguracionInterfaz();

		CatSchema schema = catSchemaService.findByIdSchema(2).get(0);
		schema.setNombre(nombreSystem);

		catSchemaService.saveCatSchema(schema);

		if (!lstConfig.isEmpty()) {
			for (ConfiguracionInterfaz itemLstConfig : lstConfig) {
				for (ConfiguracionInterfaz item : listConfiguracionInterfaz.getConfiguracionInterfaz()) {

					if (item.getIdConfiguracion() == itemLstConfig.getIdConfiguracion()) {

						if (item.getIdConfiguracion() == 4) {
							itemLstConfig.setColor(item.getColor());
							itemLstConfig.setActivo(item.getActivo());
							itemLstConfig.setDescripcion(item.getDescripcion());
						} else {
							itemLstConfig.setColor(item.getColor());
							itemLstConfig.setDescripcion(item.getDescripcion());
						}
						break;
					} // end of if

				} // end of for ConfiguracionInterfaz item
				configuracionInterfazService.saveConfiguracionInterfaz(itemLstConfig);
			} // end of for ConfiguracionInterfaz itemLstConfig
		} else {
			for (ConfiguracionInterfaz item : listConfiguracionInterfaz.getConfiguracionInterfaz()) {

				ConfiguracionInterfaz newItem = new ConfiguracionInterfaz();

				newItem.setColor(item.getColor());
				newItem.setActivo(item.getActivo());
				newItem.setDescripcion(item.getDescripcion());

				configuracionInterfazService.saveConfiguracionInterfaz(newItem);
			} // end of for ConfiguracionInterfaz item
		}

		redirectAttributes.addFlashAttribute("status", 1);
		return "redirect:/configuracion";
	}

	@GetMapping("/interfazPageLogin")
	public ModelAndView interfazPage(Model model) {

		return new ModelAndView("fragment/core/configuracion/login");
	}

}
