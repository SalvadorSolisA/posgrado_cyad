package com.cyad.producciones.model;

import com.cyad.producciones.entity.ETipoAutor;
/**
 * clase que representa el objeto java de la entidad ETipoAutor 
 * @author Salvador Solis Atenco
 *
 */
public class MTipoAutor {
	private long id;
	private String tipo_autor;
	private boolean activo;
	//private List<MAutor> autores;
	
	public MTipoAutor() {
		super();
	}

	public MTipoAutor(ETipoAutor tipo) {
		super();
		this.id = tipo.getId();
		this.tipo_autor = tipo.getTipo_autor();
		this.activo = tipo.isActivo();
		//this.autores = tipo.getAutores();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo_autor() {
		return tipo_autor;
	}

	public void setTipo_autor(String tipo_autor) {
		this.tipo_autor = tipo_autor;
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
