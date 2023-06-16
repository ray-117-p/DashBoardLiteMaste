package per.tec.app.schema.core.service;

import java.util.List;

import per.tec.app.schema.core.entities.Menu;
import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.PerfilMenu;

public interface PerfilMenuService {

	public List<PerfilMenu> findByIdPerfilMenu(int idPerfilMenu);

	public boolean existsByIdPerfilMenu(int idPerfilMenu);

	public List<PerfilMenu> findByEstatus(Boolean estatus);

	public boolean existsByEstatus(Boolean estatus);

	public List<PerfilMenu> findByOrden(int orden);

	public boolean existsByOrden(int orden);

	public List<PerfilMenu> findByMenu(Menu menu);

	public boolean existsByMenu(Menu menu);

	public List<PerfilMenu> findByPerfil(Perfil perfil);

	public boolean existsByPerfil(Perfil perfil);

	public PerfilMenu savePerfilMenu(PerfilMenu perfilMenu);

	void deletePerfilMenu(PerfilMenu perfilMenu);

	public List<PerfilMenu> findAllPerfilMenu();
}
