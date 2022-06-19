package com.cyad.producciones.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase entidad que representa el tipo de produccion
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_TIPO_PRODUCCION")
@Entity
public class ETipoProduccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="TIPO_PRODUCCION")
	private String tipo;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy="tipo")
	@JsonIgnore
	private List<EProduccion> producciones;

	public ETipoProduccion() {
		super();
		this.activo = true;
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

	public List<EProduccion> getProducciones() {
		return producciones;
	}

	public void setProducciones(List<EProduccion> producciones) {
		this.producciones = producciones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
