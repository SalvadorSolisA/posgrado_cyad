package com.cyad.datamart.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase que representa los periodos trimestretrales
 * @author Salvador Solis Atenco
 *
 */
@Table(name="CAT_TRIMESTRES")
@Entity
public class ETrimestreDatamart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="TRIMESTRE")
	private String trimestre;
	
	@Column(name="FECHA_INICIO")
	private Date fecha_inicio;
	
	@Column(name="FECHA_FIN")
	private Date fecha_fin;
	
	@Column(name="ISPROCESADO")
	private boolean isProcesado;
	
	@OneToMany(mappedBy = "trimestre")
	@JsonIgnore
	private List<EDatosPorTrimestreDatamart> datos;

	public ETrimestreDatamart() {
		super();
		// TODO Auto-generated constructor stub
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

	public boolean isProcesado() {
		return isProcesado;
	}

	public void setProcesado(boolean isProcesado) {
		this.isProcesado = isProcesado;
	}

	public List<EDatosPorTrimestreDatamart> getDatos() {
		return datos;
	}

	public void setDatos(List<EDatosPorTrimestreDatamart> datos) {
		this.datos = datos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
