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

/**
 * The persistent class for the vistas database table.
 * 
 */
@Entity
@Table(name = "vistas", schema = "core")
@NamedQuery(name = "Vista.findAll", query = "SELECT v FROM Vista v")
public class Vista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vistas")
	private int idVistas;

	private String descripcion;

	private String icono;

	private String tipo;

	private String url;

	// bi-directional many-to-one association to MenuVista
	@OneToMany(mappedBy = "vista")
	private List<MenuVista> menuVistas;

	// bi-directional many-to-one association to Vista
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_submenu")
	private Vista vista;

	// bi-directional many-to-one association to Vista
	@OneToMany(mappedBy = "vista", fetch = FetchType.EAGER)
	private List<Vista> vistas;

	public Vista() {
	}

	public int getIdVistas() {
		return this.idVistas;
	}

	public void setIdVistas(int idVistas) {
		this.idVistas = idVistas;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuVista> getMenuVistas() {
		return this.menuVistas;
	}

	public void setMenuVistas(List<MenuVista> menuVistas) {
		this.menuVistas = menuVistas;
	}

	public MenuVista addMenuVista(MenuVista menuVista) {
		getMenuVistas().add(menuVista);
		menuVista.setVista(this);

		return menuVista;
	}

	public MenuVista removeMenuVista(MenuVista menuVista) {
		getMenuVistas().remove(menuVista);
		menuVista.setVista(null);

		return menuVista;
	}

	public Vista getVista() {
		return this.vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public List<Vista> getVistas() {
		return this.vistas;
	}

	public void setVistas(List<Vista> vistas) {
		this.vistas = vistas;
	}

	public Vista addVista(Vista vista) {
		getVistas().add(vista);
		vista.setVista(this);

		return vista;
	}

	public Vista removeVista(Vista vista) {
		getVistas().remove(vista);
		vista.setVista(null);

		return vista;
	}

}