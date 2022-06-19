package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.ETipoParticipante;
import com.cyad.posgrado.model.MTipoParticipante;
/**
 * Interface para realizar operaciones CRUD al repositorio de tipos de participante
 * @author Salvador Solis Atenco
 *
 */
public interface ITipoParticipanteService {
	/**
	 * metodo para crear un registro de tipo de participante
	 * @param entidad tipo de participante
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ETipoParticipante tipo);
	/**
	 * metodo para actualizar un registro de tipo de participante
	 * @param entidad tipo de participante
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(ETipoParticipante tipo);
	/**
	 * metodo para borrar un resgistro de tipo de participante
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de tipo de participante del repositorio
	 * @return lista de registros de tipo de participante
	 */
	public abstract List<MTipoParticipante> obtener();
	/**
	 * metodo para obtener un registro de tipo de participante del repositorio
	 * @return tipo de participante
	 */
	public abstract MTipoParticipante obtener(long id);
}
