package per.tec.app.schema.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import per.tec.app.schema.core.entities.CatSchema;

public interface CatSchemaRepository extends PagingAndSortingRepository<CatSchema, Serializable> {

	public abstract List<CatSchema> findAll();

	public abstract List<CatSchema> findByIdSchema(Integer idSchema);

	public abstract boolean existsByIdSchema(Integer idSchema);

	public abstract List<CatSchema> findByDescripcion(String descripcion);

	public abstract boolean existsByDescripcion(String descripcion);
	
	@Query("SELECT c FROM CatSchema c WHERE c.nombre='SIGEC'")
	public abstract List<CatSchema> findUserCatSchema() ;

}
