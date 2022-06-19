package com.cyad.datamart.model;

import java.sql.Date;

import com.cyad.datamart.entity.ETrimestreDatamart;
/**
 * clase que representa el objeto java de la entidad ETrimestreDatamart
 * @author Salvador Solis Atenco
 *
 */
public class MTrimestreDatamart {
	private long id;
	private String trimestre;
	private Date fecha_inicio;
	private Date fecha_fin;
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad trimestre
	 */
	public MTrimestreDatamart(ETrimestreDatamart trimestre) {
		super();
		this.id = trimestre.getId();
		this.trimestre = trimestre.getTrimestre();
		this.fecha_inicio = trimestre.getFecha_inicio();
		this.fecha_fin = trimestre.getFecha_fin();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	
	
}	
