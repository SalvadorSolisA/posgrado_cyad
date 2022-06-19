package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.ENivel;
import com.cyad.posgrado.model.MNivel;
/**
 * Interface para realizar operaciones CRUD al repositorio de nivel de estudios
 * @author Salvador Solis Atenco
 *
 */
public interface INivelService {
	/**
	 * metodo para crear un registro de nivel de estudios
	 * @param entidad nivel de estudios
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ENivel nivel);
	/**
	 * metodo para actualizar un registro de nivel de estudios
	 * @param entidad nivel de estudios
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(ENivel nivel);
	/**
	 * metodo para borrar un resgistro de nivel de estudios
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de nivel de estudios del repositorio
	 * @return lista de registros de nivel de estudios
	 */
	public abstract List<MNivel> obtener();
	/**
	 * metodo para obtener un registro de nivel de estudios del repositorio
	 * @return nivel de estudios
	 */
	public abstract MNivel obtener(long id);
}
