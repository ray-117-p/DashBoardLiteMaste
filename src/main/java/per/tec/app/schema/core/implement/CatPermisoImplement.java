package per.tec.app.schema.core.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.CatPermiso;
import per.tec.app.schema.core.entities.CatSchema;
import per.tec.app.schema.core.repository.CatPermisoRepository;
import per.tec.app.schema.core.service.CatPermisoService;

@Service
public class CatPermisoImplement implements CatPermisoService {

	@Autowired
	CatPermisoRepository catPermisoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<CatPermiso> findByIdPermiso(Integer idPermiso) {
		// TODO Auto-generated method stub
		return catPermisoRepository.findByIdPermiso(idPermiso);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdPermiso(Integer idPermiso) {
		// TODO Auto-generated method stub
		return catPermisoRepository.existsByIdPermiso(idPermiso);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CatPermiso> findByPermiso(String permiso) {
		// TODO Auto-generated method stub
		return catPermisoRepository.findByPermiso(permiso);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByPermiso(String permiso) {
		// TODO Auto-generated method stub
		return catPermisoRepository.existsByPermiso(permiso);
	}

	@Override
	@Transactional
	public void deleteCatPermiso(CatPermiso catPermiso) {
		// TODO Auto-generated method stub
		catPermisoRepository.delete(catPermiso);

	}

	@Override
	@Transactional(readOnly = true)
	public List<CatPermiso> findAllCatPermiso() {
		// TODO Auto-generated method stub
		return catPermisoRepository.findAll();

	}

	@Override
	@Transactional
	public CatPermiso saveCatPermiso(CatPermiso catPermiso) {
		// TODO Auto-generated method stub
		return catPermisoRepository.save(catPermiso);
	}

	@Override
	public List<CatPermiso> findByCatSchema(CatSchema catSchema) {
		// TODO Auto-generated method stub
		return catPermisoRepository.findByCatSchema(catSchema);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByCatSchema(CatSchema catSchema) {
		// TODO Auto-generated method stub
		return catPermisoRepository.existsByCatSchema(catSchema);
	}

	/*
	 *
	 * PAGE
	 * 
	 **/

	@Override
	@Transactional(readOnly = true)
	public Page<CatPermiso> listar(Pageable pageable) {
		Page<CatPermiso> listCatPermisos = catPermisoRepository.findAll(pageable);
		return listCatPermisos;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<CatPermiso> listarLike(Pageable pageable, String search) {
		Page<CatPermiso> listCatPermisos = catPermisoRepository.listarLike(search, pageable);
		return listCatPermisos;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<CatPermiso> listarOrder(Pageable pageable, String tipoOrder, String colum) {
		Page<CatPermiso> listCatPermisos = null;
		if (tipoOrder.equals("desc")) {
			listCatPermisos = getColumnDesc(colum, pageable);
		} else {
			listCatPermisos = getColumnAsc(colum, pageable);
		}

		return listCatPermisos;
	}

	@Transactional(readOnly = true)
	public Page<CatPermiso> getColumnDesc(String column, Pageable pageable) {

		Page<CatPermiso> listCatPermisos = null;

		switch (column) {
		case "0":
			listCatPermisos = catPermisoRepository.findAllPermisoDesc(pageable);
			break;
		case "1":
			listCatPermisos = catPermisoRepository.findAllSchemaDesc(pageable);
			break;
		default:
			break;
		}

		return listCatPermisos;
	}

	@Transactional(readOnly = true)
	public Page<CatPermiso> getColumnAsc(String column, Pageable pageable) {

		Page<CatPermiso> listCatPermisos = null;

		switch (column) {
		case "0":
			listCatPermisos = catPermisoRepository.findAllPermisoAsc(pageable);
			break;
		case "1":
			listCatPermisos = catPermisoRepository.findAllSchemaAsc(pageable);
			break;
		default:
			break;
		}

		return listCatPermisos;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<CatPermiso> listarLikeOrder(Pageable pageable, String search, String tipoOrder, String colum) {
		Page<CatPermiso> listCatPermisos = null;
		if (tipoOrder.equals("desc")) {
			listCatPermisos = getColumnLikeDesc(colum, search, pageable);
		} else {
			listCatPermisos = getColumnLikeAsc(colum, search, pageable);
		}
		return listCatPermisos;
	}

	@Transactional(readOnly = true)
	public Page<CatPermiso> getColumnLikeDesc(String column, String search, Pageable pageable) {

		Page<CatPermiso> listCatPermisos = null;

		switch (column) {
		case "0":
			listCatPermisos = catPermisoRepository.listarLikePermisoDesc(search, pageable);
			break;
		case "1":
			listCatPermisos = catPermisoRepository.listarLikeSchemaDesc(search, pageable);
			break;
		default:
			break;
		}

		return listCatPermisos;
	}

	@Transactional(readOnly = true)
	public Page<CatPermiso> getColumnLikeAsc(String column, String search, Pageable pageable) {

		Page<CatPermiso> listCatPermisos = null;

		switch (column) {
		case "0":
			listCatPermisos = catPermisoRepository.listarLikePermisoAsc(search, pageable);
			break;
		case "1":
			listCatPermisos = catPermisoRepository.listarLikeSchemaAsc(search, pageable);
			break;
		default:
			break;
		}

		return listCatPermisos;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CatPermiso> findUserCatPermiso() {
		// TODO Auto-generated method stub
		return catPermisoRepository.findUserCatPermiso();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CatPermiso> findAllAdminCatPermiso() {
		// TODO Auto-generated method stub
		return catPermisoRepository.findAllAdminCatPermiso();
	}

}
