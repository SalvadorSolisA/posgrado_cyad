package com.cyad.producciones.service;

import java.util.List;

import com.cyad.producciones.entity.EAutor;
import com.cyad.producciones.model.MAutor;
/**
 * Interface para realizar operaciones CRUD al repositorio de autores
 * @author Salvador Solis Atenco
 *
 */
public interface IAutorService {
	/**
	 * metodo para crear un registro de autor
	 * @param entidad autor
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EAutor autor);
	/**
	 * metodo para actualizar un registro de autor
	 * @param entidad autor
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EAutor autor);
	/**
	 * metodo para borrar un resgistro de autor
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de autor del repositorio
	 * @return lista de registros de autor
	 */
	public abstract List<MAutor> obtener();
}
