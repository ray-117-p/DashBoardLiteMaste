package per.tec.app.schema.core.service;

import java.util.List;

import per.tec.app.schema.core.entities.CatTipoPerfil;

public interface CatTipoPerfilService {

	public List<CatTipoPerfil> findByIdTipoPerfil(Integer idTipoPerfil);

	public boolean existsByIdTipoPerfil(Integer idTipoPerfil);

	public List<CatTipoPerfil> findByDescripcion(String descripcion);

	public boolean existsByDescripcion(String descripcion);

	public CatTipoPerfil saveCatTipoPerfil(CatTipoPerfil catTipoPerfil);

	void deleteCatTipoPerfil(CatTipoPerfil catTipoPerfil);

	public List<CatTipoPerfil> findAllCatTipoPerfil();

	public List<CatTipoPerfil> findAdminCatTipoPerfil();

	public List<CatTipoPerfil> findUserCatTipoPerfil();
}
