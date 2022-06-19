package com.cyad.posgrado.entity;

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
 * clase entidad representa a los tipos de proyectos que desarrollan los alumnos del posgrado
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_TIPO_PROYECTO")
@Entity
public class ETipoProyecto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="TIPO")
	private String tipo;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy = "tipo")
	@JsonIgnore
	List<ETipoProyecto> proyectos;

	public ETipoProyecto() {
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

	public List<ETipoProyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<ETipoProyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	
}
