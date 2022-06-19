package com.cyad.posgrado.model;

import com.cyad.posgrado.entity.EParticipante;
/**
 * clase que representa el objeto java de la entidad EParticipante
 * @author Salvador Solis Atenco
 *
 */
public class MParticipante {
	private long id;
	private MProfesor profesor;
	private MRol rol;
	private MTipoParticipante tipo;
	private boolean activo;
	
	public MParticipante() {
		super();
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad participante
	 */
	public MParticipante(EParticipante participante) {
		super();
		this.id = participante.getId();
		this.activo = participante.isActivo();
		if(participante.getProfesor() != null)
			this.profesor = new MProfesor(participante.getProfesor());
		if(participante.getRol() != null)
			this.rol = new MRol(participante.getRol());
		if(participante.getTipo() != null)
			this.tipo = new MTipoParticipante(participante.getTipo());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MProfesor getProfesor() {
		return profesor;
	}

	public void setProfesor(MProfesor profesor) {
		this.profesor = profesor;
	}

	public MRol getRol() {
		return rol;
	}

	public void setRol(MRol rol) {
		this.rol = rol;
	}

	public MTipoParticipante getTipo() {
		return tipo;
	}

	public void setTipo(MTipoParticipante tipo) {
		this.tipo = tipo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
