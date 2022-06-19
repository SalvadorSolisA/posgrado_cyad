package com.cyad.producciones.service;

import java.util.List;

import com.cyad.producciones.entity.EOrdenAutor;
import com.cyad.producciones.model.MOrdenAutor;
/**
 * Interface para realizar operaciones CRUD al repositorio de orden de autor
 * @author Salvador Solis Atenco
 *
 */
public interface IOrdenAutorService {
	/**
	 * metodo para crear un registro de orden de autor
	 * @param entidad orden de autor
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EOrdenAutor orden);
	/**
	 * metodo para actualizar un registro de orden de autor
	 * @param entidad orden de autor
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EOrdenAutor orden);
	/**
	 * metodo para borrar un resgistro de orden de autor
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de orden de autor del repositorio
	 * @return lista de registros de orden de autor
	 */
	public abstract List<MOrdenAutor> obtener();
	/**
	 * metodo para obtener un registro de orden de autor del repositorio
	 * @return orden de autor
	 */
	public abstract MOrdenAutor obtener(long id);
}
