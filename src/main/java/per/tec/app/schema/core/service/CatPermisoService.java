package per.tec.app.schema.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import per.tec.app.schema.core.entities.CatPermiso;
import per.tec.app.schema.core.entities.CatSchema;

public interface CatPermisoService {

	public List<CatPermiso> findByIdPermiso(Integer idPermiso);

	public boolean existsByIdPermiso(Integer idPermiso);

	public List<CatPermiso> findByPermiso(String permiso);

	public boolean existsByPermiso(String permiso);

	public CatPermiso saveCatPermiso(CatPermiso catPermiso);

	void deleteCatPermiso(CatPermiso catPermiso);

	public List<CatPermiso> findAllCatPermiso();

	public List<CatPermiso> findAllAdminCatPermiso();

	public List<CatPermiso> findUserCatPermiso();

	public List<CatPermiso> findByCatSchema(CatSchema catSchema);

	public boolean existsByCatSchema(CatSchema catSchema);

	/*
	 *
	 * PAGE
	 * 
	 **/
	public Page<CatPermiso> listar(Pageable pageable);

	public Page<CatPermiso> listarLike(Pageable pageable, String search);

	public Page<CatPermiso> listarOrder(Pageable pageable, String tipoOrder, String colum);

	public Page<CatPermiso> listarLikeOrder(Pageable pageable, String search, String tipoOrder, String colum);
}
