package per.tec.app.schema.core.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.Usuario;
import per.tec.app.schema.core.repository.UsuarioRepository;
import per.tec.app.schema.core.service.UsuarioService;

@Service
public class UsuarioImplement implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByIdUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByIdUsuario(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsByIdUsuario(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByEstatus(Boolean estatus) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByEstatus(estatus);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByEstatus(Boolean estatus) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsByEstatus(estatus);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsername(username);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsByUsername(username);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByMaterno(String materno) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByMaterno(materno);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByMaterno(String materno) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsByMaterno(materno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByNombre(String nombre) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByPassword(String password) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByPassword(password);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByPassword(String password) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsByPassword(password);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByPaterno(String paterno) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByPaterno(paterno);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByPaterno(String paterno) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsByPaterno(paterno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByPerfil(perfil);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsByPerfil(perfil);
	}

	@Override
	@Transactional
	public void deleteUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.delete(usuario);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAllUsuario() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();

	}

	@Override
	@Transactional
	public Usuario saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAllUserName(String nombreUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUserName(nombreUsuario);
	}

	/*
	 *
	 * PAGE
	 * 
	 **/

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> listar(Pageable pageable, int idTipoPerfil) {
		Page<Usuario> listUsuarios = null;
		if (idTipoPerfil == 1) {
			listUsuarios = usuarioRepository.findAll(pageable);
		} else {
			listUsuarios = usuarioRepository.findAllAdministrador(pageable);
		} // end of if-else
		return listUsuarios;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> listarLike(Pageable pageable, String search, int idTipoPerfil) {
		Page<Usuario> listUsuarios = null;
		if (idTipoPerfil == 1) {
			listUsuarios = usuarioRepository.listarLike(search, pageable);
		} else {
			listUsuarios = usuarioRepository.listarLikeAdministrador(search, pageable);
		} // end of if-else
		return listUsuarios;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> listarOrder(Pageable pageable, String tipoOrder, String colum, int idTipoPerfil) {
		Page<Usuario> listUsuarios = null;
		if (tipoOrder.equals("desc")) {
			listUsuarios = getColumnDesc(colum, idTipoPerfil, pageable);
		} else {
			listUsuarios = getColumnAsc(colum, idTipoPerfil, pageable);
		} // end of if-else
		return listUsuarios;
	}

	@Transactional(readOnly = true)
	public Page<Usuario> getColumnDesc(String column, int idTipoPerfil, Pageable pageable) {
		Page<Usuario> listUsuarios = null;
		if (idTipoPerfil == 1) {
			switch (column) {
			case "0":
				listUsuarios = usuarioRepository.findAllNombreDesc(pageable);
				break;
			case "1":
				listUsuarios = usuarioRepository.findAllPaternoDesc(pageable);
				break;
			case "2":
				listUsuarios = usuarioRepository.findAllMaternoDesc(pageable);
				break;
			case "3":
				listUsuarios = usuarioRepository.findAllUserDesc(pageable);
				break;
			case "4":
				listUsuarios = usuarioRepository.findAllPerfilDesc(pageable);
				break;
			default:
				break;
			}// end of switch
		} else if (idTipoPerfil == 2) {
			switch (column) {
			case "0":
				listUsuarios = usuarioRepository.findAllNombreDescAdministrador(pageable);
				break;
			case "1":
				listUsuarios = usuarioRepository.findAllPaternoDescAdministrador(pageable);
				break;
			case "2":
				listUsuarios = usuarioRepository.findAllMaternoDescAdministrador(pageable);
				break;
			case "3":
				listUsuarios = usuarioRepository.findAllUserDescAdministrador(pageable);
				break;
			case "4":
				listUsuarios = usuarioRepository.findAllPerfilDescAdministrador(pageable);
				break;
			default:
				break;
			}// end of switch
		} // end of if-else-if
		return listUsuarios;
	}

	@Transactional(readOnly = true)
	public Page<Usuario> getColumnAsc(String column, int idTipoPerfil, Pageable pageable) {
		Page<Usuario> listUsuarios = null;
		if (idTipoPerfil == 1) {
			switch (column) {
			case "0":
				listUsuarios = usuarioRepository.findAllNombreAsc(pageable);
				break;
			case "1":
				listUsuarios = usuarioRepository.findAllPaternoAsc(pageable);
				break;
			case "2":
				listUsuarios = usuarioRepository.findAllMaternoAsc(pageable);
				break;
			case "3":
				listUsuarios = usuarioRepository.findAllUserAsc(pageable);
				break;
			case "4":
				listUsuarios = usuarioRepository.findAllPerfilAsc(pageable);
				break;
			default:
				break;
			}// end of switch
		} else {
			switch (column) {
			case "0":
				listUsuarios = usuarioRepository.findAllNombreAscAdministrador(pageable);
				break;
			case "1":
				listUsuarios = usuarioRepository.findAllPaternoAscAdministrador(pageable);
				break;
			case "2":
				listUsuarios = usuarioRepository.findAllMaternoAscAdministrador(pageable);
				break;
			case "3":
				listUsuarios = usuarioRepository.findAllUserAscAdministrador(pageable);
				break;
			case "4":
				listUsuarios = usuarioRepository.findAllPerfilAscAdministrador(pageable);
				break;
			default:
				break;
			}// end of switch
		} // end of if-else-if
		return listUsuarios;
	}

	////////////

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> listarLikeOrder(Pageable pageable, String search, String tipoOrder, String colum,
			int idTipoPerfil) {
		Page<Usuario> listUsuarios = null;
		if (tipoOrder.equals("desc")) {
			listUsuarios = getColumnLikeDesc(colum, search, idTipoPerfil, pageable);
		} else {
			listUsuarios = getColumnLikeAsc(colum, search, idTipoPerfil, pageable);
		} // end of if-else
		return listUsuarios;
	}

	@Transactional(readOnly = true)
	public Page<Usuario> getColumnLikeDesc(String column, String search, int idTipoPerfil, Pageable pageable) {
		Page<Usuario> listUsuarios = null;
		if (idTipoPerfil == 1) {
			switch (column) {
			case "0":
				listUsuarios = usuarioRepository.listarLikeNombreDesc(search, pageable);
				break;
			case "1":
				listUsuarios = usuarioRepository.listarLikePaternoDesc(search, pageable);
				break;
			case "2":
				listUsuarios = usuarioRepository.listarLikeMaternoDesc(search, pageable);
				break;
			case "3":
				listUsuarios = usuarioRepository.listarLikeUserDesc(search, pageable);
				break;
			case "4":
				listUsuarios = usuarioRepository.listarLikePerfilDesc(search, pageable);
				break;
			default:
				break;
			}// end of switch
		} else if (idTipoPerfil == 2) {
			switch (column) {
			case "0":
				listUsuarios = usuarioRepository.listarLikeNombreDescAdministrador(search, pageable);
				break;
			case "1":
				listUsuarios = usuarioRepository.listarLikePaternoDescAdministrador(search, pageable);
				break;
			case "2":
				listUsuarios = usuarioRepository.listarLikeMaternoDescAdministrador(search, pageable);
				break;
			case "3":
				listUsuarios = usuarioRepository.listarLikeUserDescAdministrador(search, pageable);
				break;
			case "4":
				listUsuarios = usuarioRepository.listarLikePerfilDescAdministrador(search, pageable);
				break;
			default:
				break;
			}// end of switch
		} // end of if-else-if
		return listUsuarios;
	}

	@Transactional(readOnly = true)
	public Page<Usuario> getColumnLikeAsc(String column, String search, int idTipoPerfil, Pageable pageable) {
		Page<Usuario> listUsuarios = null;
		if (idTipoPerfil == 1) {
			switch (column) {
			case "0":
				listUsuarios = usuarioRepository.listarLikeNombreAsc(search, pageable);
				break;
			case "1":
				listUsuarios = usuarioRepository.listarLikePaternoAsc(search, pageable);
				break;
			case "2":
				listUsuarios = usuarioRepository.listarLikeMaternoAsc(search, pageable);
				break;
			case "3":
				listUsuarios = usuarioRepository.listarLikeUserAsc(search, pageable);
				break;
			case "4":
				listUsuarios = usuarioRepository.listarLikePerfilAsc(search, pageable);
				break;
			default:
				break;
			}// end of switch¿
		} else if (idTipoPerfil == 2) {
			switch (column) {
			case "0":
				listUsuarios = usuarioRepository.listarLikeNombreAscAdministrador(search, pageable);
				break;
			case "1":
				listUsuarios = usuarioRepository.listarLikePaternoAscAdministrador(search, pageable);
				break;
			case "2":
				listUsuarios = usuarioRepository.listarLikeMaternoAscAdministrador(search, pageable);
				break;
			case "3":
				listUsuarios = usuarioRepository.listarLikeUserAscAdministrador(search, pageable);
				break;
			case "4":
				listUsuarios = usuarioRepository.listarLikePerfilAscAdministrador(search, pageable);
				break;
			default:
				break;
			}// end of switch
		} // end of if-else-if
		return listUsuarios;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findByIdUsuarioOptional(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUuid(uuid);
	}

}
