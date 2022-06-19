package com.cyad.posgrado.model;

import com.cyad.posgrado.entity.ECorreo;
/**
 * clase que representa el objeto java de la entidad ECorreo
 * @author Salvador Solis Atenco
 *
 */
public class MCorreo {
	private long id;
	private String correo;
	private String tipo;
	//private MAlumnoDatamart alumno;
	private boolean activo;
	
	public MCorreo() {
		super();
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad correo
	 */
	public MCorreo(ECorreo correo) {
		super();
		this.id = correo.getId();
		this.correo = correo.getCorreo();
		this.tipo = correo.getTipo();
		this.activo = correo.isActivo();
		//if(correo.getAlumno() != null)
		//this.alumno = new MAlumnoDatamart(correo.getAlumno());
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
	
	
	
	
	
}
