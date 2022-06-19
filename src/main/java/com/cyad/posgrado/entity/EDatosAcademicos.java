package com.cyad.posgrado.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * clase entidad representa el conjunto de datos academicos de un alumno en el posgrado
 * @author Salvador Solis Atenco
 *
 */
@Table(name="DATOS_ACADEMICOS")
@Entity
public class EDatosAcademicos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="DEDICACION")
	private String dedicacion;
	
	@Column(name="CREDITOS_CUBIERTOS")
	private int creditosCubiertos;
	
	@Column(name="CREDITOS_ACUMULADOS")
	private int creditosAcumulados;
	
	@Column(name="TRIMESTRE_INGRESO")
	private String trimestreIngreso;
	
	@Column(name="TRIMESTRE_EGRESO")
	private String trimestreEgreso;
	
	@Column(name="ULTIMO_TRIMESTRE_AA")
	private char ulimoTrimestreAa;
	
	@Column(name="ULTIMO_TRIMESTRE_RE")
	private char ulimoTrimestreRe;
	
	@Column(name="FECHA_INGRESO")
	private Date fecha_ingreso;
	
	@Column(name="FECHA_EGRESO")
	private Date fecha_egreso;	
	
	@Column(name="PROMEDIO")
	private float promedio;
	
	@Column(name="NUMERO_TRIMESTRES")
	private int numTrimestres;
	
	@Column(name="TRIMESTRE_EXAMEN")
	private char  trimestreExamen;
	
	@Column(name="ANIO_EXAMEN")
	private int anioExamen;
	
	@Column(name="ANIO_INGRESO")
	private int anioIngreso;
	
	@Column(name="FECHA_EXAMEN")
	private Date fechaExamen;
	
	@Column(name="FECHA_DISERTACION")
	private Date fecha_disertacion;
	
	@Column(name="FECHA_TITULACION")
	private Date fechaTitulacion;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="ID_NIVEL")
	private ENivel nivel;
	
	@ManyToOne
	@JoinColumn(name="ID_PLAN")
	private EPlan plan;
	
	@ManyToOne
	@JoinColumn(name="ID_AREA_CONCENTRACION")
	private EAreaConcentracion areac;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTADO_ACADEMICO")
	private EEstadoAcademico estado;
	
	@OneToOne
	@JoinColumn(name="ID_ALUMNO")
	private EAlumno alumno;

	public EDatosAcademicos() {
		super();
		this.activo = true;
		this.anioIngreso = 0;
		this.creditosCubiertos = 0;
		this.creditosAcumulados = 0;
		this.fecha_ingreso = null;
		this.fecha_egreso = null;
		this.promedio = 0;
		this.fechaExamen = null;
		this.fechaTitulacion = null;
		this.nivel= null;
		this.plan = null;
		this.areac = null;
		this.estado = null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDedicacion() {
		return dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public int getCreditosCubiertos() {
		return creditosCubiertos;
	}

	public void setCreditosCubiertos(int creditosCubiertos) {
		this.creditosCubiertos = creditosCubiertos;
	}

	public int getCreditosAcumulados() {
		return creditosAcumulados;
	}

	public void setCreditosAcumulados(int creditosAcumulados) {
		this.creditosAcumulados = creditosAcumulados;
	}

	public String getTrimestreIngreso() {
		return trimestreIngreso;
	}

	public void setTrimestreIngreso(String trimestreIngreso) {
		this.trimestreIngreso = trimestreIngreso;
	}

	public String getTrimestreEgreso() {
		return trimestreEgreso;
	}

	public void setTrimestreEgreso(String trimestreEgreso) {
		this.trimestreEgreso = trimestreEgreso;
	}

	public char getUlimoTrimestreAa() {
		return ulimoTrimestreAa;
	}

	public void setUlimoTrimestreAa(char ulimoTrimestreAa) {
		this.ulimoTrimestreAa = ulimoTrimestreAa;
	}

	public char getUlimoTrimestreRe() {
		return ulimoTrimestreRe;
	}

	public void setUlimoTrimestreRe(char ulimoTrimestreRe) {
		this.ulimoTrimestreRe = ulimoTrimestreRe;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_egreso() {
		return fecha_egreso;
	}

	public void setFecha_egreso(Date fecha_egreso) {
		this.fecha_egreso = fecha_egreso;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	public int getNumTrimestres() {
		return numTrimestres;
	}

	public void setNumTrimestres(int numTrimestres) {
		this.numTrimestres = numTrimestres;
	}

	public char getTrimestreExamen() {
		return trimestreExamen;
	}

	public void setTrimestreExamen(char trimestreExamen) {
		this.trimestreExamen = trimestreExamen;
	}

	public int getAnioExamen() {
		return anioExamen;
	}

	public void setAnioExamen(int anioExamen) {
		this.anioExamen = anioExamen;
	}

	public Date getFechaExamen() {
		return fechaExamen;
	}

	public void setFechaExamen(Date fechaExamen) {
		this.fechaExamen = fechaExamen;
	}

	public Date getFecha_disertacion() {
		return fecha_disertacion;
	}

	public void setFecha_disertacion(Date fecha_disertacion) {
		this.fecha_disertacion = fecha_disertacion;
	}

	public Date getFechaTitulacion() {
		return fechaTitulacion;
	}

	public void setFechaTitulacion(Date fechaTitulacion) {
		this.fechaTitulacion = fechaTitulacion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public ENivel getNivel() {
		return nivel;
	}

	public void setNivel(ENivel nivel) {
		this.nivel = nivel;
	}

	public EPlan getPlan() {
		return plan;
	}

	public void setPlan(EPlan plan) {
		this.plan = plan;
	}

	public EAreaConcentracion getAreac() {
		return areac;
	}

	public void setAreac(EAreaConcentracion areac) {
		this.areac = areac;
	}

	public EEstadoAcademico getEstado() {
		return estado;
	}

	public void setEstado(EEstadoAcademico estado) {
		this.estado = estado;
	}

	public EAlumno getAlumno() {
		return alumno;
	}

	public void setAlumno(EAlumno alumno) {
		this.alumno = alumno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	
}
