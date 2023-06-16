package per.tec.app.schema.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the configuracion_interfaz database table.
 * 
 */
@Entity
@Table(name = "configuracion_interfaz", schema = "core")
@NamedQuery(name = "ConfiguracionInterfaz.findAll", query = "SELECT c FROM ConfiguracionInterfaz c")
public class ConfiguracionInterfaz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_configuracion")
	private Integer idConfiguracion;

	private Boolean activo;

	private String color;

	private String descripcion;

	private String elemento;

	public ConfiguracionInterfaz() {
	}

	public Integer getIdConfiguracion() {
		return this.idConfiguracion;
	}

	public void setIdConfiguracion(Integer idConfiguracion) {
		this.idConfiguracion = idConfiguracion;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

}