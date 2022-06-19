package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.ETrimestre;
import com.cyad.posgrado.model.MTrimestre;
/**
 * Interface para realizar operaciones CRUD al repositorio de trimestres
 * @author Salvador Solis Atenco
 *
 */
public interface ITrimestreService {
	/**
	 * metodo para crear un registro de trimestre
	 * @param entidad trimestre
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ETrimestre trimestre);
	/**
	 * metodo para actualizar un registro de trimestre
	 * @param entidad trimestre
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(ETrimestre trimestre);
	/**
	 * metodo para borrar un resgistro de trimestre
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de trimestre en el repositorio
	 * @return lista de registros de trimestres
	 */
	public abstract List<MTrimestre> obtener();
	/**
	 * metodo para obtener un registro de trimestre en el repositorio
	 * @return trimestre
	 */
	public abstract MTrimestre obtener(long id);
}
