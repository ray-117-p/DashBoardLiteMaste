package per.tec.app.schema.core.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name = "menu", schema = "core")
@NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_menu")
	private int idMenu;

	private String descripcion;

	// bi-directional many-to-one association to MenuVista
	@OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
	private List<MenuVista> menuVistas;

	// bi-directional many-to-one association to PerfilMenu
	@OneToMany(mappedBy = "menu")
	private List<PerfilMenu> perfilMenus;

	public Menu() {
	}

	public int getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<MenuVista> getMenuVistas() {
		return this.menuVistas;
	}

	public void setMenuVistas(List<MenuVista> menuVistas) {
		this.menuVistas = menuVistas;
	}

	public MenuVista addMenuVista(MenuVista menuVista) {
		getMenuVistas().add(menuVista);
		menuVista.setMenu(this);

		return menuVista;
	}

	public MenuVista removeMenuVista(MenuVista menuVista) {
		getMenuVistas().remove(menuVista);
		menuVista.setMenu(null);

		return menuVista;
	}

	public List<PerfilMenu> getPerfilMenus() {
		return this.perfilMenus;
	}

	public void setPerfilMenus(List<PerfilMenu> perfilMenus) {
		this.perfilMenus = perfilMenus;
	}

	public PerfilMenu addPerfilMenus(PerfilMenu perfilMenus) {
		getPerfilMenus().add(perfilMenus);
		perfilMenus.setMenu(this);

		return perfilMenus;
	}

	public PerfilMenu removePerfilMenus(PerfilMenu perfilMenus) {
		getPerfilMenus().remove(perfilMenus);
		perfilMenus.setMenu(null);

		return perfilMenus;
	}

}