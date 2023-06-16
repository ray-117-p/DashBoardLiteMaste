package per.tec.app.schema.core.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.CatTipoPerfil;
import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.repository.PerfilRepository;
import per.tec.app.schema.core.service.PerfilService;

@Service
public class PerfilImplement implements PerfilService {

	@Autowired
	PerfilRepository perfilRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Perfil> findByIdPerfil(int idPerfil) {
		// TODO Auto-generated method stub
		return perfilRepository.findByIdPerfil(idPerfil);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdPerfil(int idPerfil) {
		// TODO Auto-generated method stub
		return perfilRepository.existsByIdPerfil(idPerfil);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perfil> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return perfilRepository.findByDescripcion(descripcion);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return perfilRepository.existsByDescripcion(descripcion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perfil> findByEstatus(Boolean estatus) {
		// TODO Auto-generated method stub
		return perfilRepository.findByEstatus(estatus);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByEstatus(Boolean estatus) {
		// TODO Auto-generated method stub
		return perfilRepository.existsByEstatus(estatus);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perfil> findByIndex(String index) {
		// TODO Auto-generated method stub
		return perfilRepository.findByIndex(index);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIndex(String index) {
		// TODO Auto-generated method stub
		return perfilRepository.existsByIndex(index);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perfil> findByCatTipoPerfil(CatTipoPerfil catTipoPerfil) {
		// TODO Auto-generated method stub
		return perfilRepository.findByCatTipoPerfil(catTipoPerfil);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByCatTipoPerfil(CatTipoPerfil catTipoPerfil) {
		// TODO Auto-generated method stub
		return perfilRepository.existsByCatTipoPerfil(catTipoPerfil);
	}

	@Override
	@Transactional
	public void deletePerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		perfilRepository.delete(perfil);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Perfil> findAllPerfil() {
		// TODO Auto-generated method stub
		return perfilRepository.findAll();

	}

	@Override
	@Transactional
	public Perfil savePerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return perfilRepository.save(perfil);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perfil> findAllSuperUserLimit() {
		// TODO Auto-generated method stub
		return perfilRepository.findAllSuperUserLimit();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Perfil> findAllUsers() {
		// TODO Auto-generated method stub
		return perfilRepository.findAllUsers();
	}

}
