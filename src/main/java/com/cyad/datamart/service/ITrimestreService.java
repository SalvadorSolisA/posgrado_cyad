package com.cyad.datamart.service;

import java.util.List;

import com.cyad.datamart.entity.ETrimestreDatamart;
import com.cyad.datamart.model.MTrimestreDatamart;
/**
 * Interface para realizar operaciones CRUD al repositorio de trimestres
 * @author Salvador Solis Atenco
 *
 */
public interface ITrimestreService {
	/**
	 * metodo para crear un trimestre
	 * @param entidad trimestre
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ETrimestreDatamart alumno);
	/**
	 * metodo para actualizar un registro de trimestre
	 * @param entidad trimestre
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar();
	/**
	 * metodo para borrar un trimestre
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener los trimestres en el repositorio
	 * @return lista de trimestres
	 */
	public abstract List<MTrimestreDatamart> obtener();
}
