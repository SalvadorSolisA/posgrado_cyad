package com.cyad.posgrado.model;

import java.sql.Date;

import com.cyad.posgrado.entity.ETrimestre;
/**
 * clase que representa el objeto java de la entidad ETrimestre
 * @author Salvador Solis Atenco
 *
 */
public class MTrimestre {
	private long id;
	private Date fecha_inicio;
	private Date fecha_fin;
	private String trimestre;
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad trimestre
	 */
	public MTrimestre(ETrimestre trimestre) {
		super();
		this.id = trimestre.getId();
		this.fecha_inicio = trimestre.getFecha_inicio();
		this.fecha_fin = trimestre.getFecha_fin();
		this.trimestre = trimestre.getTrimestre();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getTrimestre() {
		return trimestre;
	}
	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}
	
	
}
