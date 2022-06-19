package com.cyad.producciones.service;

import java.util.List;

import com.cyad.producciones.entity.EGrupoAutores;
import com.cyad.producciones.model.MGrupoAutores;
/**
 * Interface para realizar operaciones CRUD al repositorio de grupo de autores
 * @author Salvador Solis Atenco
 *
 */
public interface IGrupoAutoresService {
	/**
	 * metodo para actualizar un registro de grupo de autores
	 * @param entidad area de grupo de autores
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EGrupoAutores autores);
	/**
	 * metodo para actualizar un registro de grupo de autores
	 * @param entidad area de grupo de autores
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EGrupoAutores autores);
	/**
	 * metodo para borrar un resgistro de grupo de autores
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de grupo de autores del repositorio
	 * @return lista de registros de grupo de autores
	 */
	public abstract List<MGrupoAutores> obtener();
	/**
	 * metodo para obtener un registro de grupo de autores del repositorio
	 * @return grupo de autores
	 */
	public abstract MGrupoAutores obtener(long id);
}
