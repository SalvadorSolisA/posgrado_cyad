package com.cyad.datamart.service;

import java.util.List;

import com.cyad.datamart.entity.EProyectoDatamart;
import com.cyad.datamart.model.MProyectoDatamart;
/**
 * Interface para realizar operaciones CRUD al repositorio de proyectos en el datamart
 * @author Salvador Solis Atenco
 *
 */
public interface IProyectoService {
	/**
	 * metodo para crear un proyecto
	 * @param entidad proyecto
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EProyectoDatamart proyecto);
	/**
	 * metodo para actualizar un proyecto
	 * @param entidad proyecto
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar();
	/**
	 * metodo para borrar un proyecto
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener los proyectos en el repositorio
	 * @return lista de proyectos
	 */
	public abstract List<MProyectoDatamart> obtener();
}
