package per.tec.app.schema.core.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.ConfiguracionInterfaz;
import per.tec.app.schema.core.repository.ConfiguracionInterfazRepository;
import per.tec.app.schema.core.service.ConfiguracionInterfazService;

@Service
public class ConfiguracionInterfazImplement implements ConfiguracionInterfazService {

	@Autowired
	ConfiguracionInterfazRepository configuracionInterfazRepository;

	@Override
	@Transactional(readOnly = true)
	public List<ConfiguracionInterfaz> findByIdConfiguracion(Integer idConfiguracion) {
		// TODO Auto-generated method stub
		return configuracionInterfazRepository.findByIdConfiguracion(idConfiguracion);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdConfiguracion(Integer idConfiguracion) {
		// TODO Auto-generated method stub
		return configuracionInterfazRepository.existsByIdConfiguracion(idConfiguracion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ConfiguracionInterfaz> findByActivo(Boolean activo) {
		// TODO Auto-generated method stub
		return configuracionInterfazRepository.findByActivo(activo);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByActivo(Boolean activo) {
		// TODO Auto-generated method stub
		return configuracionInterfazRepository.existsByActivo(activo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ConfiguracionInterfaz> findByColor(String color) {
		// TODO Auto-generated method stub
		return configuracionInterfazRepository.findByColor(color);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByColor(String color) {
		// TODO Auto-generated method stub
		return configuracionInterfazRepository.existsByColor(color);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ConfiguracionInterfaz> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return configuracionInterfazRepository.findByDescripcion(descripcion);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return configuracionInterfazRepository.existsByDescripcion(descripcion);
	}

	@Override
	@Transactional
	public void deleteConfiguracionInterfaz(ConfiguracionInterfaz configuracionInterfaz) {
		// TODO Auto-generated method stub
		configuracionInterfazRepository.delete(configuracionInterfaz);

	}

	@Override
	@Transactional(readOnly = true)
	public List<ConfiguracionInterfaz> findAllConfiguracionInterfaz() {
		// TODO Auto-generated method stub
		return configuracionInterfazRepository.findAll();

	}

	@Override
	@Transactional
	public ConfiguracionInterfaz saveConfiguracionInterfaz(ConfiguracionInterfaz configuracionInterfaz) {
		// TODO Auto-generated method stub
		return configuracionInterfazRepository.save(configuracionInterfaz);
	}

}
