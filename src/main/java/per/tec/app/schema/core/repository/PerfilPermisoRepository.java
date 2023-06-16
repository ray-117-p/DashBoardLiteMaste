package per.tec.app.schema.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import per.tec.app.schema.core.entities.CatPermiso;
import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.PerfilPermiso;

public interface PerfilPermisoRepository extends PagingAndSortingRepository<PerfilPermiso, Serializable> {

	public abstract List<PerfilPermiso> findAll();

	public abstract List<PerfilPermiso> findByIdPerfilPermiso(int idPerfilPermiso);

	public abstract boolean existsByIdPerfilPermiso(int idPerfilPermiso);

	public abstract List<PerfilPermiso> findByActivo(Boolean activo);

	public abstract boolean existsByActivo(Boolean activo);

	public abstract List<PerfilPermiso> findByCatPermiso(CatPermiso catPermiso);

	public abstract boolean existsByCatPermiso(CatPermiso catPermiso);

	public abstract List<PerfilPermiso> findByPerfil(Perfil perfil);

	public abstract boolean existsByPerfil(Perfil perfil);

	@Query("SELECT p FROM PerfilPermiso p WHERE p.perfil.idPerfil = ?1")
	public List<PerfilPermiso> findAllXIdPerfil(int idPerfil);

}
