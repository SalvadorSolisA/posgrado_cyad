package com.cyad.posgrado.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * clase entidad representa a los participantes de un grupo de protocolo
 * @author Salvador Solis Atenco
 *
 */
@Table(name="PARTICIPANTES")
@Entity
public class EParticipante implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="ID_GRUPO")
	private EGrupoProtocolo grupo_participante;
	
	@ManyToOne
	@JoinColumn(name="ID_PROFESOR")
	private EProfesor profesor;
	
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private ERol rol;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_PARTICIPANTE")
	private ETipoParticipante tipo;

	public EParticipante() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public EGrupoProtocolo getGrupo_participante() {
		return grupo_participante;
	}

	public void setGrupo_participante(EGrupoProtocolo grupo_participante) {
		this.grupo_participante = grupo_participante;
	}

	public EProfesor getProfesor() {
		return profesor;
	}

	public void setProfesor(EProfesor profesor) {
		this.profesor = profesor;
	}

	public ERol getRol() {
		return rol;
	}

	public void setRol(ERol rol) {
		this.rol = rol;
	}

	public ETipoParticipante getTipo() {
		return tipo;
	}

	public void setTipo(ETipoParticipante tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
