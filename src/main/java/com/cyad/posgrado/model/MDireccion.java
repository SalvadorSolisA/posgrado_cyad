package com.cyad.posgrado.model;

import com.cyad.posgrado.entity.EDireccion;
/**
 * clase que representa el objeto java de la entidad EDireccion
 * @author Salvador Solis Atenco
 *
 */
public class MDireccion {
	
	private long id;
	
	private String calle;
	
	private int numero;
	
	private String colonia;
	
	private int cp;
	
	private String ciudad;
	
	private String delegacion_municipio;
	
	private boolean activo;
	
	//private MAlumnoDatamart alumno;

	public MDireccion() {
		
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad direccion
	 */
	public MDireccion(EDireccion direccion) {
		super();
		this.id = direccion.getId();
		this.calle = direccion.getCalle();
		this.numero = direccion.getNumero();
		this.colonia = direccion.getColonia();
		this.cp = direccion.getCp();
		this.ciudad = direccion.getCiudad();
		this.activo = direccion.isActivo();
		this.delegacion_municipio = direccion.getDelegacion_municipio();
		//if(direccion.getAlumno() != null)
		//this.alumno = new MAlumnoDatamart(direccion.getAlumno());
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

	/*public MAlumnoDatamart getAlumno() {
		return alumno;
	}

	public void setAlumno(MAlumnoDatamart alumno) {
		this.alumno = alumno;
	}*/

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
