package com.cyad.posgrado.model;

import java.util.List;

import com.cyad.posgrado.entity.EDepartamento;
/**
 * clase que representa el objeto java de la entidad EDepartamento
 * @author Salvador Solis Atenco
 *
 */
public class MDepartamento {

	private long id;
	private String departamento;
	private boolean activo;
	private List<MProfesor> profesores;
	
	public MDepartamento() {
		
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad departamento
	 */
	public MDepartamento(EDepartamento departamento) {
		super();
		this.id = departamento.getId();
		this.departamento = departamento.getDepartamento();
		this.activo = departamento.isActivo();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
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
