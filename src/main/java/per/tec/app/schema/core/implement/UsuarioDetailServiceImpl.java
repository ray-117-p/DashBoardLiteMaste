package per.tec.app.schema.core.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.PerfilPermiso;
import per.tec.app.schema.core.entities.Usuario;
import per.tec.app.schema.core.service.UsuarioService;

@Service
public class UsuarioDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioService.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
		} else if (usuario.getEstatus() == false) {
			throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
		}else if (usuario.getPerfil().getEstatus() == false) {
			throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
		}
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(usuario.getPerfil().getDescripcion()));
		for (PerfilPermiso permisos : usuario.getPerfil().getPerfilPermisos()) {
			if (permisos.getActivo() == true) {		
				roles.add(new SimpleGrantedAuthority(permisos.getCatPermiso().getPermiso()));
			}
		}
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEstatus() == true ? true : true, true,
				true, true, roles);

	}

}
