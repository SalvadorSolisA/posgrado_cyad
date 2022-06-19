package com.cyad.datamart.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase que representa el proyecto que desarrolla un alumno durante su instancia en el posgrado
 * @author Salvador Solis Atenco
 *
 */
@Table(name="TB_PROYECTO")
@Entity
public class EProyectoDatamart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="LGAC")
	private String lgac;
	
	@OneToOne(mappedBy = "proyecto")
	@JsonIgnore
	private EAlumnoDatamart alumno;
	
	@OneToOne
	@JoinColumn(name="ID_GRUPO_PROTOCOLO")
	private EGrupoProtocoloDatamart grupo;

	public EProyectoDatamart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLgac() {
		return lgac;
	}

	public void setLgac(String lgac) {
		this.lgac = lgac;
	}

	public EAlumnoDatamart getAlumno() {
		return alumno;
	}

	public void setAlumno(EAlumnoDatamart alumno) {
		this.alumno = alumno;
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
