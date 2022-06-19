package com.cyad.aspirantes.entity;

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
 * Esta clase representa los estados academicos de un alumno
 * @author Salvador Solis Atenco
 *
 */

@Table(name="CAT_ESTADO_ASPIRANTE")
@Entity
public class EEstadoAspirante implements Serializable{
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy = "estado")
	@JsonIgnore
	private List<EAspirante> aspirantes;

	public EEstadoAspirante() {
		super();
		this.activo = true;
	}

	/**
	 * metodo que devuelve el id del alumno
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * metodo para especificar el id del alumno
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * metodo que devuelve el estado del alumno
	 * @return estado del alumno
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * metodo para especificar el estado del alumno
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * metodo para obtener la lista de aspirantes que comparten un estado
	 * @return retorna una lista de aspirantes
	 */
	public List<EAspirante> getAspirantes() {
		return aspirantes;
	}

	/**
	 * metodo para especificar una lista de aspirantes que comparten un estado
	 * @param lista de aspirantes
	 */
	public void setAspirantes(List<EAspirante> aspirantes) {
		this.aspirantes = aspirantes;
	}

	/**
	 * metodo para obtener la version de seriaciòn del objeto
	 * @return version de seriacion
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * metodo para consultar el estado del registro
	 * @return boleano con estado
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * metodo para especificar el estado de un rtegistro
	 * @param booleano para el atributo activo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	
}
