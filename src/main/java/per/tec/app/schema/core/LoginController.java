package per.tec.app.schema.core;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import per.tec.app.schema.core.entities.ConfiguracionInterfaz;
import per.tec.app.schema.core.service.ConfiguracionInterfazService;
import per.tec.app.schema.core.view.View;

@Controller
public class LoginController {

	@Autowired
	BuildProperties buildProperties;

	@Autowired
	private ConfiguracionInterfazService configuracionInterfazService;

	private final static Log logger = LogFactory.getLog(LoginController.class);

	@GetMapping(value = { "/", "/login" })
	public String login(Model model, Principal principal,
			@RequestParam(value = "error", required = false) boolean error, RedirectAttributes redirectAttributes) {

		if (principal != null) {
			return "redirect:/index";
		}

		if (error == true) {
			model.addAttribute("errorToast", "Usuario / Contraseña incorrectos.");
		}
		List<ConfiguracionInterfaz> lstConfig = configuracionInterfazService.findAllConfiguracionInterfaz();
		Collections.sort(lstConfig, new Comparator<ConfiguracionInterfaz>() {
			@Override
			public int compare(ConfiguracionInterfaz p1, ConfiguracionInterfaz p2) {
				return p1.getIdConfiguracion().compareTo(p2.getIdConfiguracion());
			}
		});
		String estilosLogin = "";
		int i = 0;
		for (ConfiguracionInterfaz item : lstConfig) {
			if (i > 7) {
				estilosLogin = item.getDescripcion();
				break;
			}
			i++;
		}
		model.addAttribute("estilosLogin", estilosLogin);
		model.addAttribute("projectV", buildProperties.getVersion());

		return View.LOGIN;
	}

}
