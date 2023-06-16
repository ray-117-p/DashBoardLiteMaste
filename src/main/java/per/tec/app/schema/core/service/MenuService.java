package per.tec.app.schema.core.service;

import java.util.List;

import per.tec.app.schema.core.entities.Menu;

public interface MenuService {

	public List<Menu> findByIdMenu(int idMenu);

	public boolean existsByIdMenu(int idMenu);

	public List<Menu> findByDescripcion(String descripcion);

	public boolean existsByDescripcion(String descripcion);

	public Menu saveMenu(Menu menu);

	void deleteMenu(Menu menu);

	public List<Menu> findAllMenu();
}
