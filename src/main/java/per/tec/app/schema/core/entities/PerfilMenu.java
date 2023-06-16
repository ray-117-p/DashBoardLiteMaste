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
 * The persistent class for the perfil_menu database table.
 * 
 */
@Entity
@Table(name = "perfil_menu", schema = "core")
@NamedQuery(name = "PerfilMenu.findAll", query = "SELECT p FROM PerfilMenu p")
public class PerfilMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil_menu")
	private int idPerfilMenu;

	private boolean estatus;

	private int orden;

	// bi-directional many-to-one association to Menu
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_menu")
	private Menu menu;

	// bi-directional many-to-one association to Perfil
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;

	public PerfilMenu() {
	}

	public int getIdPerfilMenu() {
		return this.idPerfilMenu;
	}

	public void setIdPerfilMenu(int idPerfilMenu) {
		this.idPerfilMenu = idPerfilMenu;
	}

	public boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}