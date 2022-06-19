package com.cyad.posgrado.model;

import com.cyad.posgrado.entity.EProyecto;
/**
 * clase que representa el objeto java de la entidad EProyecto
 * @author Salvador Solis Atenco
 *
 */
public class MProyecto {
	private long id;
	private String clave;
	private String descripcion;
	private String fecha_inicio;
	private String fecha_termino;
	private String lgac;
	private String titulo;
	private boolean activo;
	private MAlumno alumno;
	private MTipoProyecto tipo;
	private MGrupoProtocolo grupo;
	
	public MProyecto() {
		super();
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad proyecto
	 */
	public MProyecto(EProyecto proyecto) {
		super();
		this.id = proyecto.getId();
		this.clave = proyecto.getClave();
		this.descripcion = proyecto.getDescripcion();
		this.fecha_inicio = proyecto.getFecha_inicio();
		this.fecha_termino = proyecto.getFecha_termino();
		this.lgac = proyecto.getLgac();
		this.titulo = proyecto.getTitulo();
		this.activo = proyecto.isActivo(); 
		if(proyecto.getAlumno() != null)
			this.alumno = new MAlumno(proyecto.getAlumno());
		if(proyecto.getTipo() != null)
			this.tipo = new MTipoProyecto(proyecto.getTipo());
		if(proyecto.getGrupo_proyecto() != null)
			this.grupo = new MGrupoProtocolo(proyecto.getGrupo_proyecto());
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

	public MAlumno getAlumno() {
		return alumno;
	}

	public void setAlumno(MAlumno alumno) {
		this.alumno = alumno;
	}

	public MTipoProyecto getTipo() {
		return tipo;
	}

	public void setTipo(MTipoProyecto tipo) {
		this.tipo = tipo;
	}

	public MGrupoProtocolo getGrupo() {
		return grupo;
	}

	public void setGrupo(MGrupoProtocolo grupo) {
		this.grupo = grupo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	
}
