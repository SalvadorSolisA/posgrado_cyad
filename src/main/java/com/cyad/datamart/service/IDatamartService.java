package com.cyad.datamart.service;

import java.util.List;

import com.cyad.datamart.model.MAlumnoDatamart;
/**
 * Interface para realizar operaciones CRUD al datamart
 * @author Salvador Solis Atenco
 *
 */
public interface IDatamartService {
	/**
	 * metodo para generar el hisotrial academico
	 * @return boleano de generacion exitosa
	 */
	public abstract boolean generarHistorial();
	/**
	 * metodo para obtener el historial academico de un alumno
	 * @param id del alumno
	 * @return historial del alumno
	 */
	public abstract MAlumnoDatamart obtenerHistorialAlumno(long id);
	/**
	 * metodo para obtener todos los historiales academicos en el repositorio
	 * @return lista de historiales academicos
	 */
	public abstract List<MAlumnoDatamart> obtenerHistoriales();
	/**
	 * metodo para obtener una lista de hisotriales academicos
	 * @return lista de historiales academicos
	 */
	public abstract List<MAlumnoDatamart> obtenerHistorialesAlumnos(List<Integer> ids);
}
