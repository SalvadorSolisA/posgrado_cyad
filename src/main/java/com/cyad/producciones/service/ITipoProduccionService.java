package com.cyad.producciones.service;

import java.util.List;

import com.cyad.producciones.entity.ETipoProduccion;
import com.cyad.producciones.model.MTipoProduccion;
/**
 * Interface para realizar operaciones CRUD al repositorio de tipos de produccion
 * @author Salvador Solis Atenco
 *
 */
public interface ITipoProduccionService {
	/**
	 * metodo para crear un registro de tipo de produccion
	 * @param entidad tipo de produccion
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ETipoProduccion tipo);
	/**
	 * metodo para actualizar un registro de tipo de produccion
	 * @param entidad area de tipo de produccion
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(ETipoProduccion tipo);
	/**
	 * metodo para borrar un resgistro de tipo de produccion
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de tipo de produccion del repositorio
	 * @return lista de registros de tipo de produccion
	 */
	public abstract List<MTipoProduccion> obtener();
	/**
	 * metodo para obtener un registro de tipo de produccion del repositorio
	 * @return tipos de produccion
	 */
	public abstract MTipoProduccion obtener(long id);
}
