package com.cyad.aspirantes.model;

import java.util.List;

import com.cyad.aspirantes.entity.EEstadoAspirante;
/**
 * clase que reprenta el modelo de objeto de un estado de aspirante a posgrado
 * @author Salvador Solis Atenco
 *
 */
public class MEstadoAspirante {
	private long id;
	private String estado;
	private boolean activo;
	private List<MAspirante> aspirantes;
	
	public MEstadoAspirante() {
		super();
	}
	
	public MEstadoAspirante(EEstadoAspirante estado) {
		super();
		this.id = estado.getId();
		this.estado = estado.getEstado();
		this.activo = estado.isActivo();
		//this.aspirantes = estado.getAspirantes();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<MAspirante> getAspirantes() {
		return aspirantes;
	}

	public void setAspirantes(List<MAspirante> aspirantes) {
		this.aspirantes = aspirantes;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
