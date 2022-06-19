package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EProfesor;
import com.cyad.posgrado.model.MProfesor;
/**
 * Interface para realizar operaciones CRUD al repositorio de profesores
 * @author Salvador Solis Atenco
 *
 */
public interface IProfesorService {
	/**
	 * metodo para crear un registro de profesor
	 * @param entidad profesor
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EProfesor profesor);
	/**
	 * metodo para actualizar un registro de profesor
	 * @param entidad profesor
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EProfesor profesor);
	/**
	 * metodo para borrar un resgistro de profesor
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de profesor del repositorio
	 * @return lista de registros de profesores
	 */
	public abstract List<MProfesor> obtener();
	/**
	 * metodo para obtener un registro de profesor del repositorio
	 * @return profesor
	 */
	public abstract MProfesor obtener(long id);
}
