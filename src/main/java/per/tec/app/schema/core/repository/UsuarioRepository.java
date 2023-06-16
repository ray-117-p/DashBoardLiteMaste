package per.tec.app.schema.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Serializable> {

	public abstract List<Usuario> findAll();

	public abstract List<Usuario> findByIdUsuario(int idUsuario);

	public abstract boolean existsByIdUsuario(int idUsuario);

	public abstract List<Usuario> findByEstatus(Boolean estatus);

	public abstract boolean existsByEstatus(Boolean estatus);

	public abstract Usuario findByUsername(String username);

	public abstract boolean existsByUsername(String username);

	public abstract List<Usuario> findByMaterno(String materno);

	public abstract boolean existsByMaterno(String materno);

	public abstract List<Usuario> findByNombre(String nombre);

	public abstract boolean existsByNombre(String nombre);

	public abstract List<Usuario> findByPassword(String password);

	public abstract boolean existsByPassword(String password);

	public abstract List<Usuario> findByPaterno(String paterno);

	public abstract boolean existsByPaterno(String paterno);

	public abstract List<Usuario> findByPerfil(Perfil perfil);

	public abstract boolean existsByPerfil(Perfil perfil);

	public abstract Usuario findByUuid(String uuid);

	@Query("SELECT u FROM Usuario u WHERE u.username LIKE %?1% ")
	public List<Usuario> findByUserName(String username);

	/*
	 *
	 * PAGE
	 * 
	 **/
	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1)")
	public Page<Usuario> findAll(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1) ORDER BY u.nombre ASC")
	public Page<Usuario> findAllNombreAsc(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1) ORDER BY u.nombre DESC")
	public Page<Usuario> findAllNombreDesc(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1) ORDER BY u.paterno ASC")
	public Page<Usuario> findAllPaternoAsc(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1) ORDER BY u.paterno DESC")
	public Page<Usuario> findAllPaternoDesc(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1) ORDER BY u.materno ASC")
	public Page<Usuario> findAllMaternoAsc(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1) ORDER BY u.materno DESC")
	public Page<Usuario> findAllMaternoDesc(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1) ORDER BY u.username ASC")
	public Page<Usuario> findAllUserAsc(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1) ORDER BY u.username DESC")
	public Page<Usuario> findAllUserDesc(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1) ORDER BY u.perfil.descripcion ASC")
	public Page<Usuario> findAllPerfilAsc(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil  WHERE tp.idTipoPerfil NOT IN (1) ORDER BY u.perfil.descripcion DESC")
	public Page<Usuario> findAllPerfilDesc(Pageable pageable);

	/*
	 * LIKES
	 **/
	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1)")
	public Page<Usuario> listarLike(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) ORDER BY u.nombre ASC")
	public Page<Usuario> listarLikeNombreAsc(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) ORDER BY u.nombre DESC")
	public Page<Usuario> listarLikeNombreDesc(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) ORDER BY u.paterno ASC")
	public Page<Usuario> listarLikePaternoAsc(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) ORDER BY u.paterno DESC")
	public Page<Usuario> listarLikePaternoDesc(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) ORDER BY u.materno ASC")
	public Page<Usuario> listarLikeMaternoAsc(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) ORDER BY u.materno DESC")
	public Page<Usuario> listarLikeMaternoDesc(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) ORDER BY u.username ASC")
	public Page<Usuario> listarLikeUserAsc(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) ORDER BY u.username DESC")
	public Page<Usuario> listarLikeUserDesc(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) ORDER BY u.perfil.descripcion ASC")
	public Page<Usuario> listarLikePerfilAsc(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) ORDER BY u.perfil.descripcion DESC")
	public Page<Usuario> listarLikePerfilDesc(String search, Pageable pageable);

	/*
	 *
	 * PAGE Administrador
	 * 
	 **/
	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2)")
	public Page<Usuario> findAllAdministrador(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.nombre ASC")
	public Page<Usuario> findAllNombreAscAdministrador(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.nombre DESC")
	public Page<Usuario> findAllNombreDescAdministrador(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.paterno ASC")
	public Page<Usuario> findAllPaternoAscAdministrador(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.paterno DESC")
	public Page<Usuario> findAllPaternoDescAdministrador(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.materno ASC")
	public Page<Usuario> findAllMaternoAscAdministrador(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.materno DESC")
	public Page<Usuario> findAllMaternoDescAdministrador(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.username ASC")
	public Page<Usuario> findAllUserAscAdministrador(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.username DESC")
	public Page<Usuario> findAllUserDescAdministrador(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.perfil.descripcion ASC")
	public Page<Usuario> findAllPerfilAscAdministrador(Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.perfil.descripcion DESC")
	public Page<Usuario> findAllPerfilDescAdministrador(Pageable pageable);

	/*
	 * LIKES Administrador
	 **/
	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2)")
	public Page<Usuario> listarLikeAdministrador(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.nombre ASC")
	public Page<Usuario> listarLikeNombreAscAdministrador(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.nombre DESC")
	public Page<Usuario> listarLikeNombreDescAdministrador(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.paterno ASC")
	public Page<Usuario> listarLikePaternoAscAdministrador(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.paterno DESC")
	public Page<Usuario> listarLikePaternoDescAdministrador(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.materno ASC")
	public Page<Usuario> listarLikeMaternoAscAdministrador(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.materno DESC")
	public Page<Usuario> listarLikeMaternoDescAdministrador(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.username ASC")
	public Page<Usuario> listarLikeUserAscAdministrador(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.username DESC")
	public Page<Usuario> listarLikeUserDescAdministrador(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.perfil.descripcion ASC")
	public Page<Usuario> listarLikePerfilAscAdministrador(String search, Pageable pageable);

	@Query("SELECT u FROM Usuario u INNER JOIN u.perfil p ON u.perfil.idPerfil = p.idPerfil INNER JOIN p.catTipoPerfil tp ON p.catTipoPerfil.idTipoPerfil= tp.idTipoPerfil WHERE u.nombre LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.paterno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.materno LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.username LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) OR u.perfil.descripcion LIKE %?1% AND tp.idTipoPerfil NOT IN (1) AND tp.idTipoPerfil NOT IN (2) ORDER BY u.perfil.descripcion DESC")
	public Page<Usuario> listarLikePerfilDescAdministrador(String search, Pageable pageable);

}
