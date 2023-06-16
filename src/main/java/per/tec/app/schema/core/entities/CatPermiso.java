package per.tec.app.schema.core.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the cat_permiso database table.
 * 
 */
@Entity
@Table(name = "cat_permiso", schema = "core")
@NamedQuery(name = "CatPermiso.findAll", query = "SELECT c FROM CatPermiso c")
public class CatPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_permiso")
	private Integer idPermiso;

	private String permiso;

	private String descripcion;

	// bi-directional many-to-one association to CatSchema
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_schema")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CatSchema catSchema;

	// bi-directional many-to-one association to PerfilPermiso
	@OneToMany(mappedBy = "catPermiso")
	@JsonIgnore
	private List<PerfilPermiso> perfilPermisos;

	public CatPermiso() {
	}

	public Integer getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getPermiso() {
		return this.permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public CatSchema getCatSchema() {
		return this.catSchema;
	}

	public void setCatSchema(CatSchema catSchema) {
		this.catSchema = catSchema;
	}

	public List<PerfilPermiso> getPerfilPermisos() {
		return this.perfilPermisos;
	}

	public void setPerfilPermisos(List<PerfilPermiso> perfilPermisos) {
		this.perfilPermisos = perfilPermisos;
	}

	public PerfilPermiso addPerfilPermiso(PerfilPermiso perfilPermiso) {
		getPerfilPermisos().add(perfilPermiso);
		perfilPermiso.setCatPermiso(this);

		return perfilPermiso;
	}

	public PerfilPermiso removePerfilPermiso(PerfilPermiso perfilPermiso) {
		getPerfilPermisos().remove(perfilPermiso);
		perfilPermiso.setCatPermiso(null);

		return perfilPermiso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}