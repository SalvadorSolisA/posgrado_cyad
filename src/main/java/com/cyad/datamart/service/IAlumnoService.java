package com.cyad.datamart.service;

import java.util.List;

import com.cyad.datamart.entity.EAlumnoDatamart;
import com.cyad.datamart.model.MAlumnoDatamart;
/**
 * Interface para realizar operaciones CRUD al repositorio de alumnos en el datamart
 * @author Salvador Solis Atenco
 *
 */
public interface IAlumnoService {
	/**
	 * metodo para crear un registro de alumno
	 * @param entidad alumno
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EAlumnoDatamart alumno);
	/**
	 * metodo para actualizar un registro de alumno
	 * @param entidad alumno
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EAlumnoDatamart alumno);
	/**
	 * metodo para borrar un resgistro de alumno
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de alumno trimestre en el repositorio
	 * @return lista de registros de alumnos
	 */
	public abstract List<MAlumnoDatamart> obtener();
}
