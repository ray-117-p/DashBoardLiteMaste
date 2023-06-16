package per.tec.app.schema.core.service;

import java.util.List;

import per.tec.app.schema.core.entities.Menu;
import per.tec.app.schema.core.entities.MenuVista;
import per.tec.app.schema.core.entities.Vista;

public interface MenuVistaService {

	public List<MenuVista> findByIdMenuVistas(int idMenuVistas);

	public boolean existsByIdMenuVistas(int idMenuVistas);

	public List<MenuVista> findByOrden(int orden);

	public boolean existsByOrden(int orden);

	public List<MenuVista> findByMenu(Menu menu);

	public boolean existsByMenu(Menu menu);

	public List<MenuVista> findByVista(Vista vista);

	public boolean existsByVista(Vista vista);

	public MenuVista saveMenuVista(MenuVista menuVista);

	void deleteMenuVista(MenuVista menuVista);

	public List<MenuVista> findAllMenuVista();
}
