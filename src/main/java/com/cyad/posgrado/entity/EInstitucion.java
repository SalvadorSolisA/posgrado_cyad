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
 * clase entidad representa al catalogo de instituciones de procedencia
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_INSTITUCION")
@Entity
public class EInstitucion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="INSTITUCION")
	private String institucion;
	
	@Column(name="ACTIVO")
	private boolean activo;

	// referencia al atributo
	@OneToMany(mappedBy = "institucion")
	@JsonIgnore
	private List<EProfesor> profesores;

	public EInstitucion() {
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
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
