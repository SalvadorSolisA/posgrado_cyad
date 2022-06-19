package com.cyad.producciones.model;

import java.util.ArrayList;
import java.util.List;

import com.cyad.producciones.entity.EAutor;
import com.cyad.producciones.entity.EGrupoAutores;
/**
 * clase que representa el objeto java de la entidad EAutor 
 * @author Salvador Solis Atenco
 *
 */
public class MAutor {
	private long id;
	private String clave;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private MTipoClave tipo_clave;
	private MTipoAutor tipo_autor;
	private String nacionalidad;
	private boolean activo;
	//private List<MGrupoAutores> grupo_autores;
	
	public MAutor() {
		super();
	}

	public MAutor(EAutor autor) {
		super();
		this.id = autor.getId();
		this.clave = autor.getClave();
		this.nombre = autor.getNombre();
		this.ap_paterno = autor.getAp_paterno();
		this.ap_materno = autor.getAp_materno();
		this.nacionalidad = autor.getNacionalidad();
		this.activo = autor.isActivo();
		
		if(autor.getTipo_clave() != null)
			this.tipo_clave = new MTipoClave(autor.getTipo_clave());
		if(autor.getTipo_autor() != null)
			this.tipo_autor = new MTipoAutor(autor.getTipo_autor());
		//if(autor.getAutores() != null)
		//this.autores = converterAutores(autor.getAutores());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}

	public MTipoClave getTipo_clave() {
		return tipo_clave;
	}

	public void setTipo_clave(MTipoClave tipo_clave) {
		this.tipo_clave = tipo_clave;
	}

	public MTipoAutor getTipo_autor() {
		return tipo_autor;
	}

	public void setTipo_autor(MTipoAutor tipo_autor) {
		this.tipo_autor = tipo_autor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

/*	public List<MGrupoAutores> getAutores() {
		return grupo_autores;
	}

	public void setAutores(List<MGrupoAutores> autores) {
		this.grupo_autores = autores;
	}*/
	
	public List<MGrupoAutores> converterAutores(List<EGrupoAutores> e_grupos_autores){
		List<MGrupoAutores > modelo_grupo_autores = new ArrayList<>();
		for(EGrupoAutores  e_grupo_autores : e_grupos_autores) {
			modelo_grupo_autores.add(new MGrupoAutores (e_grupo_autores));
		}
		return modelo_grupo_autores;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
}
