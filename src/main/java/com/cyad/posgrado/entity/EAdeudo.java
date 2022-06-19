package com.cyad.posgrado.entity;

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
 * clase entidad representa los adeudos de documentacion de un alumno
 * @author Salvador Solis Atenco
 *
 */
@Table(name="ADEUDOS_INGRESO")
@Entity
public class EAdeudo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="DOCUMENTO")
	private String documento;
	
	@Column(name="TIPO")
	private String tipo;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="ID_DATOS_INGRESO")
	private EDatosIngreso datosIngreso;
	
	public EAdeudo() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EDatosIngreso getDatosIngreso() {
		return datosIngreso;
	}

	public void setDatosIngreso(EDatosIngreso datosIngreso) {
		this.datosIngreso = datosIngreso;
	}


	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
}
