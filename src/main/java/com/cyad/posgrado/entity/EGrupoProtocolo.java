package com.cyad.posgrado.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase entidad representa a los grupos de protocolo
 * @author Salvador Solis Atenco
 *
 */
@Table(name="GRUPO_PROTOCOLO")
@Entity
public class EGrupoProtocolo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="CLAVE")
	private String clave;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy = "grupo_proyecto", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<EProyecto> proyectos;
	
	@OneToMany(mappedBy = "grupo_participante", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<EParticipante> participantes;

	public EGrupoProtocolo() {
		super();
		this.activo = true;
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

	public List<EProyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<EProyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
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
	
	
}
