package per.tec.app.schema.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import per.tec.app.schema.core.entities.Menu;
import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.PerfilMenu;

public interface PerfilMenuRepository extends PagingAndSortingRepository<PerfilMenu, Serializable> {

	public abstract List<PerfilMenu> findAll();

	public abstract List<PerfilMenu> findByIdPerfilMenu(int idPerfilMenu);

	public abstract boolean existsByIdPerfilMenu(int idPerfilMenu);

	public abstract List<PerfilMenu> findByEstatus(Boolean estatus);

	public abstract boolean existsByEstatus(Boolean estatus);

	public abstract List<PerfilMenu> findByOrden(Integer orden);

	public abstract boolean existsByOrden(Integer orden);

	public abstract List<PerfilMenu> findByMenu(Menu menu);

	public abstract boolean existsByMenu(Menu menu);

	public abstract List<PerfilMenu> findByPerfil(Perfil perfil);

	public abstract boolean existsByPerfil(Perfil perfil);

}
