package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EProyecto;
import com.cyad.posgrado.model.MProyecto;
/**
 * Interface para realizar operaciones CRUD al repositorio de proyectos
 * @author Salvador Solis Atenco
 *
 */
public interface IProyectoService {
	/**
	 * metodo para crear un registro de proyecto
	 * @param entidad proyecto
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EProyecto proyecto);
	/**
	 * metodo para actualizar un registro de proyecto
	 * @param entidad proyecto
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EProyecto proyecto);
	/**
	 * metodo para borrar un resgistro de proyecto
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de proyecto del repositorio
	 * @return lista de registros de proyectos
	 */
	public abstract List<MProyecto> obtener();
	/**
	 * metodo para obtener un registro de proyecto del repositorio
	 * @return proyecto
	 */
	public abstract MProyecto obtener(long id);
}
