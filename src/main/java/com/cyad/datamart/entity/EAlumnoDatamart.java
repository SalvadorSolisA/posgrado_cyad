package com.cyad.datamart.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * clase que representa a un alumno del posgrado
 * @author Salvador Solis Atenco
 *
 */
@Table(name="TB_ALUMNO")
@Entity
public class EAlumnoDatamart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="AP_PATERNO")
	private String ap_paterno;
	
	@Column(name="AP_MATERNO")
	private String ap_materno;
	
	@Column(name="ESCUELA_PROCEDENCIA")
	private String escuela_procedencia;
	
	@Column(name="TRIMESTRE_INGRESO")
	private String trimestre_ingreso;
	
	@Column(name="TRIMESTRE_EGRESO")
	private String trimestre_egreso;
	
	@Column(name="FECHA_EXAMEN_DISERTACION")
	private Date fecha_examen_disertacion;
	
	@OneToOne
	@JoinColumn(name="ID_PROYECTO")
	private EProyectoDatamart proyecto;
	
	@OneToOne
	@JoinColumn(name="ID_TRAYECTORIA")
	private ETrayectoriaDatamart trayectoria;

	public EAlumnoDatamart() {
		super();
		// TODO Auto-generated constructor stub
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

	public EProyectoDatamart getProyecto() {
		return proyecto;
	}

	public void setProyecto(EProyectoDatamart proyecto) {
		this.proyecto = proyecto;
	}

	public ETrayectoriaDatamart getTrayectoria() {
		return trayectoria;
	}

	public void setTrayectoria(ETrayectoriaDatamart trayectoria) {
		this.trayectoria = trayectoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
