package com.cyad.producciones.model;

import com.cyad.producciones.entity.ETipoProduccion;
/**
 * clase que representa el objeto java de la entidad ETipoProduccion 
 * @author Salvador Solis Atenco
 *
 */
public class MTipoProduccion {
	private long id;
	private String tipo;
	private boolean activo;
	//private List<MProduccion> producciones;
	
	public MTipoProduccion() {
		super();
	}

	public MTipoProduccion(ETipoProduccion tipo) {
		super();
		this.id = tipo.getId();
		this.tipo = tipo.getTipo();
		this.activo = tipo.isActivo();
		//this.producciones = tipo.getProducciones();
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

/*	public List<MProduccion> getProducciones() {
		return producciones;
	}

	public void setProducciones(List<MProduccion> producciones) {
		this.producciones = producciones;
	}*/

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	
}
