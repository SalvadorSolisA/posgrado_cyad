package com.cyad.datamart.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase que representa a un grupo de protocolo de un proyecto
 * @author Salvador Solis Atenco
 *
 */
@Table(name="TB_GRUPO_PROTOCOLO")
@Entity
public class EGrupoProtocoloDatamart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private long id;
	
	@OneToOne(mappedBy = "grupo", fetch=FetchType.EAGER)
	@JsonIgnore
	private EProyectoDatamart proyecto;
	
	@OneToMany(mappedBy = "grupo", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<EParticipanteDatamart> participantes;

	public EGrupoProtocoloDatamart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EProyectoDatamart getProyecto() {
		return proyecto;
	}

	public void setProyecto(EProyectoDatamart proyecto) {
		this.proyecto = proyecto;
	}

	public List<EParticipanteDatamart> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<EParticipanteDatamart> participantes) {
		this.participantes = participantes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
