package per.tec.app.schema.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import per.tec.app.schema.core.entities.Vista;

public interface VistaRepository extends PagingAndSortingRepository<Vista, Serializable> {

	public abstract List<Vista> findAll();

	public abstract List<Vista> findByIdVistas(Integer idVistas);

	public abstract boolean existsByIdVistas(Integer idVistas);

	public abstract List<Vista> findByDescripcion(String descripcion);

	public abstract boolean existsByDescripcion(String descripcion);

	public abstract List<Vista> findByIcono(String icono);

	public abstract boolean existsByIcono(String icono);

	public abstract List<Vista> findByTipo(String tipo);

	public abstract boolean existsByTipo(String tipo);

	public abstract List<Vista> findByUrl(String url);

	public abstract boolean existsByUrl(String url);

	public abstract List<Vista> findByVista(Vista vista);

	public abstract boolean existsByVista(Vista vista);

}
