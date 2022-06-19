package com.cyad.producciones.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * clase entidad que representa el orden de autor
 * @author Salvador Solis Atenco
 *
 */
@Table(name="ORDEN_AUTOR")
@Entity
public class EOrdenAutor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="ORDEN")
	private String orden;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	/*
	@OneToMany(mappedBy="orden")
	@JsonIgnore
	@Transient
	private List<EGrupoAutores> autores;
*/
	public EOrdenAutor() {
		super();
		this.activo = true;
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
	public List<EGrupoAutores> getAutores() {
		return autores;
	}

	public void setAutores(List<EGrupoAutores> autores) {
		this.autores = autores;
	}
	
	*/

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
