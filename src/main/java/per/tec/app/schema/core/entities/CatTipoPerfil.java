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
 * The persistent class for the cat_tipo_perfil database table.
 * 
 */
@Entity
@Table(name = "cat_tipo_perfil", schema = "core")
@NamedQuery(name = "CatTipoPerfil.findAll", query = "SELECT c FROM CatTipoPerfil c")
public class CatTipoPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_perfil")
	private int idTipoPerfil;

	private String descripcion;

	// bi-directional many-to-one association to Perfil
	@OneToMany(mappedBy = "catTipoPerfil")
	@JsonIgnore
	private List<Perfil> perfils;

	public CatTipoPerfil() {
	}

	public int getIdTipoPerfil() {
		return this.idTipoPerfil;
	}

	public void setIdTipoPerfil(int idTipoPerfil) {
		this.idTipoPerfil = idTipoPerfil;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Perfil addPerfil(Perfil perfil) {
		getPerfils().add(perfil);
		perfil.setCatTipoPerfil(this);

		return perfil;
	}

	public Perfil removePerfil(Perfil perfil) {
		getPerfils().remove(perfil);
		perfil.setCatTipoPerfil(null);

		return perfil;
	}

}