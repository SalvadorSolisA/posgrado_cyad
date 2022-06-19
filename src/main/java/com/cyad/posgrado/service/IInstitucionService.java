package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EInstitucion;
import com.cyad.posgrado.model.MInstitucion;
/**
 * Interface para realizar operaciones CRUD al repositorio de insituciones de procedencia
 * @author Salvador Solis Atenco
 *
 */
public interface IInstitucionService {
	/**
	 * metodo para crear un registro de insitucion de procedencia
	 * @param entidad insitucion de procedencia
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EInstitucion institucion);
	/**
	 * metodo para actualizar un registro de insitucion de procedencia
	 * @param entidad insitucion de procedencia
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EInstitucion institucion);
	/**
	 * metodo para borrar un resgistro de insitucion de procedencia
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de insitucion de procedencia del repositorio
	 * @return lista de registros de insitucion de procedencia
	 */
	public abstract List<MInstitucion> obtener();
	/**
	 * metodo para obtener un registro de insitucion de procedencia del repositorio
	 * @return insitucion de procedencia
	 */
	public abstract MInstitucion obtener(long id);
}
