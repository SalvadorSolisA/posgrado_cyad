package com.cyad.posgrado.model;

import com.cyad.posgrado.entity.EAreaConcentracion;
/**
 * clase que representa el objeto java de la entidad EAreaConcentracion
 * @author Salvador Solis Atenco
 *
 */
public class MAreaConcentracion {
	private long id;
	private String area;
	private boolean activo;
	//private List<EDatosAcademicos> datos;
	
	public MAreaConcentracion() {
		super();
	}

	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad area de concentracion
	 */
	public MAreaConcentracion(EAreaConcentracion area) {
		super();
		this.id = area.getId();
		this.area = area.getArea();
		this.activo = area.isActivo();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	/*public List<EDatosAcademicos> getDatos() {
		return datos;
	}

	public void setDatos(List<EDatosAcademicos> datos) {
		this.datos = datos;
	}*/

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
