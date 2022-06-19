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
 * clase entidad representa a los proyectos creados por alumnos en los posgrado
 * @author Salvador Solis Atenco
 *
 */
@Table(name="PROYECTO")
@Entity
public class EProyecto implements Serializable{
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
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="FECHA_INICIO")
	private String fecha_inicio;
	
	@Column(name="FECHA_TERMINO")
	private String fecha_termino;
	
	@Column(name="LGAC")
	private String lgac;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="ID_ALUMNO")
	private EAlumno alumno;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO")
	private ETipoProyecto tipo;
	
	@ManyToOne
	@JoinColumn(name="ID_GRUPO")
	private EGrupoProtocolo grupo_proyecto;

	public EProyecto() {
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_termino() {
		return fecha_termino;
	}

	public void setFecha_termino(String fecha_termino) {
		this.fecha_termino = fecha_termino;
	}

	public String getLgac() {
		return lgac;
	}

	public void setLgac(String lgac) {
		this.lgac = lgac;
	}

	public EAlumno getAlumno() {
		return alumno;
	}

	public void setAlumno(EAlumno alumno) {
		this.alumno = alumno;
	}

	public ETipoProyecto getTipo() {
		return tipo;
	}

	public void setTipo(ETipoProyecto tipo) {
		this.tipo = tipo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EGrupoProtocolo getGrupo_proyecto() {
		return grupo_proyecto;
	}

	public void setGrupo_proyecto(EGrupoProtocolo grupo_proyecto) {
		this.grupo_proyecto = grupo_proyecto;
	}

	
}
