package com.cyad.datamart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * clase que representa a un participante de un grupo de protocolo
 * @author Salvador Solis Atenco
 *
 */
@Table(name="TB_PARTICIPANTE")
@Entity
public class EParticipanteDatamart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="ROL")
	private String rol;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="AP_PATERNO")
	private String ap_paterno;
	
	@Column(name="AP_MATERNO")
	private String ap_materno;
	
	@ManyToOne
	@JoinColumn(name="ID_GRUPO_PROTOCOLO")
	private EGrupoProtocoloDatamart grupo;

	public EParticipanteDatamart() {
		super();
		// TODO Auto-generated constructor stub
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

	public EGrupoProtocoloDatamart getGrupo() {
		return grupo;
	}

	public void setGrupo(EGrupoProtocoloDatamart grupo) {
		this.grupo = grupo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
