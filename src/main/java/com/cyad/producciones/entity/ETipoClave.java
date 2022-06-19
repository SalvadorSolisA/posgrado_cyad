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
 * clase entidad que representa el tipo de clave de autor
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_TIPO_CLAVE")
@Entity
public class ETipoClave implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="TIPO_CLAVE")
	private String tipo;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy="tipo_clave")
	@JsonIgnore
	private List<EAutor> autores;

	public ETipoClave() {
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

	public List<EAutor> getAutores() {
		return autores;
	}

	public void setAutores(List<EAutor> autores) {
		this.autores = autores;
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
