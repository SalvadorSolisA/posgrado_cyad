package com.cyad.posgrado.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * clase entidad representa a los periodos trimestrales
 * @author Salvador Solis Atenco
 *
 */
@Table(name="TRIMESTRES")
@Entity
public class ETrimestre {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="FECHA_INICIO")
	private Date fecha_inicio;
	
	@Column(name="FECHA_FIN")
	private Date fecha_fin;
	
	@Column(name="TRIMESTRE")
	private String trimestre;

	public ETrimestre() {
		super();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
