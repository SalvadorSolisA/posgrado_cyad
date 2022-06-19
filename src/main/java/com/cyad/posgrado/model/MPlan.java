package com.cyad.posgrado.model;

import com.cyad.posgrado.entity.EPlan;
/**
 * clase que representa el objeto java de la entidad EPlan
 * @author Salvador Solis Atenco
 *
 */
public class MPlan {
	private long id;
	private int clave;
	private int creditos;
	private int duracion;
	private String division;
	private boolean activo;
	//private List<MDatosAcademicos> datos;
	
	public MPlan() {
		super();
	}

	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad plan
	 */
	public MPlan(EPlan plan) {
		super();
		this.id = plan.getId();
		this.clave = plan.getClave();
		this.creditos = plan.getCreditos();
		this.duracion = plan.getDuracion();
		this.division = plan.getDivision();
		this.activo = plan.isActivo();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int durecion) {
		this.duracion = durecion;
	}

	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	/*/public List<MDatosAcademicos> getDatos() {
		return datos;
	}

	public void setDatos(List<MDatosAcademicos> datos) {
		this.datos = datos;
	}*/

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	
}
