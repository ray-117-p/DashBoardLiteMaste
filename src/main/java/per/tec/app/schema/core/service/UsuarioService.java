package per.tec.app.schema.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.Usuario;

public interface UsuarioService {

	public Optional<Usuario> findByIdUsuarioOptional(int idUsuario);

	public List<Usuario> findByIdUsuario(int idUsuario);

	public boolean existsByIdUsuario(int idUsuario);

	public List<Usuario> findByEstatus(Boolean estatus);

	public boolean existsByEstatus(Boolean estatus);

	public Usuario findByUsername(String username);

	public boolean existsByUsername(String username);

	public List<Usuario> findByMaterno(String materno);

	public boolean existsByMaterno(String materno);

	public List<Usuario> findByNombre(String nombre);

	public boolean existsByNombre(String nombre);

	public List<Usuario> findByPassword(String password);

	public boolean existsByPassword(String password);

	public List<Usuario> findByPaterno(String paterno);

	public boolean existsByPaterno(String paterno);

	public List<Usuario> findByPerfil(Perfil perfil);

	public boolean existsByPerfil(Perfil perfil);

	public Usuario saveUsuario(Usuario usuario);

	void deleteUsuario(Usuario usuario);

	public List<Usuario> findAllUsuario();

	public abstract List<Usuario> findAllUserName(String nombreUsuario);

	public abstract Usuario findByUuid(String uuid);

	/*
	 *
	 * PAGE
	 * 
	 **/
	public Page<Usuario> listar(Pageable pageable, int idTipoPerfil);

	public Page<Usuario> listarLike(Pageable pageable, String search, int idTipoPerfil);

	public Page<Usuario> listarOrder(Pageable pageable, String tipoOrder, String colum, int idTipoPerfil);

	public Page<Usuario> listarLikeOrder(Pageable pageable, String search, String tipoOrder, String colum,
			int idTipoPerfil);
}
