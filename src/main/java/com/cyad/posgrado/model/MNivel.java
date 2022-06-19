package com.cyad.posgrado.model;

import com.cyad.posgrado.entity.ENivel;
/**
 * clase que representa el objeto java de la entidad ENivel
 * @author Salvador Solis Atenco
 *
 */
public class MNivel {
	private long id;
	private String nivel;
	private boolean activo;
	//private List<MDatosAcademicos> datos;
	public MNivel() {
		super();
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad nivel
	 */
	public MNivel(ENivel nivel) {
		super();
		this.id = nivel.getId();
		this.nivel = nivel.getNivel();
		this.activo = nivel.isActivo();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	/*public List<MDatosAcademicos> getDatos() {
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
