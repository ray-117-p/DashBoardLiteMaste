package per.tec.app.schema.core.restController;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.Usuario;
import per.tec.app.schema.core.service.ConfiguracionInterfazService;
import per.tec.app.schema.core.service.PerfilService;
import per.tec.app.schema.core.service.UsuarioService;

@RestController
public class RestControllerUsuario {

	private static final Log logger = LogFactory.getLog(RestController.class);

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private ConfiguracionInterfazService configuracionInterfazService;

	@GetMapping("/findTipoPerfil/{idPerfil}")
	public Response findTipoPerfil(@PathVariable int idPerfil) {
		Perfil perfil = perfilService.findByIdPerfil(idPerfil).get(0);
		return new Response("OK", perfil.getCatTipoPerfil().getIdTipoPerfil());
	}

	@GetMapping("/cargarInterfaz")
	public Response cargarInterfaz() {
		return new Response("OK", configuracionInterfazService.findAllConfiguracionInterfaz());
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Secured({ "ROLE_CORE_CREATE_USUARIO" })
	@PostMapping("/saveUser")
	public Response saveUser(Usuario newUser, @RequestParam(name = "uuidArea") String uuidArea,
			@SessionAttribute(name = "idTipoPerfil", required = true) int idTipoPerfil) {
		try {
			newUser.setEstatus(true);
			newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
			UUID uuid = UUID.randomUUID();
			uuid = UUID.randomUUID();
			newUser.setUuid(uuid.toString());
			usuarioService.saveUsuario(newUser);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response("OK", "error");
		} // end of try-catch
		return new Response("OK", "success");
	}

	@GetMapping("/findUserByUuid/{uuid}")
	public Response findUserByUuid(@PathVariable(name = "uuid", required = true) String uuid) {
		try {
			return new Response("OK", usuarioService.findByUuid(uuid));
		} catch (Exception e) {
			return new Response("OK", "error");
		} // end of try-catch
	}

}
