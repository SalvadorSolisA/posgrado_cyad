package com.cyad.posgrado.model;

import java.util.ArrayList;
import java.util.List;

import com.cyad.posgrado.entity.EGrupoProtocolo;
import com.cyad.posgrado.entity.EParticipante;
/**
 * clase que representa el objeto java de la entidad EGrupoProtocolo
 * @author Salvador Solis Atenco
 *
 */
public class MGrupoProtocolo {
	private long id;
	private String clave;
	private boolean activo;
	private List<MParticipante> participantes;
	
	public MGrupoProtocolo() {
		super();
	}
		
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad grupo protocolo
	 */
	public MGrupoProtocolo(EGrupoProtocolo grupo) {
		super();
		this.id = grupo.getId();
		this.clave = grupo.getClave();
		this.activo = grupo.isActivo();
		
		if(grupo.getParticipantes() != null) {
			this.participantes = new ArrayList<MParticipante>();
			
			for(EParticipante participante : grupo.getParticipantes()) {
				this.participantes.add(new MParticipante(participante));
			}
			
		}
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public List<MParticipante> getParticipantes() {
		return participantes;
	}


	public void setParticipantes(List<MParticipante> participantes) {
		this.participantes = participantes;
	}
	
	
	
	
}
