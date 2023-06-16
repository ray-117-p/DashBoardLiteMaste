package per.tec.app.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import per.tec.app.schema.core.entities.CatSchema;
import per.tec.app.schema.core.entities.ConfiguracionInterfaz;
import per.tec.app.schema.core.entities.MenuVista;
import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.PerfilMenu;
import per.tec.app.schema.core.entities.Usuario;
import per.tec.app.schema.core.service.CatSchemaService;
import per.tec.app.schema.core.service.ConfiguracionInterfazService;
import per.tec.app.schema.core.service.PerfilMenuService;
import per.tec.app.schema.core.service.PerfilService;
import per.tec.app.schema.core.service.UsuarioService;

@Component
public class UsuarioAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired(required=true)
	BuildProperties buildProperties;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private ConfiguracionInterfazService configuracionInterfazService;

	@Autowired
	private PerfilMenuService perfilMenuService;

	@Autowired
	private CatSchemaService catSchemaService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Perfil perfil = new Perfil();
		CatSchema schema = new CatSchema();
		List<Perfil> lstPerfilUsuario = perfilService.findByEstatus(true);
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		for (GrantedAuthority grantedAuthority : authorities) {

			for (Perfil perfilUsuario : lstPerfilUsuario) {

				if (perfilUsuario.getDescripcion().equals(grantedAuthority.getAuthority())) {

					String url = grantedAuthority.getAuthority();
					perfil = perfilService.findByDescripcion(url).get(0);
					schema = catSchemaService.findByIdSchema(2).get(0);

					if (grantedAuthority.getAuthority().equals("SUPER_ADMIN")) {
						String v = "Build Version: " + buildProperties.getVersion();
						request.getSession().setAttribute("projectV", v);
					}

					List<PerfilMenu> lstPerfilMenu = perfilMenuService.findByPerfil(perfilUsuario);
					Collections.sort(lstPerfilMenu, new Comparator<PerfilMenu>() {
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

					request.getSession().setAttribute("lstPerfilMenu", lstPerfilMenu);
					request.getSession().setAttribute("usuario", usuario);
					request.getSession().setAttribute("home", perfil.getIndex());
					request.getSession().setAttribute("NombreSchema", schema.getNombre());
					request.getSession().setAttribute("idTipoPerfil", perfil.getCatTipoPerfil().getIdTipoPerfil());
					request.getSession().setAttribute("perfil", grantedAuthority.getAuthority());

					List<ConfiguracionInterfaz> lstConfig = configuracionInterfazService.findAllConfiguracionInterfaz();
					Collections.sort(lstConfig, new Comparator<ConfiguracionInterfaz>() {

						@Override
						public int compare(ConfiguracionInterfaz p1, ConfiguracionInterfaz p2) {
							return new Integer(p1.getIdConfiguracion()).compareTo(new Integer(p2.getIdConfiguracion()));
						}
					});
					String estilosCss = "";
					int i = 0;
					for (ConfiguracionInterfaz item : lstConfig) {
						if (i > 7) {
							break;
						}
						if (item.getIdConfiguracion() == 4 && item.getActivo() == true) {
							estilosCss += item.getDescripcion();
						} else if (item.getIdConfiguracion() != 4) {
							estilosCss += item.getDescripcion();
						}
						i++;
					}

					request.getSession().setAttribute("estilosCss", estilosCss);
					break;
				}

			}

		}

		redirectStrategy.sendRedirect(request, response, perfil.getIndex());
	}

}
