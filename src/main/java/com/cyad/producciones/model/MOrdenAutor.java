package com.cyad.producciones.model;

import com.cyad.producciones.entity.EOrdenAutor;
/**
 * clase que representa el objeto java de la entidad EOrdenAutor 
 * @author Salvador Solis Atenco
 *
 */
public class MOrdenAutor {
	private long id;
	private String orden;
	private boolean activo;
	//private List<MGrupoAutores> autores;
	
	public MOrdenAutor() {
		super();
	}
	
	public MOrdenAutor(EOrdenAutor orden) {
		super();
		this.id = orden.getId();
		this.orden = orden.getOrden();
		this.activo = orden.isActivo();
		//if(orden.getAutores() != null)
		//this.autores = convertirAutores(orden.getAutores());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}
/*
	public List<MGrupoAutores> getAutores() {
		return autores;
	}

	public void setAutores(List<MGrupoAutores> autores) {
		this.autores = autores;
	}
	
	private List<MGrupoAutores> convertirAutores(List<EGrupoAutores> eGrupoAutores) {
		List<MGrupoAutores> mGrupoAutores = new ArrayList<>();
		for(EGrupoAutores autor : eGrupoAutores)
			mGrupoAutores.add(new MGrupoAutores(autor));
		return mGrupoAutores;
	}*/

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
