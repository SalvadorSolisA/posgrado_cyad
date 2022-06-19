package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EDireccion;
import com.cyad.posgrado.model.MDireccion;
/**
 * Interface para realizar operaciones CRUD al repositorio de direcciones
 * @author Salvador Solis Atenco
 *
 */
public interface IDireccionService {
	/**
	 * metodo para crear un registro de direccion
	 * @param entidad direccion
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EDireccion direccion);
	/**
	 * metodo para actualizar un registro de direccion
	 * @param entidad direccion
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EDireccion direccion);
	/**
	 * metodo para borrar un resgistro de direccion
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de direccion del repositorio
	 * @return lista de registros de direccion
	 */
	public abstract List<MDireccion> obtener();
	/**
	 * metodo para obtener un registro de direccion del repositorio
	 * @return direccion
	 */
	public abstract MDireccion obtener(long id);
}