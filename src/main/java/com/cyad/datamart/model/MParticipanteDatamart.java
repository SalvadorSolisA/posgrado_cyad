package com.cyad.datamart.model;

import com.cyad.datamart.entity.EParticipanteDatamart;
/**
 * clase que representa el objeto java de la entidad EParticipanteDatamart
 * @author Salvador Solis Atenco
 *
 */
public class MParticipanteDatamart {
	private long id;
	private String rol;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad participante
	 */
	public MParticipanteDatamart(EParticipanteDatamart participante) {
		super();
		this.id = participante.getId();
		this.rol = participante.getRol();
		this.nombre = participante.getNombre();
		this.ap_paterno = participante.getAp_paterno();
		this.ap_materno = participante.getAp_materno();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}
	
	
	
	
}
