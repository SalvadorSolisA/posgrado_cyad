package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EGrupoProtocolo;
import com.cyad.posgrado.model.MGrupoProtocolo;
/**
 * Interface para realizar operaciones CRUD al repositorio de grupos de protocolo
 * @author Salvador Solis Atenco
 *
 */
public interface IGrupoProtocoloService {
	/**
	 * metodo para crear un registro de grupo de protocolo
	 * @param entidad grupo de protocolo
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EGrupoProtocolo grupo);
	/**
	 * metodo para crear un registro de grupo de protocolo
	 * @return boleano de registro exitoso
	 */
	public abstract MGrupoProtocolo crear();
	/**
	 * metodo para actualizar un registro de grupo de protocolo
	 * @param entidad grupo de protocolo
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EGrupoProtocolo grupo);
	/**
	 * metodo para borrar un resgistro de grupo de protocolo
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener una lista de registros de grupo de protocolo del repositorio
	 * @return lista grupo de protocolo
	 */
	public abstract List<MGrupoProtocolo> obtener();
	/**
	 * metodo para obtener un registro de grupo de protocolo del repositorio
	 * @return grupo de protocolo
	 */
	public abstract MGrupoProtocolo obtener(long id);
	/**
	 * metodo para obtener un registro de grupo de protocolo del repositorio
	 * @return grupo de protocolo
	 */
	public abstract boolean search(String clave);
	/**
	 * metodo para buscar un registro de grupo de protocolo del repositorio
	 * @return booleano de reesultado de busqueda
	 */
}
