package per.tec.app.schema.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import per.tec.app.schema.core.entities.Menu;

public interface MenuRepository extends PagingAndSortingRepository<Menu, Serializable> {

	public abstract List<Menu> findAll();

	public abstract List<Menu> findByIdMenu(int idMenu);

	public abstract boolean existsByIdMenu(int idMenu);

	public abstract List<Menu> findByDescripcion(String descripcion);

	public abstract boolean existsByDescripcion(String descripcion);

}
