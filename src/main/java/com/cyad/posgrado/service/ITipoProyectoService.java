package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.ETipoProyecto;
import com.cyad.posgrado.model.MTipoProyecto;
/**
 * Interface para realizar operaciones CRUD al repositorio de tipos de proyecto
 * @author Salvador Solis Atenco
 *
 */
public interface ITipoProyectoService {
	/**
	 * metodo para crear un registro de tipo de proyecto
	 * @param entidad tipo de proyecto
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ETipoProyecto tipo);
	/**
	 * metodo para actualizar un registro de tipo de proyecto
	 * @param entidad tipo de proyecto
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(ETipoProyecto tipo);
	/**
	 * metodo para borrar un resgistro de tipo de proyecto
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de tipo de proyecto del repositorio
	 * @return lista de registros de tipo de proyecto
	 */
	public abstract List<MTipoProyecto> obtener();
	/**
	 * metodo para obtener un registro de tipo de proyecto del repositorio
	 * @return tipo de proyecto
	 */
	public abstract MTipoProyecto obtener(long id);
}
