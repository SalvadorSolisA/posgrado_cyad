package com.cyad.producciones.service;

import java.util.List;

import com.cyad.producciones.entity.ETipoAutor;
import com.cyad.producciones.model.MTipoAutor;
/**
 * Interface para realizar operaciones CRUD al repositorio de tipos de autor
 * @author Salvador Solis Atenco
 *
 */
public interface ITipoAutorService {
	/**
	 * metodo para crear un registro de tipo de autor
	 * @param entidad tipo de autor
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ETipoAutor autores);
	/**
	 * metodo para actualizar un registro de tipo de autor
	 * @param entidad area de tipo de autor
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(ETipoAutor autores);
	/**
	 * metodo para borrar un resgistro de tipo de autor
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de tipo de autor del repositorio
	 * @return lista de registros de tipos de autor
	 */
	public abstract List<MTipoAutor> obtener();
	/**
	 * metodo para obtener un registro de tipo de autor del repositorio
	 * @return tipo de autor
	 */
	public abstract MTipoAutor obtener(long id);
}
