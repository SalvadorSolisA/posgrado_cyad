package com.cyad.posgrado.model;

import java.util.ArrayList;
import java.util.List;

import com.cyad.posgrado.entity.EAdeudo;
import com.cyad.posgrado.entity.EDatosIngreso;
/**
 * clase que representa el objeto java de la entidad EDatosIngreso
 * @author Salvador Solis Atenco
 *
 */
public class MDatosIngreso {
	private long id;
	private String escuelaProcedencia;
	private Double promedio;
	private String nivelStudios;
	private boolean activo;
	private List<MAdeudo> adeudos;
	
	public MDatosIngreso() {
		super();
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad datos de ingreso
	 */
	public MDatosIngreso(EDatosIngreso datos) {
		super();
		this.id = datos.getId();
		this.escuelaProcedencia = datos.getEscuelaProcedencia();
		this.promedio = datos.getPromedio();
		this.nivelStudios = datos.getNivelStudios();
		this.activo = datos.isActivo();
		if(datos.getAdeudos() != null) {
			this.adeudos = new ArrayList<MAdeudo>();
			for(EAdeudo adeudo : datos.getAdeudos()) {
				this.adeudos.add(new MAdeudo(adeudo));
			}
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEscuelaProcedencia() {
		return escuelaProcedencia;
	}

	public void setEscuelaProcedencia(String escuelaProcedencia) {
		this.escuelaProcedencia = escuelaProcedencia;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public String getNivelStudios() {
		return nivelStudios;
	}

	public void setNivelStudios(String nivelStudios) {
		this.nivelStudios = nivelStudios;
	}

	public List<MAdeudo> getAdeudos() {
		return adeudos;
	}

	public void setAdeudos(List<MAdeudo> adeudos) {
		this.adeudos = adeudos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
