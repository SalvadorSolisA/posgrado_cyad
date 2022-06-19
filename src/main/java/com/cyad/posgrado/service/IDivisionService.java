package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EDivision;
import com.cyad.posgrado.model.MDivision;
/**
 * Interface para realizar operaciones CRUD al repositorio de divisiones academicas
 * @author Salvador Solis Atenco
 *
 */
public interface IDivisionService {
	/**
	 * metodo para crear un registro de division
	 * @param entidad division
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EDivision division);
	/**
	 * metodo para actualizar un registro de division
	 * @param entidad division
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EDivision division);
	/**
	 * metodo para borrar un resgistro de division
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de divisiones del repositorio
	 * @return lista de registros de division
	 */
	public abstract List<MDivision> obtener();
}
