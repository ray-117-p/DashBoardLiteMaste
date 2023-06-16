package per.tec.app.schema.core.service;

import java.util.List;

import per.tec.app.schema.core.entities.CatSchema;

public interface CatSchemaService {

	public List<CatSchema> findByIdSchema(Integer idSchema);

	public boolean existsByIdSchema(Integer idSchema);

	public List<CatSchema> findByDescripcion(String descripcion);

	public boolean existsByDescripcion(String descripcion);

	public CatSchema saveCatSchema(CatSchema catSchema);

	void deleteCatSchema(CatSchema catSchema);

	public List<CatSchema> findAllCatSchema();

	public List<CatSchema> findUserCatSchema();
}
