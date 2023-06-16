package per.tec.app.schema.core.service;

import java.util.List;

import per.tec.app.schema.core.entities.ConfiguracionInterfaz;

public interface ConfiguracionInterfazService {

	public List<ConfiguracionInterfaz> findByIdConfiguracion(Integer idConfiguracion);

	public boolean existsByIdConfiguracion(Integer idConfiguracion);

	public List<ConfiguracionInterfaz> findByActivo(Boolean activo);

	public boolean existsByActivo(Boolean activo);

	public List<ConfiguracionInterfaz> findByColor(String color);

	public boolean existsByColor(String color);

	public List<ConfiguracionInterfaz> findByDescripcion(String descripcion);

	public boolean existsByDescripcion(String descripcion);

	public ConfiguracionInterfaz saveConfiguracionInterfaz(ConfiguracionInterfaz configuracionInterfaz);

	void deleteConfiguracionInterfaz(ConfiguracionInterfaz configuracionInterfaz);

	public List<ConfiguracionInterfaz> findAllConfiguracionInterfaz();
}
