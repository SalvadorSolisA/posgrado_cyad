package com.cyad.producciones.model;

import com.cyad.producciones.entity.EGrupoAutores;
/**
 * clase que representa el objeto java de la entidad EGrupoAutores 
 * @author Salvador Solis Atenco
 *
 */
public class MGrupoAutores {
	private long id;
	private boolean activo;
	private MProduccion produccion;
	private MOrdenAutor orden;
	private	MAutor autor;
	
	
	public MGrupoAutores() {
		super();
	}
	
	public MGrupoAutores(EGrupoAutores autores) {
		super();
		this.id = autores.getId();
		this.activo = autores.isActivo();
		/*if(autores.getProduccion() != null)
			this.produccion = new MProduccion(autores.getProduccion());*/
		if(autores.getOrden() != null)
			this.orden = new MOrdenAutor(autores.getOrden());
		if(autores.getAutor() != null)
			this.autor = new MAutor(autores.getAutor());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MProduccion getProduccion() {
		return produccion;
	}

	public void setProduccion(MProduccion produccion) {
		this.produccion = produccion;
	}

	public MOrdenAutor getOrden() {
		return orden;
	}

	public void setOrden(MOrdenAutor orden) {
		this.orden = orden;
	}

	public MAutor getAutor() {
		return autor;
	}

	public void setAutor(MAutor autor) {
		this.autor = autor;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	
}
