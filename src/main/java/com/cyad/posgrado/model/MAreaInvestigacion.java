package com.cyad.posgrado.model;

import java.util.List;

import com.cyad.posgrado.entity.EAreaInvestigacion;
/**
 * clase que representa el objeto java de la entidad EAreaInvestigacion
 * @author Salvador Solis Atenco
 *
 */
public class MAreaInvestigacion {
	private long id;
	private String area_investigacion;
	private boolean activo;
	private List<MProfesor> profesores;
	
	public MAreaInvestigacion() {
		
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad area de investigacion
	 */
	public MAreaInvestigacion(EAreaInvestigacion area_investigacion) {
		super();
		this.id = area_investigacion.getId();
		this.area_investigacion = area_investigacion.getArea();
		this.activo = area_investigacion.isActivo();
		//this.profesores = convertProfesores(area_investigacion.getProfesores());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArea_investigacion() {
		return area_investigacion;
	}

	public void setArea_investigacion(String area_investigacion) {
		this.area_investigacion = area_investigacion;
	}

	public List<MProfesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<MProfesor> profesores) {
		this.profesores = profesores;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
