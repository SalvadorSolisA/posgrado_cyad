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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * clase entidad representa el catalogo de departamentos a los que pertenecen los profesores
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_DEPARTAMENTO")
@Entity
@JsonIgnoreProperties(allowSetters = true, value = {"profesores"})
public class EDepartamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="DEPARTAMENTO")
	private String departamento;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy="departamento")
	@JsonIgnore
	private List<EProfesor> profesores;
	
	public EDepartamento() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<EProfesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<EProfesor> profesores) {
		this.profesores = profesores;
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
