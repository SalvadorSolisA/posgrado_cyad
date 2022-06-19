package com.cyad.posgrado.model;

import com.cyad.posgrado.entity.ETipoProyecto;
/**
 * clase que representa el objeto java de la entidad ETipoProyecto
 * @author Salvador Solis Atenco
 *
 */
public class MTipoProyecto {
	private long id;
	private String tipo;
	private boolean activo;
	
	public MTipoProyecto() {
		super();
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad tipo de proyecto
	 */
	public MTipoProyecto(ETipoProyecto proyecto) {
		super();
		this.id = proyecto.getId();
		this.tipo = proyecto.getTipo();
		this.activo = proyecto.isActivo();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
