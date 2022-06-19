package com.cyad.posgrado.model;

import java.util.List;

import com.cyad.posgrado.entity.ETipoParticipante;
/**
 * clase que representa el objeto java de la entidad ETipoParticipante
 * @author Salvador Solis Atenco
 *
 */
public class MTipoParticipante {
	private long id;
	private String tipo;
	private boolean activo;
	private List<MParticipante> participantes;
	
	public MTipoParticipante() {
		super();
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad tipo de participante
	 */
	public MTipoParticipante(ETipoParticipante tipo) {
		super();
		this.id = tipo.getId();
		this.tipo = tipo.getTipo();
		this.activo = tipo.isActivo();
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

	public List<MParticipante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<MParticipante> participantes) {
		this.participantes = participantes;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
