package per.tec.app.schema.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import per.tec.app.schema.core.entities.CatPermiso;
import per.tec.app.schema.core.entities.CatSchema;

public interface CatPermisoRepository extends PagingAndSortingRepository<CatPermiso, Serializable> {

	public abstract List<CatPermiso> findAll();

	public abstract List<CatPermiso> findByIdPermiso(Integer idPermiso);

	public abstract boolean existsByIdPermiso(Integer idPermiso);

	public abstract List<CatPermiso> findByPermiso(String permiso);

	public abstract boolean existsByPermiso(String permiso);

	public abstract List<CatPermiso> findByCatSchema(CatSchema catSchema);

	public abstract boolean existsByCatSchema(CatSchema catSchema);

	@Query("SELECT c FROM CatPermiso c WHERE c.catSchema.idSchema NOT IN(1)")
	public abstract List<CatPermiso> findUserCatPermiso();

	@Query("SELECT c FROM CatPermiso c WHERE c.catSchema.idSchema= 1")
	public abstract List<CatPermiso> findAllAdminCatPermiso();

	/*
	 *
	 * PAGE
	 * 
	 **/

	@Query("SELECT cp from CatPermiso cp INNER JOIN cp.catSchema cs on cp.catSchema.idSchema = cs.idSchema")
	public Page<CatPermiso> findAll(Pageable pageable);

	@Query("SELECT cp from CatPermiso cp INNER JOIN cp.catSchema cs on cp.catSchema.idSchema = cs.idSchema ORDER BY cp.permiso ASC")
	public Page<CatPermiso> findAllPermisoAsc(Pageable pageable);

	@Query("SELECT cp from CatPermiso cp INNER JOIN cp.catSchema cs on cp.catSchema.idSchema = cs.idSchema ORDER BY cp.permiso DESC")
	public Page<CatPermiso> findAllPermisoDesc(Pageable pageable);

	@Query("SELECT cp from CatPermiso cp INNER JOIN cp.catSchema cs on cp.catSchema.idSchema = cs.idSchema ORDER BY cp.catSchema.nombre ASC")
	public Page<CatPermiso> findAllSchemaAsc(Pageable pageable);

	@Query("SELECT cp from CatPermiso cp INNER JOIN cp.catSchema cs on cp.catSchema.idSchema = cs.idSchema ORDER BY cp.catSchema.nombre DESC")
	public Page<CatPermiso> findAllSchemaDesc(Pageable pageable);

	/*
	 * LIKES
	 **/

	@Query("SELECT cp from CatPermiso cp INNER JOIN cp.catSchema cs on cp.catSchema.idSchema = cs.idSchema WHERE cp.permiso LIKE %?1% OR cs.nombre LIKE %?1%")
	public Page<CatPermiso> listarLike(String search, Pageable pageable);

	@Query("SELECT cp from CatPermiso cp INNER JOIN cp.catSchema cs on cp.catSchema.idSchema = cs.idSchema WHERE cp.permiso LIKE %?1% OR cs.nombre LIKE %?1% ORDER BY cp.permiso ASC")
	public Page<CatPermiso> listarLikePermisoAsc(String search, Pageable pageable);

	@Query("SELECT cp from CatPermiso cp INNER JOIN cp.catSchema cs on cp.catSchema.idSchema = cs.idSchema WHERE cp.permiso LIKE %?1% OR cs.nombre LIKE %?1% ORDER BY cp.permiso DESC")
	public Page<CatPermiso> listarLikePermisoDesc(String search, Pageable pageable);

	@Query("SELECT cp from CatPermiso cp INNER JOIN cp.catSchema cs on cp.catSchema.idSchema = cs.idSchema WHERE cp.permiso LIKE %?1% OR cs.nombre LIKE %?1% ORDER BY cp.catSchema.nombre ASC")
	public Page<CatPermiso> listarLikeSchemaAsc(String search, Pageable pageable);

	@Query("SELECT cp from CatPermiso cp INNER JOIN cp.catSchema cs on cp.catSchema.idSchema = cs.idSchema WHERE cp.permiso LIKE %?1% OR cs.nombre LIKE %?1% ORDER BY cp.catSchema.nombre DESC")
	public Page<CatPermiso> listarLikeSchemaDesc(String search, Pageable pageable);

}
