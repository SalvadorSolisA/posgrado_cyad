package com.cyad.datamart.model;

import java.sql.Date;

import com.cyad.datamart.entity.EAlumnoDatamart;
/**
 * clase que representa el objeto java de la entidad EAlumnoDatamart
 * @author Salvador Solis Atenco
 *
 */
public class MAlumnoDatamart {
	private long id;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private String escuela_procedencia;
	private String trimestre_ingreso;
	private String trimestre_egreso;
	private Date fecha_examen_disertacion;
	private MProyectoDatamart proyecto;
	private MTrayectoriaDatamart trayectoria;
	
	
	
	public MAlumnoDatamart() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad alumno
	 */
	public MAlumnoDatamart(EAlumnoDatamart alumno) {
		super();
		this.id = alumno.getId();
		this.nombre = alumno.getNombre();
		this.ap_paterno = alumno.getAp_paterno();
		this.ap_materno = alumno.getAp_materno();
		this.escuela_procedencia = alumno.getEscuela_procedencia();
		this.trimestre_ingreso = alumno.getTrimestre_ingreso();
		this.trimestre_egreso = alumno.getTrimestre_egreso();
		this.fecha_examen_disertacion = alumno.getFecha_examen_disertacion();
		if(alumno.getProyecto() != null)
			this.proyecto = new MProyectoDatamart(alumno.getProyecto());
		if(alumno.getTrayectoria() != null)
			this.trayectoria = new MTrayectoriaDatamart(alumno.getTrayectoria());
	}
		
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEscuela_procedencia() {
		return escuela_procedencia;
	}

	public void setEscuela_procedencia(String escuela_procedencia) {
		this.escuela_procedencia = escuela_procedencia;
	}

	public String getTrimestre_ingreso() {
		return trimestre_ingreso;
	}

	public void setTrimestre_ingreso(String trimestre_ingreso) {
		this.trimestre_ingreso = trimestre_ingreso;
	}

	public String getTrimestre_egreso() {
		return trimestre_egreso;
	}

	public void setTrimestre_egreso(String trimestre_egreso) {
		this.trimestre_egreso = trimestre_egreso;
	}

	public Date getFecha_examen_disertacion() {
		return fecha_examen_disertacion;
	}

	public void setFecha_examen_disertacion(Date fecha_examen_disertacion) {
		this.fecha_examen_disertacion = fecha_examen_disertacion;
	}

	public MProyectoDatamart getProyecto() {
		return proyecto;
	}

	public void setProyecto(MProyectoDatamart proyecto) {
		this.proyecto = proyecto;
	}

	public MTrayectoriaDatamart getTrayectoria() {
		return trayectoria;
	}

	public void setTrayectoria(MTrayectoriaDatamart trayectoria) {
		this.trayectoria = trayectoria;
	}
	
	

}
