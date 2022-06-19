package com.cyad.posgrado.model;

import java.sql.Date;

import com.cyad.posgrado.entity.EDatosAcademicos;
/**
 * clase que representa el objeto java de la entidad EDatosAcademicos
 * @author Salvador Solis Atenco
 *
 */
public class MDatosAcademicos {
	private long id;
	private String dedicacion;
	private int creditosCubiertos;
	private int creditosAcumulados;
	private String trimestreIngreso;
	private String trimestreEgreso;
	private char ulimoTrimestreAa;
	private char ulimoTrimestreRe;
	private Date fecha_ingreso;
	private Date fecha_egreso;
	private float promedio;
	private int numTrimestres;
	private char  trimestreExamen;
	private int anioExamen;
	private int anioIngreso;
	private Date fechaExamen;
	private Date fechaTitulacion;
	private Date fecha_disertacion;
	private boolean activo;
	private MNivel nivel;
	private MPlan plan;
	private MAreaConcentracion areac;
	private MEstadoAcademico estado;
	

	public MDatosAcademicos() {
		super();
		this.dedicacion = "";
		this.creditosCubiertos = 0;
		this.creditosAcumulados = 0;
		this.trimestreIngreso = "";
		this.trimestreEgreso = "";
		this.ulimoTrimestreAa = ' ';
		this.ulimoTrimestreRe = ' ';
		this.fecha_ingreso = null;
		this.fecha_egreso = null;
		this.promedio = 0;
		this.numTrimestres = 0;
		this.trimestreExamen = ' ';
		this.anioExamen = 0;
		this.fechaExamen = null;
		this.fechaTitulacion = null;
		this.fecha_disertacion = null;
		this.nivel= null;
		this.plan = null;
		this.areac = null;
		this.estado = null;
	}
	
	
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad datos academicos
	 */
	public MDatosAcademicos(EDatosAcademicos datos) {
		super();
		this.id = datos.getId();
		this.dedicacion = datos.getDedicacion();
		this.creditosCubiertos = datos.getCreditosCubiertos();
		this.creditosAcumulados = datos.getCreditosAcumulados();
		this.trimestreIngreso = datos.getTrimestreIngreso();
		this.ulimoTrimestreAa = datos.getUlimoTrimestreAa();
		this.ulimoTrimestreRe = datos.getUlimoTrimestreRe();
		this.fecha_ingreso = datos.getFecha_ingreso();
		this.fecha_egreso = datos.getFecha_egreso();
		this.promedio = datos.getPromedio();
		this.numTrimestres = datos.getNumTrimestres();
		this.trimestreExamen = datos.getTrimestreExamen();
		this.anioExamen = datos.getAnioExamen();
		this.anioIngreso = datos.getAnioIngreso();
		this.fechaExamen = datos.getFechaExamen();
		this.fechaTitulacion = datos.getFechaTitulacion();
		this.fecha_disertacion = datos.getFecha_disertacion();
		this.activo = datos.isActivo();
		if(datos.getNivel() != null)
			this.nivel = new MNivel (datos.getNivel());
		if(datos.getPlan() != null)
			this.plan = new MPlan (datos.getPlan());
		if(datos.getAreac() != null)
			this.areac = new MAreaConcentracion (datos.getAreac());
		if(datos.getEstado() != null)
			this.estado = new MEstadoAcademico (datos.getEstado());
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



	public Date getFechaTitulacion() {
		return fechaTitulacion;
	}



	public void setFechaTitulacion(Date fechaTitulacion) {
		this.fechaTitulacion = fechaTitulacion;
	}



	public Date getFecha_disertacion() {
		return fecha_disertacion;
	}



	public void setFecha_disertacion(Date fecha_disertacion) {
		this.fecha_disertacion = fecha_disertacion;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	public MNivel getNivel() {
		return nivel;
	}



	public void setNivel(MNivel nivel) {
		this.nivel = nivel;
	}



	public MPlan getPlan() {
		return plan;
	}



	public void setPlan(MPlan plan) {
		this.plan = plan;
	}



	public MAreaConcentracion getAreac() {
		return areac;
	}



	public void setAreac(MAreaConcentracion areac) {
		this.areac = areac;
	}



	public MEstadoAcademico getEstado() {
		return estado;
	}



	public void setEstado(MEstadoAcademico estado) {
		this.estado = estado;
	}



	public int getAnioIngreso() {
		return anioIngreso;
	}



	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	
}
