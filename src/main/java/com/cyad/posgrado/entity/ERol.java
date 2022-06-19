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

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase entidad representa a los roles que tiene un participante en un grupo de protocolo
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_ROL")
@Entity
public class ERol implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="ROL")
	private String rol;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy = "rol")
	@JsonIgnore
	private List<EParticipante> participantes;

	public ERol() {
		super();
		this.activo = true;
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

	public List<EParticipante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<EParticipante> participantes) {
		this.participantes = participantes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	
	
}
