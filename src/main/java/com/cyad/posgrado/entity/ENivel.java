package com.cyad.posgrado.entity;
/**
 * clase entidad representa el nivel de estudios de un alumno
 * @author Salvador Solis Atenco
 *
 */
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

@Table(name="CAT_NIVEL")
@Entity
public class ENivel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="NIVEL")
	private String nivel;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy = "nivel")
	@JsonIgnore
	private List<EDatosAcademicos> datos;

	public ENivel() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<EDatosAcademicos> getDatos() {
		return datos;
	}

	public void setDatos(List<EDatosAcademicos> datos) {
		this.datos = datos;
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
