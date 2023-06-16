package per.tec.app.schema.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import per.tec.app.schema.core.entities.Menu;
import per.tec.app.schema.core.entities.MenuVista;
import per.tec.app.schema.core.entities.Vista;

public interface MenuVistaRepository extends PagingAndSortingRepository<MenuVista, Serializable> {

	public abstract List<MenuVista> findAll();

	public abstract List<MenuVista> findByIdMenuVistas(int idMenuVistas);

	public abstract boolean existsByIdMenuVistas(int idMenuVistas);

	public abstract List<MenuVista> findByOrden(int orden);

	public abstract boolean existsByOrden(int orden);

	public abstract List<MenuVista> findByMenu(Menu menu);

	public abstract boolean existsByMenu(Menu menu);

	public abstract List<MenuVista> findByVista(Vista vista);

	public abstract boolean existsByVista(Vista vista);

}
