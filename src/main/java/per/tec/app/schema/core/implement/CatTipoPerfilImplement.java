package per.tec.app.schema.core.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.CatTipoPerfil;
import per.tec.app.schema.core.repository.CatTipoPerfilRepository;
import per.tec.app.schema.core.service.CatTipoPerfilService;

@Service
public class CatTipoPerfilImplement implements CatTipoPerfilService {

	@Autowired
	CatTipoPerfilRepository catTipoPerfilRepository;

	@Override
	@Transactional(readOnly = true)
	public List<CatTipoPerfil> findByIdTipoPerfil(Integer idTipoPerfil) {
		// TODO Auto-generated method stub
		return catTipoPerfilRepository.findByIdTipoPerfil(idTipoPerfil);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdTipoPerfil(Integer idTipoPerfil) {
		// TODO Auto-generated method stub
		return catTipoPerfilRepository.existsByIdTipoPerfil(idTipoPerfil);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CatTipoPerfil> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return catTipoPerfilRepository.findByDescripcion(descripcion);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return catTipoPerfilRepository.existsByDescripcion(descripcion);
	}

	@Override
	@Transactional
	public void deleteCatTipoPerfil(CatTipoPerfil catTipoPerfil) {
		// TODO Auto-generated method stub
		catTipoPerfilRepository.delete(catTipoPerfil);

	}

	@Override
	@Transactional(readOnly = true)
	public List<CatTipoPerfil> findAllCatTipoPerfil() {
		// TODO Auto-generated method stub
		return catTipoPerfilRepository.findAll();

	}

	@Override
	@Transactional
	public CatTipoPerfil saveCatTipoPerfil(CatTipoPerfil catTipoPerfil) {
		// TODO Auto-generated method stub
		return catTipoPerfilRepository.save(catTipoPerfil);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CatTipoPerfil> findAdminCatTipoPerfil() {
		// TODO Auto-generated method stub
		return catTipoPerfilRepository.findAdminCatTipoPerfil();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CatTipoPerfil> findUserCatTipoPerfil() {
		// TODO Auto-generated method stub
		return catTipoPerfilRepository.findUserCatTipoPerfil();
	}

}
