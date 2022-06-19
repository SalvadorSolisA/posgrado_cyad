package com.cyad.producciones.model;

import java.util.ArrayList;
import java.util.List;

import com.cyad.producciones.entity.EGrupoAutores;
import com.cyad.producciones.entity.EProduccion;
/**
 * clase que representa el objeto java de la entidad EProduccion 
 * @author Salvador Solis Atenco
 *
 */
public class MProduccion {
	private long id;
	private String clave_producto;
	private String titulo;
	private String nombre_archivo;
	private String fecha_publicacion;
	private String descripcion;
	private String lgac;
	private byte[] documento;
	private boolean activo;
	private MTipoProduccion tipo;
	private List<MGrupoAutores> autores;

	public MProduccion() {
		super();
	}

	public MProduccion(EProduccion produccion) {
		super();
		this.id = produccion.getId();
		this.clave_producto = produccion.getClave_producto();
		this.titulo = produccion.getTitulo();
		this.nombre_archivo = produccion.getNombre_archivo();
		this.fecha_publicacion = produccion.getFecha_publicacion();
		this.descripcion = produccion.getDescripcion();
		this.lgac = produccion.getLgac();
		this.activo = produccion.isActivo();
		if (produccion.getTipo() != null)
			this.tipo = new MTipoProduccion(produccion.getTipo());
		if(produccion.getAutores() != null) {
			this.autores = new ArrayList<MGrupoAutores>();
			for(EGrupoAutores autor: produccion.getAutores()) {
				this.autores.add(new MGrupoAutores(autor));
			}
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClave_producto() {
		return clave_producto;
	}

	public void setClave_producto(String clave_producto) {
		this.clave_producto = clave_producto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLgac() {
		return lgac;
	}

	public void setLgac(String lgac) {
		this.lgac = lgac;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public MTipoProduccion getTipo() {
		return tipo;
	}

	public void setTipo(MTipoProduccion tipo) {
		this.tipo = tipo;
	}

	public List<MGrupoAutores> getAutores() {
		return autores;
	}

	public void setAutores(List<MGrupoAutores> autores) {
		this.autores = autores;
	}

	public String getNombre_archivo() {
		return nombre_archivo;
	}

	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}
	

}
