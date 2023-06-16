package per.tec.app.schema.core.service;

import java.util.List;

import per.tec.app.schema.core.entities.CatTipoPerfil;
import per.tec.app.schema.core.entities.Perfil;

public interface PerfilService {

	public List<Perfil> findByIdPerfil(int idPerfil);

	public boolean existsByIdPerfil(int idPerfil);

	public List<Perfil> findByDescripcion(String descripcion);

	public boolean existsByDescripcion(String descripcion);

	public List<Perfil> findByEstatus(Boolean estatus);

	public boolean existsByEstatus(Boolean estatus);

	public List<Perfil> findByIndex(String index);

	public boolean existsByIndex(String index);

	public List<Perfil> findByCatTipoPerfil(CatTipoPerfil catTipoPerfil);

	public boolean existsByCatTipoPerfil(CatTipoPerfil catTipoPerfil);

	public Perfil savePerfil(Perfil perfil);

	void deletePerfil(Perfil perfil);

	public List<Perfil> findAllPerfil();

	public List<Perfil> findAllSuperUserLimit();
	
	public List<Perfil> findAllUsers();
}
