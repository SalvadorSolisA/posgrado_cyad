package com.cyad.aspirantes.service;

import java.util.List;

import com.cyad.aspirantes.entity.EAspirante;
import com.cyad.aspirantes.model.MAspirante;
/**
 * Interface para realizar operaciones CRUD al repositorio de aspirantes
 * @author Salvador Solis Atenco
 *
 */
public interface IAspiranteService {
	/**
	 * metodo para crear un registro de aspirante
	 * @param entidad del nuevo aspirante
	 * @return booleano de registro exitoso
	 */
	public abstract boolean crear(EAspirante aspirante);
	/**
	 * metodo para actualizar un registro de aspirante
	 * @param aspirante del aspirante a actualizar
	 * @return booleano de actualizacion exitosa
	 */
	public abstract boolean actualizar(EAspirante aspirante);	
	/**
	 * metodo para borrar un registro de aspirante
	 * @param id del registro a borrar
	 * @return booleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener los registros alojados en el repositorio
	 * @return lista de entidades aspirante
	 */
	public abstract List<MAspirante> obtener();
	/**
	 * metodo para consultar un registro de aspirante
	 * @param id del aspirante
	 * @return entidad aspirante
	 */
	public abstract MAspirante obtener(long id);
}
