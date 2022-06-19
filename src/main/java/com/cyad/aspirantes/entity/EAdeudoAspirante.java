package com.cyad.aspirantes.entity;

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
 * Esta clase representa los adeudos de documentacion que puede presentar un aspirante al posgrado
 * @author VANDERWONSEN
 *
 */
@Table(name="ADEUDO_ASPIRANTE")
@Entity
public class EAdeudoAspirante implements Serializable  {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@Column(name="DOCUMENTO")
	private String documento;
	
	@Column(name="TIPO")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="ID_ASPIRANTE")
	private EAspirante aspirante;
	

	public EAdeudoAspirante() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EAspirante getAspirante() {
		return aspirante;
	}

	public void setAspirante(EAspirante aspirante) {
		this.aspirante = aspirante;
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
