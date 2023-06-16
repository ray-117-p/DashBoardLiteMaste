package per.tec.app.schema.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the perfil_permiso database table.
 * 
 */
@Entity
@Table(name = "perfil_permiso", schema = "core")
@NamedQuery(name = "PerfilPermiso.findAll", query = "SELECT p FROM PerfilPermiso p")
public class PerfilPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil_permiso")
	private int idPerfilPermiso;

	private Boolean activo;

	// bi-directional many-to-one association to Perfil
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;

	// bi-directional many-to-one association to CatPermiso
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_permiso")
	private CatPermiso catPermiso;

	public PerfilPermiso() {
	}

	public int getIdPerfilPermiso() {
		return this.idPerfilPermiso;
	}

	public void setIdPerfilPermiso(int idPerfilPermiso) {
		this.idPerfilPermiso = idPerfilPermiso;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public CatPermiso getCatPermiso() {
		return this.catPermiso;
	}

	public void setCatPermiso(CatPermiso catPermiso) {
		this.catPermiso = catPermiso;
	}

}