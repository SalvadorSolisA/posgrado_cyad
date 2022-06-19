package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EEstadoAcademico;
import com.cyad.posgrado.model.MEstadoAcademico;
/**
 * Interface para realizar operaciones CRUD al repositorio de estados academicos
 * @author Salvador Solis Atenco
 *
 */
public interface IEstadoAcademicoService {
	/**
	 * metodo para crear un registro de estado academico
	 * @param entidad estado academicos
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EEstadoAcademico estado);
	/**
	 * metodo para actualizar un registro de estado academico
	 * @param entidad estado academicos
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EEstadoAcademico estado);
	/**
	 * metodo para borrar un resgistro de estado academico
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de estados academicos del repositorio
	 * @return lista de registros de insitucion de procedencia
	 */
	public abstract List<MEstadoAcademico> obtener();
	/**
	 * metodo para obtener un registro de estado academico del repositorio
	 * @return insitucion de procedencia
	 */
	public abstract MEstadoAcademico obtener(long id);
}
