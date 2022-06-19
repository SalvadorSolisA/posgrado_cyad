package com.cyad.datamart.service;

import java.util.List;

import com.cyad.datamart.entity.ETrayectoriaDatamart;
import com.cyad.datamart.model.MTrayectoriaDatamart;
/**
 * Interface para realizar operaciones CRUD al repositorio de trayectorias academicas
 * @author Salvador Solis Atenco
 *
 */
public interface ITrayectoriaService {
	/**
	 * metodo para crear una trayectoria
	 * @param entidad trayectoria
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ETrayectoriaDatamart trayectoria);
	/**
	 * metodo para actualizar una trayectoria
	 * @param entidad trayectoria
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar();
	/**
	 * metodo para borrar una trayectoria
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener las trayectorias en el repositorio
	 * @return lista de trayectirias
	 */
	public abstract List<MTrayectoriaDatamart> obtener();
}
