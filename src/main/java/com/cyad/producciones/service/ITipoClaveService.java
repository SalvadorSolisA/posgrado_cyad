package com.cyad.producciones.service;

import java.util.List;

import com.cyad.producciones.entity.ETipoClave;
import com.cyad.producciones.model.MTipoClave;
/**
 * Interface para realizar operaciones CRUD al repositorio de tipos de clave de autor
 * @author Salvador Solis Atenco
 *
 */
public interface ITipoClaveService {
	/**
	 * metodo para crear un registro de tipo de clave
	 * @param entidad tipo de clave
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ETipoClave clave);
	/**
	 * metodo para actualizar un registro de tipo de clave
	 * @param entidad area de tipo de clave
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(ETipoClave clave);
	/**
	 * metodo para borrar un resgistro de tipo de clave
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de tipo de clave del repositorio
	 * @return lista de registros de tipos de clave
	 */
	public abstract List<MTipoClave> obtener();
	/**
	 * metodo para obtener un registro de tipo de clave del repositorio
	 * @return tipo de clave
	 */
	public abstract MTipoClave obtener(long id);
}
