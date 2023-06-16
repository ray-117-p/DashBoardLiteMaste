package per.tec.app.schema.core.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.Usuario;
import per.tec.app.schema.core.pojos.DataTable;
import per.tec.app.schema.core.service.PerfilService;
import per.tec.app.schema.core.service.UsuarioService;
import per.tec.app.schema.core.view.View;

@Controller
public class UsuarioController {

	private static final Logger logger = Logger.getLogger(UsuarioController.class);

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PerfilService perfilService;

	@Secured({ "ROLE_CORE_ALL_USUARIOS" })
	@GetMapping("/users")
	public String users(Model model, @SessionAttribute(name = "idTipoPerfil", required = true) int idTipoPerfil) {
		List<Perfil> lstPerfilUsuario = new ArrayList<Perfil>();
		if (idTipoPerfil == 1) {
			lstPerfilUsuario = perfilService.findAllSuperUserLimit();
		} else if (idTipoPerfil == 2) {
			lstPerfilUsuario = perfilService.findAllUsers();
		} // end of if-else
		model.addAttribute("newUser", new Usuario());
		model.addAttribute("lstPerfilUsuario", lstPerfilUsuario);
		model.addAttribute("fragment", "fragment/core/user/users.html");
		return View.INDEX;
	}

	@Secured({ "ROLE_CORE_VIEW_USUARIO" })
	@GetMapping("/editUser/{uuid}")
	public String editUser(Model model, @PathVariable(name = "uuid", required = true) String uuid,
			RedirectAttributes redirectAttributes,
			@SessionAttribute(name = "idTipoPerfil", required = true) int idTipoPerfil) {
		Usuario editUser = null;
		List<Perfil> lstPerfilUsuario = new ArrayList<Perfil>();
		try {
			editUser = usuarioService.findByUuid(uuid);
			if (idTipoPerfil == 1) {
				lstPerfilUsuario = perfilService.findAllSuperUserLimit();
			} else if (idTipoPerfil == 2) {
				lstPerfilUsuario = perfilService.findAllUsers();
			} // end of if-else
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorToast", " No es posible ver el usuario.");
			return "redirect:/users";
		}
		model.addAttribute("lstPerfilUsuario", lstPerfilUsuario);
		model.addAttribute("editUser", editUser);
		model.addAttribute("fragment", "fragment/core/user/update_user.html");
		return View.INDEX;
	}

	@Secured({ "ROLE_CORE_EDIT_USUARIO" })
	@PostMapping("/saveEditUser")
	public String saveEditUser(Model model, @ModelAttribute Usuario editUser, RedirectAttributes redirectAttributes) {
		try {
			Usuario usuarioBd = usuarioService.findByUuid(editUser.getUuid());
			usuarioBd.setNombre(editUser.getNombre());
			usuarioBd.setPaterno(editUser.getPaterno());
			usuarioBd.setMaterno(editUser.getMaterno());
			usuarioBd.setUsername(editUser.getUsername());
			usuarioBd.setPerfil(editUser.getPerfil());
			usuarioBd.setEstatus(editUser.getEstatus());
			usuarioService.saveUsuario(usuarioBd);
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorToast", " No se ha podido actualizar el usuario.");
			return "redirect:/users";
		}
		redirectAttributes.addFlashAttribute("successToast", " Usuario actualizado.");
		return "redirect:/users";
	}

	@Secured({ "ROLE_CORE_PASSWORD_USUARIOS" })
	@PostMapping("/updatePassword")
	public String updatePassword(Model model, @RequestParam(name = "uuidPassword", required = true) String uuidPassword,
			@RequestParam(name = "nuevaPassword", required = true, defaultValue = "admin") String nuevaPassword,
			RedirectAttributes redirectAttributes) {
		try {
			Usuario nuevoUsuario = usuarioService.findByUuid(uuidPassword);
			nuevoUsuario.setPassword(passwordEncoder.encode(nuevaPassword));
			usuarioService.saveUsuario(nuevoUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorToast", " No se ha podido cambiar la contraseña.");
			return "redirect:/users";
		}
		redirectAttributes.addFlashAttribute("successToast", " Contraseña Actualizada.");
		return "redirect:/users";
	}

	@Secured({ "ROLE_CORE_PROFILE" })
	@GetMapping("/profile_settings")
	public String profile_settings(Model model, @SessionAttribute(name = "usuario", required = true) Usuario usuario) {
		Usuario usuarioBd = usuarioService.findByUuid(usuario.getUuid());

		model.addAttribute("user", usuarioBd);
		model.addAttribute("fragment", "fragment/core/profile_settings/profile_settings.html");
		return View.INDEX;
	}

	@PostMapping("/saveChangePassword")
	public String saveChangePassword(Model model, @RequestParam(name = "uuid", required = true) String uuid,
			@RequestParam(name = "nuevaPassword", required = true, defaultValue = "") String nuevaPassword,
			@RequestParam(name = "confirmacionPassword", required = true, defaultValue = "") String confirmacionPassword,
			RedirectAttributes redirectAttributes) {
		try {
			Usuario passwordNuevoUsuario = usuarioService.findByUuid(uuid);
			if (nuevaPassword.equals(confirmacionPassword)) {
				passwordNuevoUsuario.setPassword(passwordEncoder.encode(nuevaPassword));
				usuarioService.saveUsuario(passwordNuevoUsuario);
			} else {
				redirectAttributes.addFlashAttribute("errorToast",
						" La contraseña deben ser iguales en los dos campos...");
				return "redirect:/profile_settings";
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorToast", " No se ha podido cambiar la contraseña.");
			return "redirect:/profile_settings";
		}
		redirectAttributes.addFlashAttribute("successToast", " La contraseña ha sido cambiada.");
		return "redirect:/logout";
	}

	@Secured({ "ROLE_CORE_ALL_USUARIOS" })
	@GetMapping("/listAllUsuarios")
	public ResponseEntity listAllUsuarios(@RequestParam(value = "draw") int draw,
			@RequestParam(value = "start") int start, @RequestParam(value = "length") int length,
			HttpServletRequest request, @SessionAttribute(name = "idTipoPerfil", required = true) int idTipoPerfil) {

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
		} // end of try-catch
		int page = start / length;
		Pageable pageable = PageRequest.of(page, length);
		Page<Usuario> responseData = null;
		if (!search.equals("")) {
			if (!tipoOrder.equals("")) {
				responseData = usuarioService.listarLikeOrder(pageable, search, tipoOrder, colum, idTipoPerfil);
			} else {
				responseData = usuarioService.listarLike(pageable, search, idTipoPerfil);
			} // end of if-else tipoOrder
		} else {
			if (!tipoOrder.equals("")) {
				responseData = usuarioService.listarOrder(pageable, tipoOrder, colum, idTipoPerfil);
			} else {
				responseData = usuarioService.listar(pageable, idTipoPerfil);
			} // end of if-else tipoOrder
		} // end of if-else search
		try {
			dataTable.setData(responseData.getContent());
			dataTable.setRecordsTotal(responseData.getTotalElements());
			dataTable.setRecordsFiltered(responseData.getTotalElements());

			dataTable.setDraw(draw);
			dataTable.setStart(start);
		} catch (Exception e) {
			e.printStackTrace();
		} // end of try-catch

		return ResponseEntity.ok(dataTable);
	}

}
