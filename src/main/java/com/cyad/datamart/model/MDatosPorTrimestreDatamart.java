package com.cyad.datamart.model;

import com.cyad.datamart.entity.EDatosPorTrimestreDatamart;
/**
 * clase que representa el objeto java de la entidad EDatosPorTrimestreDatamart
 * @author Salvador Solis Atenco
 *
 */
public class MDatosPorTrimestreDatamart {
	private long id;
	private String estado;
	private Float promedio;
	private int creditos;
	private MTrimestreDatamart trimestre;
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad datos por trimestre
	 */
	public MDatosPorTrimestreDatamart(EDatosPorTrimestreDatamart datos) {
		super();
		this.id = datos.getId();
		this.estado = datos.getEstado();
		this.promedio = datos.getPromedio();
		this.creditos = datos.getCreditos();
		if (datos.getTrimestre() != null)
			this.trimestre = new MTrimestreDatamart(datos.getTrimestre());
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

	public MTrimestreDatamart getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(MTrimestreDatamart trimestre) {
		this.trimestre = trimestre;
	}

}
