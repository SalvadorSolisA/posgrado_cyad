package com.cyad.posgrado.entity;

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
 * clase entidad representa el catalogo de planes de estudio
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_PLAN")
@Entity
public class EPlan {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="CLAVE")
	private int clave;
	
	@Column(name="CREDITOS")
	private int creditos;
	
	@Column(name="DURACION")
	private int duracion;
	
	@Column(name="DIVISION")
	private String division;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy = "plan")
	@JsonIgnore
	private List<EDatosAcademicos> datos;

	public EPlan() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int durecion) {
		this.duracion = durecion;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
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
	
	
	
}
