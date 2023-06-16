package per.tec.app.schema.core.service;

import java.util.List;

import per.tec.app.schema.core.entities.CatPermiso;
import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.PerfilPermiso;

public interface PerfilPermisoService {

	public List<PerfilPermiso> findByIdPerfilPermiso(int idPerfilPermiso);

	public boolean existsByIdPerfilPermiso(int idPerfilPermiso);

	public List<PerfilPermiso> findByActivo(Boolean activo);

	public boolean existsByActivo(Boolean activo);

	public List<PerfilPermiso> findByCatPermiso(CatPermiso catPermiso);

	public boolean existsByCatPermiso(CatPermiso catPermiso);

	public List<PerfilPermiso> findByPerfil(Perfil perfil);

	public boolean existsByPerfil(Perfil perfil);

	public PerfilPermiso savePerfilPermiso(PerfilPermiso perfilPermiso);

	void deletePerfilPermiso(PerfilPermiso perfilPermiso);

	public List<PerfilPermiso> findAllPerfilPermiso();

	public abstract List<PerfilPermiso> findAllXIdPerfil(int idPerfil);
}
