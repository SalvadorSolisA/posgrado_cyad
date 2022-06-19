package com.cyad.producciones.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * clase entidad que representa al grupo de autores
 * @author Salvador Solis Atenco
 *
 */
@Table(name="GRUPO_AUTORES")
@Entity
public class EGrupoAutores  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCCION")
	private EProduccion produccion;
	
	@ManyToOne
	@JoinColumn(name="ID_ORDEN_AUTOR")
	private EOrdenAutor orden;
	
	@ManyToOne
	@JoinColumn(name="ID_AUTOR")
	private	EAutor autor;

	public EGrupoAutores() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EProduccion getProduccion() {
		return produccion;
	}

	public void setProduccion(EProduccion produccion) {
		this.produccion = produccion;
	}

	public EOrdenAutor getOrden() {
		return orden;
	}

	public void setOrden(EOrdenAutor orden) {
		this.orden = orden;
	}

	public EAutor getAutor() {
		return autor;
	}

	public void setAutor(EAutor autor) {
		this.autor = autor;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	
}
