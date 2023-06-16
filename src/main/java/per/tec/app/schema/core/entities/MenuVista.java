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
 * The persistent class for the menu_vistas database table.
 * 
 */
@Entity
@Table(name = "menu_vistas", schema = "core")
@NamedQuery(name = "MenuVista.findAll", query = "SELECT m FROM MenuVista m")
public class MenuVista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_menu_vistas")
	private int idMenuVistas;

	private int orden;

	// bi-directional many-to-one association to Menu
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_menu")
	private Menu menu;

	// bi-directional many-to-one association to Vista
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_vistas")
	private Vista vista;

	public MenuVista() {
	}

	public int getIdMenuVistas() {
		return this.idMenuVistas;
	}

	public void setIdMenuVistas(int idMenuVistas) {
		this.idMenuVistas = idMenuVistas;
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

	public Vista getVista() {
		return this.vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

}