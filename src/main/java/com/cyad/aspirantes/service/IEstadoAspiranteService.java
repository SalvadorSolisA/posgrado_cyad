package com.cyad.aspirantes.service;

import java.util.List;

import com.cyad.aspirantes.entity.EEstadoAspirante;
import com.cyad.aspirantes.model.MEstadoAspirante;
/**
 * Interface para realizar operaciones CRUD al repositorio de estados de aspirantes
 * @author Salvador Solis Atenco
 *
 */
public interface IEstadoAspiranteService {
	/**
	 * metodo para crear un estado de aspirante
	 * @param entidad aspirante
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EEstadoAspirante aspirante);
	/**
	 * metodo para actualizar un registro de estado de aspirante
	 * @param entidad aspirante
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EEstadoAspirante aspirante);
	/**
	 * metodo para borrar un registro
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener los registros en el repositorio
	 * @return lista de estados
	 */
	public abstract List<MEstadoAspirante> obtener();
	public abstract MEstadoAspirante obtener(long id);
}
