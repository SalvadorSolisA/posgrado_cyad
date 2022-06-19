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
 * clase entidad representa al catalogo de divisiones a los que pertenecen los participantes del posgrado
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_DIVISION")
@Entity
public class EDivision implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="NOMBRE_DIVISION")
	private String division;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	//referencia al atributo
	@OneToMany(mappedBy = "division")
	@JsonIgnore
	private List<EProfesor> profesores;

	public EDivision() {
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDivision() {
		return division;
	}

	public void setNombre(String division) {
		this.division = division;
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

	public void setDivision(String division) {
		this.division = division;
	}
	
	
	
}
