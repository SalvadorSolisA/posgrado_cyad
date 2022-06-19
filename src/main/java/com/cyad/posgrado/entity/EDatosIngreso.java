package com.cyad.posgrado.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase entidad representa los datos de ingreso de un alumno del posgrado
 * @author Salvador Solis Atenco
 *
 */
@Table(name="DATOS_INGRESO")
@Entity
public class EDatosIngreso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="ESCUELA_PROCEDENCIA")
	private String escuelaProcedencia;
	
	@Column(name="PROMEDIO")
	private Double promedio;
	
	@Column(name="NIVEL_ESTUDIOS")
	private String nivelStudios;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToOne
	@JoinColumn(name="ID_ALUMNO_DATOS_INGRESO")
	private EAlumno alumno;
	
	@OneToMany(mappedBy = "datosIngreso", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<EAdeudo> adeudos;
	
	public EDatosIngreso() {
		super();
		this.activo = true;
		this.escuelaProcedencia = "";
		this.promedio = 0.0;
		this.nivelStudios = "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEscuelaProcedencia() {
		return escuelaProcedencia;
	}

	public void setEscuelaProcedencia(String escuelaProcedencia) {
		this.escuelaProcedencia = escuelaProcedencia;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public String getNivelStudios() {
		return nivelStudios;
	}

	public void setNivelStudios(String nivelStudios) {
		this.nivelStudios = nivelStudios;
	}

	public EAlumno getAlumno() {
		return alumno;
	}

	public void setAlumno(EAlumno alumno) {
		this.alumno = alumno;
	}

	public List<EAdeudo> getAdeudos() {
		return adeudos;
	}

	public void setAdeudos(List<EAdeudo> adeudos) {
		this.adeudos = adeudos;
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
