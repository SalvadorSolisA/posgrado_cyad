package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EAlumno;
import com.cyad.posgrado.model.MAlumno;
/**
 * Interface para realizar operaciones CRUD al repositorio de alumnos
 * @author Salvador Solis Atenco
 *
 */
public interface IAlumnoService {
	/**
	 * metodo para crear un registro de alumno
	 * @param entidad alumno
	 * @return boleano de registro exitoso
	 */
	public abstract long crear(EAlumno alumno);
	/**
	 * metodo para actualizar un registro de alumno
	 * @param entidad area de alumno
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EAlumno alumno);
	/**
	 * metodo para borrar un resgistro de alumno
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de alumno del repositorio
	 * @return lista de registros de alumnos
	 */
	public abstract List<MAlumno> obtener();
	/**
	 * metodo para obtener un registro de alumno del repositorio
	 * @return alumno
	 */
	public abstract MAlumno obtener(long id);
}
