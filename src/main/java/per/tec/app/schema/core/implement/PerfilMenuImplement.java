package per.tec.app.schema.core.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.Menu;
import per.tec.app.schema.core.entities.Perfil;
import per.tec.app.schema.core.entities.PerfilMenu;
import per.tec.app.schema.core.repository.PerfilMenuRepository;
import per.tec.app.schema.core.service.PerfilMenuService;

@Service
public class PerfilMenuImplement implements PerfilMenuService {

	@Autowired
	PerfilMenuRepository perfilMenuRepository;

	@Override
	@Transactional(readOnly = true)
	public List<PerfilMenu> findByIdPerfilMenu(int idPerfilMenu) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.findByIdPerfilMenu(idPerfilMenu);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdPerfilMenu(int idPerfilMenu) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.existsByIdPerfilMenu(idPerfilMenu);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PerfilMenu> findByEstatus(Boolean estatus) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.findByEstatus(estatus);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByEstatus(Boolean estatus) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.existsByEstatus(estatus);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PerfilMenu> findByOrden(int orden) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.findByOrden(orden);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByOrden(int orden) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.existsByOrden(orden);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PerfilMenu> findByMenu(Menu menu) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.findByMenu(menu);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByMenu(Menu menu) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.existsByMenu(menu);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PerfilMenu> findByPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.findByPerfil(perfil);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.existsByPerfil(perfil);
	}

	@Override
	@Transactional
	public void deletePerfilMenu(PerfilMenu perfilMenu) {
		// TODO Auto-generated method stub
		perfilMenuRepository.delete(perfilMenu);

	}

	@Override
	@Transactional(readOnly = true)
	public List<PerfilMenu> findAllPerfilMenu() {
		// TODO Auto-generated method stub
		return perfilMenuRepository.findAll();

	}

	@Override
	@Transactional
	public PerfilMenu savePerfilMenu(PerfilMenu perfilMenu) {
		// TODO Auto-generated method stub
		return perfilMenuRepository.save(perfilMenu);
	}

}
