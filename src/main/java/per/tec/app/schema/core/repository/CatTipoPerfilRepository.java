package per.tec.app.schema.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import per.tec.app.schema.core.entities.CatTipoPerfil;

public interface CatTipoPerfilRepository extends PagingAndSortingRepository<CatTipoPerfil, Serializable> {

	public abstract List<CatTipoPerfil> findAll();

	public abstract List<CatTipoPerfil> findByIdTipoPerfil(Integer idTipoPerfil);

	public abstract boolean existsByIdTipoPerfil(Integer idTipoPerfil);

	public abstract List<CatTipoPerfil> findByDescripcion(String descripcion);

	public abstract boolean existsByDescripcion(String descripcion);

	@Query("SELECT tp FROM CatTipoPerfil tp WHERE tp.idTipoPerfil NOT IN(1)")
	public abstract List<CatTipoPerfil> findAdminCatTipoPerfil();

	@Query("SELECT tp FROM CatTipoPerfil tp WHERE tp.idTipoPerfil NOT IN(1) AND tp.idTipoPerfil NOT IN(2)")
	public List<CatTipoPerfil> findUserCatTipoPerfil();

}
