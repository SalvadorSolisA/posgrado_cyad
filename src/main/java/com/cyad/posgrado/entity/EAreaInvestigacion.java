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
/**
 * clase entidad representa el catalogo de areas de investigacion en los posgrados
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_AREA_INVESTIGACION")
@Entity
public class EAreaInvestigacion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="AREA_INVESTIGACION")
	private String area;
	
	@Column(name="ACTIVO")
	private boolean activo;

	// referencia al atributo
	@OneToMany(mappedBy = "area_investigacion")
	private List<EProfesor> profesores;

	public EAreaInvestigacion() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<EProfesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<EProfesor> profesores) {
		this.profesores = profesores;
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
