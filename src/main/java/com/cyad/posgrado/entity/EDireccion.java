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
 * clase entidad representa la direccion(es) del alumno
 * @author Salvador Solis Atenco
 *
 */
@Table(name="DIRECCION")
@Entity
public class EDireccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="CALLE")
	private String calle;
	
	@Column(name="NUMERO")
	private int numero;
	
	@Column(name="COLONIA")
	private String colonia;
	
	@Column(name="CP")
	private int cp;
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@Column(name="DELEGACION_MUNICIPIO")
	private String delegacion_municipio;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="ID_ALUMNO_DIRECCION")
	private EAlumno alumno;

	public EDireccion() {
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDelegacion_municipio() {
		return delegacion_municipio;
	}

	public void setDelegacion_municipio(String delegacion_municipio) {
		this.delegacion_municipio = delegacion_municipio;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
