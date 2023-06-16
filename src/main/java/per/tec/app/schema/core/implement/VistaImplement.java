package per.tec.app.schema.core.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.Vista;
import per.tec.app.schema.core.repository.VistaRepository;
import per.tec.app.schema.core.service.VistaService;

@Service
public class VistaImplement implements VistaService {

	@Autowired
	VistaRepository vistaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Vista> findByIdVistas(int idVistas) {
		// TODO Auto-generated method stub
		return vistaRepository.findByIdVistas(idVistas);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdVistas(int idVistas) {
		// TODO Auto-generated method stub
		return vistaRepository.existsByIdVistas(idVistas);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vista> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return vistaRepository.findByDescripcion(descripcion);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return vistaRepository.existsByDescripcion(descripcion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vista> findByIcono(String icono) {
		// TODO Auto-generated method stub
		return vistaRepository.findByIcono(icono);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIcono(String icono) {
		// TODO Auto-generated method stub
		return vistaRepository.existsByIcono(icono);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vista> findByTipo(String tipo) {
		// TODO Auto-generated method stub
		return vistaRepository.findByTipo(tipo);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByTipo(String tipo) {
		// TODO Auto-generated method stub
		return vistaRepository.existsByTipo(tipo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vista> findByUrl(String url) {
		// TODO Auto-generated method stub
		return vistaRepository.findByUrl(url);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByUrl(String url) {
		// TODO Auto-generated method stub
		return vistaRepository.existsByUrl(url);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vista> findByVista(Vista vista) {
		// TODO Auto-generated method stub
		return vistaRepository.findByVista(vista);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByVista(Vista vista) {
		// TODO Auto-generated method stub
		return vistaRepository.existsByVista(vista);
	}

	@Override
	@Transactional
	public void deleteVista(Vista vista) {
		// TODO Auto-generated method stub
		vistaRepository.delete(vista);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Vista> findAllVista() {
		// TODO Auto-generated method stub
		return vistaRepository.findAll();

	}

	@Override
	@Transactional
	public Vista saveVista(Vista vista) {
		// TODO Auto-generated method stub
		return vistaRepository.save(vista);
	}

}
