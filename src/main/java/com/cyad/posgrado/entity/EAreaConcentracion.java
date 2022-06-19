package com.cyad.posgrado.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase entidad representa el catalogo de areas de concentracion
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_AREA_CONCENTRACION")
@Entity
public class EAreaConcentracion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="AREA_CONCENTRACION")
	private String area;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy = "areac")
	@JsonIgnore
	private List<EDatosAcademicos> datos;

	public EAreaConcentracion() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<EDatosAcademicos> getDatos() {
		return datos;
	}

	public void setDatos(List<EDatosAcademicos> datos) {
		this.datos = datos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
