package per.tec.app.schema.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import per.tec.app.schema.core.entities.Usuario;
import per.tec.app.schema.core.service.UsuarioService;
import per.tec.app.schema.core.view.View;

@Controller
@SessionAttributes({ "perfil", "usuario", "projectV" })
public class IndexController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/index")
	public String index(Model model, Authentication authentication) {

		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		model.addAttribute("usuario", usuario);
		model.addAttribute("perfil", usuario.getPerfil().getDescripcion());
		model.addAttribute("fragment", "fragment/principal/principal.html");
		return View.INDEX;
	}

}
