package per.tec.app.schema.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import per.tec.app.schema.core.entities.ConfiguracionInterfaz;

public interface ConfiguracionInterfazRepository
		extends PagingAndSortingRepository<ConfiguracionInterfaz, Serializable> {

	public abstract List<ConfiguracionInterfaz> findAll();

	public abstract List<ConfiguracionInterfaz> findByIdConfiguracion(Integer idConfiguracion);

	public abstract boolean existsByIdConfiguracion(Integer idConfiguracion);

	public abstract List<ConfiguracionInterfaz> findByActivo(Boolean activo);

	public abstract boolean existsByActivo(Boolean activo);

	public abstract List<ConfiguracionInterfaz> findByColor(String color);

	public abstract boolean existsByColor(String color);

	public abstract List<ConfiguracionInterfaz> findByDescripcion(String descripcion);

	public abstract boolean existsByDescripcion(String descripcion);

}
