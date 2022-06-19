package com.cyad.posgrado.model;

import com.cyad.posgrado.entity.EAdeudo;
/**
 * clase que representa el objeto java de la entidad EAdeudo
 * @author Salvador Solis Atenco
 *
 */
public class MAdeudo {
	private long id;
	private String documento;
	private String tipo;
	private boolean activo;
	//private MDatosIngreso datosIngreso;
	
	public MAdeudo() {
		super();
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad adeudo
	 */
	public MAdeudo(EAdeudo adeudo) {
		super();
		this.id = adeudo.getId();
		this.documento = adeudo.getDocumento();
		this.tipo = adeudo.getTipo();
		this.activo = adeudo.isActivo();
		//this.datosIngreso = (List<MDatosIngreso>) adeudo.getDatosIngreso();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public MDatosIngreso getDatosIngreso() {
		return datosIngreso;
	}

	public void setDatosIngreso(MDatosIngreso datosIngreso) {
		this.datosIngreso = datosIngreso;
	}*/

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
