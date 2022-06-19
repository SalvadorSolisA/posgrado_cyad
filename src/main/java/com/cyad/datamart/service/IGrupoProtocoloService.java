package com.cyad.datamart.service;

import java.util.List;

import com.cyad.datamart.entity.EGrupoProtocoloDatamart;
import com.cyad.datamart.model.MGrupoProtocoloDatamart;
/**
 * Interface para realizar operaciones CRUD al repositorio de grupos de protocolo en el datamart
 * @author Salvador Solis Atenco
 *
 */
public interface IGrupoProtocoloService {
	/**
	 * metodo para crear un grupo de protocolo
	 * @param entidad grupo de protocolo
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EGrupoProtocoloDatamart grupo);
	/**
	 * metodo para actualizar un grupo de protocolo
	 * @param entidad proyecto
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar();
	/**
	 * metodo para borrar un grupo de protocolo
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los grupos de protocolo en el repositorio
	 * @return lista de grupos de protocolo
	 */
	public abstract List<MGrupoProtocoloDatamart> obtener();
}
