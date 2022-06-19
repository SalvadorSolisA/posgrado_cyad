package com.cyad.posgrado.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * clase entidad representa el o los correos de un alumno
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CORREO")
@Entity
public class ECorreo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="CORREO")
	private String correo;
	
	@Column(name="TIPO")
	private String tipo;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="ID_ALUMNO_CORREO")
	private EAlumno alumno;

	public ECorreo() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public EAlumno getAlumno() {
		return alumno;
	}

	public void setAlumno(EAlumno alumno) {
		this.alumno = alumno;
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
