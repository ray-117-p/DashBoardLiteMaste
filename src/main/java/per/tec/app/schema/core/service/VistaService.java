package per.tec.app.schema.core.service;

import java.util.List;

import per.tec.app.schema.core.entities.Vista;

public interface VistaService {

	public List<Vista> findByIdVistas(int idVistas);

	public boolean existsByIdVistas(int idVistas);

	public List<Vista> findByDescripcion(String descripcion);

	public boolean existsByDescripcion(String descripcion);

	public List<Vista> findByIcono(String icono);

	public boolean existsByIcono(String icono);

	public List<Vista> findByTipo(String tipo);

	public boolean existsByTipo(String tipo);

	public List<Vista> findByUrl(String url);

	public boolean existsByUrl(String url);

	public List<Vista> findByVista(Vista vista);

	public boolean existsByVista(Vista vista);

	public Vista saveVista(Vista vista);

	void deleteVista(Vista vista);

	public List<Vista> findAllVista();
}
