package per.tec.app.schema.core.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.Menu;
import per.tec.app.schema.core.entities.MenuVista;
import per.tec.app.schema.core.entities.Vista;
import per.tec.app.schema.core.repository.MenuVistaRepository;
import per.tec.app.schema.core.service.MenuVistaService;

@Service
public class MenuVistaImplement implements MenuVistaService {

	@Autowired
	MenuVistaRepository menuVistaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<MenuVista> findByIdMenuVistas(int idMenuVistas) {
		// TODO Auto-generated method stub
		return menuVistaRepository.findByIdMenuVistas(idMenuVistas);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdMenuVistas(int idMenuVistas) {
		// TODO Auto-generated method stub
		return menuVistaRepository.existsByIdMenuVistas(idMenuVistas);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MenuVista> findByOrden(int orden) {
		// TODO Auto-generated method stub
		return menuVistaRepository.findByOrden(orden);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByOrden(int orden) {
		// TODO Auto-generated method stub
		return menuVistaRepository.existsByOrden(orden);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MenuVista> findByMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuVistaRepository.findByMenu(menu);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuVistaRepository.existsByMenu(menu);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MenuVista> findByVista(Vista vista) {
		// TODO Auto-generated method stub
		return menuVistaRepository.findByVista(vista);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByVista(Vista vista) {
		// TODO Auto-generated method stub
		return menuVistaRepository.existsByVista(vista);
	}

	@Override
	@Transactional
	public void deleteMenuVista(MenuVista menuVista) {
		// TODO Auto-generated method stub
		menuVistaRepository.delete(menuVista);

	}

	@Override
	@Transactional(readOnly = true)
	public List<MenuVista> findAllMenuVista() {
		// TODO Auto-generated method stub
		return menuVistaRepository.findAll();

	}

	@Override
	@Transactional
	public MenuVista saveMenuVista(MenuVista menuVista) {
		// TODO Auto-generated method stub
		return menuVistaRepository.save(menuVista);
	}

}
