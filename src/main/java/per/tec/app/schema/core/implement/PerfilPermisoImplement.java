package per.tec.app.schema.core.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.CatPermiso;
import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.PerfilPermiso;
import per.tec.app.schema.core.repository.PerfilPermisoRepository;
import per.tec.app.schema.core.service.PerfilPermisoService;

@Service
public class PerfilPermisoImplement implements PerfilPermisoService {

	@Autowired
	PerfilPermisoRepository perfilPermisoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<PerfilPermiso> findByIdPerfilPermiso(int idPerfilPermiso) {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.findByIdPerfilPermiso(idPerfilPermiso);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdPerfilPermiso(int idPerfilPermiso) {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.existsByIdPerfilPermiso(idPerfilPermiso);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PerfilPermiso> findByActivo(Boolean activo) {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.findByActivo(activo);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByActivo(Boolean activo) {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.existsByActivo(activo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PerfilPermiso> findByCatPermiso(CatPermiso catPermiso) {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.findByCatPermiso(catPermiso);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByCatPermiso(CatPermiso catPermiso) {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.existsByCatPermiso(catPermiso);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PerfilPermiso> findByPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.findByPerfil(perfil);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.existsByPerfil(perfil);
	}

	@Override
	@Transactional
	public void deletePerfilPermiso(PerfilPermiso perfilPermiso) {
		// TODO Auto-generated method stub
		perfilPermisoRepository.delete(perfilPermiso);

	}

	@Override
	@Transactional(readOnly = true)
	public List<PerfilPermiso> findAllPerfilPermiso() {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.findAll();

	}

	@Override
	@Transactional
	public PerfilPermiso savePerfilPermiso(PerfilPermiso perfilPermiso) {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.save(perfilPermiso);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PerfilPermiso> findAllXIdPerfil(int idPerfil) {
		// TODO Auto-generated method stub
		return perfilPermisoRepository.findAllXIdPerfil(idPerfil);
	}

}
