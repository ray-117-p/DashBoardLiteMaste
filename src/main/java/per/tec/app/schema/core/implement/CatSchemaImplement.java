package per.tec.app.schema.core.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.tec.app.schema.core.entities.CatSchema;
import per.tec.app.schema.core.repository.CatSchemaRepository;
import per.tec.app.schema.core.service.CatSchemaService;

@Service
public class CatSchemaImplement implements CatSchemaService {

	@Autowired
	CatSchemaRepository catSchemaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<CatSchema> findByIdSchema(Integer idSchema) {
		// TODO Auto-generated method stub
		return catSchemaRepository.findByIdSchema(idSchema);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByIdSchema(Integer idSchema) {
		// TODO Auto-generated method stub
		return catSchemaRepository.existsByIdSchema(idSchema);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CatSchema> findByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return catSchemaRepository.findByDescripcion(descripcion);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return catSchemaRepository.existsByDescripcion(descripcion);
	}

	@Override
	@Transactional
	public void deleteCatSchema(CatSchema catSchema) {
		// TODO Auto-generated method stub
		catSchemaRepository.delete(catSchema);

	}

	@Override
	@Transactional(readOnly = true)
	public List<CatSchema> findAllCatSchema() {
		// TODO Auto-generated method stub
		return catSchemaRepository.findAll();

	}

	@Override
	@Transactional
	public CatSchema saveCatSchema(CatSchema catSchema) {
		// TODO Auto-generated method stub
		return catSchemaRepository.save(catSchema);
	}

	@Override
	public List<CatSchema> findUserCatSchema() {
		// TODO Auto-generated method stub
		return catSchemaRepository.findUserCatSchema();
	}

}
