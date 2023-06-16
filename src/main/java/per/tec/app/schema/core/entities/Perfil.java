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
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name = "perfil", schema = "core")
@NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil")
	private int idPerfil;

	private String descripcion;

	private Boolean estatus;

	private String index;

	// bi-directional many-to-one association to CatTipoPerfil
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_perfil")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CatTipoPerfil catTipoPerfil;

	// bi-directional many-to-one association to PerfilMenu
	@OneToMany(mappedBy = "perfil")
	@JsonIgnore
	private List<PerfilMenu> perfilMenus;

	// bi-directional many-to-one association to PerfilPermiso
	@OneToMany(mappedBy = "perfil")
	@JsonIgnore
	private List<PerfilPermiso> perfilPermisos;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "perfil")
	@JsonIgnore
	private List<Usuario> usuarios;

	public Perfil() {
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public String getIndex() {
		return this.index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public CatTipoPerfil getCatTipoPerfil() {
		return this.catTipoPerfil;
	}

	public void setCatTipoPerfil(CatTipoPerfil catTipoPerfil) {
		this.catTipoPerfil = catTipoPerfil;
	}

	public List<PerfilMenu> getPerfilMenus() {
		return this.perfilMenus;
	}

	public void setPerfilMenus(List<PerfilMenu> perfilMenus) {
		this.perfilMenus = perfilMenus;
	}

	public PerfilMenu addPerfilMenus(PerfilMenu perfilMenus) {
		getPerfilMenus().add(perfilMenus);
		perfilMenus.setPerfil(this);

		return perfilMenus;
	}

	public PerfilMenu removePerfilMenus(PerfilMenu perfilMenus) {
		getPerfilMenus().remove(perfilMenus);
		perfilMenus.setPerfil(null);

		return perfilMenus;
	}

	public List<PerfilPermiso> getPerfilPermisos() {
		return this.perfilPermisos;
	}

	public void setPerfilPermisos(List<PerfilPermiso> perfilPermisos) {
		this.perfilPermisos = perfilPermisos;
	}

	public PerfilPermiso addPerfilPermiso(PerfilPermiso perfilPermiso) {
		getPerfilPermisos().add(perfilPermiso);
		perfilPermiso.setPerfil(this);

		return perfilPermiso;
	}

	public PerfilPermiso removePerfilPermiso(PerfilPermiso perfilPermiso) {
		getPerfilPermisos().remove(perfilPermiso);
		perfilPermiso.setPerfil(null);

		return perfilPermiso;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPerfil(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPerfil(null);

		return usuario;
	}

}