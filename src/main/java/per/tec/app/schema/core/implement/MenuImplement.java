package per.tec.app.schema.core.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.Menu;
import per.tec.app.schema.core.repository.MenuRepository;
import per.tec.app.schema.core.service.MenuService;

@Service
public class MenuImplement implements MenuService {

	@Autowired
	MenuRepository menuRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Menu> findByIdMenu(int idMenu) {
		// TODO Auto-generated method stub
		return menuRepository.findByIdMenu(idMenu);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdMenu(int idMenu) {
		// TODO Auto-generated method stub
		return menuRepository.existsByIdMenu(idMenu);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Menu> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return menuRepository.findByDescripcion(descripcion);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return menuRepository.existsByDescripcion(descripcion);
	}

	@Override
	@Transactional
	public void deleteMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuRepository.delete(menu);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Menu> findAllMenu() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();

	}

	@Override
	@Transactional
	public Menu saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuRepository.save(menu);
	}

}
