package com.cyad.datamart.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase que representa la trayectoria academica de un alumno
 * @author Salvador Solis Atenco
 *
 */
@Table(name="TB_TRAYECTORIA")
@Entity
public class ETrayectoriaDatamart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private long id;
	
	@OneToOne(mappedBy = "trayectoria",  fetch = FetchType.EAGER)
	@JsonIgnore
	private EAlumnoDatamart alumno;
	
	@OneToMany(mappedBy = "trayectoria",  fetch = FetchType.EAGER)
	@JsonIgnore
	private List<EDatosPorTrimestreDatamart> datos;

	public ETrayectoriaDatamart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EAlumnoDatamart getAlumno() {
		return alumno;
	}

	public void setAlumno(EAlumnoDatamart alumno) {
		this.alumno = alumno;
	}

	public List<EDatosPorTrimestreDatamart> getDatos() {
		return datos;
	}

	public void setDatos(List<EDatosPorTrimestreDatamart> datos) {
		this.datos = datos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
