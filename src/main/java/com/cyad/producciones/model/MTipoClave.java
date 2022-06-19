package com.cyad.producciones.model;

import com.cyad.producciones.entity.ETipoClave;
/**
 * clase que representa el objeto java de la entidad ETipoClave 
 * @author Salvador Solis Atenco
 *
 */
public class MTipoClave {
	private long id;
	private String tipo;
	private boolean activo;
	//private List<MAutor> autores;
	
	public MTipoClave() {
		super();
		this.activo = true;
	}

	public MTipoClave(ETipoClave clave) {
		super();
		this.id = clave.getId();
		this.tipo = clave.getTipo();
		this.activo = clave.isActivo();
		//this.autores = (clave.getAutores());
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

/*	public List<MAutor> getAutores() {
		return autores;
	}

	public void setAutores(List<MAutor> autores) {
		this.autores = autores;
	}*/
	

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
