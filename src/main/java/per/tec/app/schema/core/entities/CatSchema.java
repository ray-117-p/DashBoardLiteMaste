package per.tec.app.schema.core.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the cat_schema database table.
 * 
 */
@Entity
@Table(name = "cat_schema", schema = "core")
@NamedQuery(name = "CatSchema.findAll", query = "SELECT c FROM CatSchema c")
public class CatSchema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_schema")
	private Integer idSchema;

	private String nombre;

	private String descripcion;

	// bi-directional many-to-one association to CatPermiso
	@OneToMany(mappedBy = "catSchema")
	@JsonIgnore
	private List<CatPermiso> catPermisos;

	public CatSchema() {
	}

	public Integer getIdSchema() {
		return this.idSchema;
	}

	public void setIdSchema(Integer idSchema) {
		this.idSchema = idSchema;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CatPermiso> getCatPermisos() {
		return this.catPermisos;
	}

	public void setCatPermisos(List<CatPermiso> catPermisos) {
		this.catPermisos = catPermisos;
	}

	public CatPermiso addCatPermiso(CatPermiso catPermiso) {
		getCatPermisos().add(catPermiso);
		catPermiso.setCatSchema(this);

		return catPermiso;
	}

	public CatPermiso removeCatPermiso(CatPermiso catPermiso) {
		getCatPermisos().remove(catPermiso);
		catPermiso.setCatSchema(null);

		return catPermiso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}