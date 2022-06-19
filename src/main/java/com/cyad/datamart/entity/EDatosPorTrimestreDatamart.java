package com.cyad.datamart.entity;

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
 * clase que representa los datos academicos de un alumno durante el trimestre actual
 * @author Salvador Solis Atenco
 *
 */
@Table(name="TB_DATOS_POR_TRIMESTRE")
@Entity
public class EDatosPorTrimestreDatamart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="PROMEDIO")
	private Float promedio;
	
	@Column(name="CREDITOS")
	private int creditos;
	
	@ManyToOne
	@JoinColumn(name="ID_TRIMESTRE")
	private ETrimestreDatamart trimestre;
	
	@ManyToOne
	@JoinColumn(name="ID_TRAYECTORIA")
	private ETrayectoriaDatamart trayectoria;

	public EDatosPorTrimestreDatamart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Float getPromedio() {
		return promedio;
	}

	public void setPromedio(Float promedio) {
		this.promedio = promedio;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public ETrimestreDatamart getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(ETrimestreDatamart trimestre) {
		this.trimestre = trimestre;
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
