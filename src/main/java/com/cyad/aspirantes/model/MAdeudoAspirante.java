package com.cyad.aspirantes.model;

import com.cyad.aspirantes.entity.EAdeudoAspirante;
/**
 * clase que reprenta el modelo de adeudo de documentaciopn de un aspirante a posgrado
 * @author Salvador Solis Atenco
 *
 */
public class MAdeudoAspirante {
	private long id;
	private boolean activo;
	private String documento;
	private String tipo;
	
	public MAdeudoAspirante() {
		super();
	}

	public MAdeudoAspirante(EAdeudoAspirante adeudo) {
		super();
		this.id = adeudo.getId();
		this.activo = adeudo.isActivo();
		this.documento = adeudo.getDocumento();
		this.tipo = adeudo.getTipo();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
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
