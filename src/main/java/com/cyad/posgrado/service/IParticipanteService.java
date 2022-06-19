package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EParticipante;
import com.cyad.posgrado.model.MParticipante;
/**
 * Interface para realizar operaciones CRUD al repositorio de participantes
 * @author Salvador Solis Atenco
 *
 */
public interface IParticipanteService {
	/**
	 * metodo para crear un registro de participante
	 * @param entidad participante
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EParticipante participante);
	/**
	 * metodo para actualizar un registro de participante
	 * @param entidad participante
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EParticipante participante);
	/**
	 * metodo para borrar un resgistro de participante
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de participante del repositorio
	 * @return lista de registros de participante
	 */
	public abstract List<MParticipante> obtener();
	/**
	 * metodo para obtener un registro de participante del repositorio
	 * @return participante
	 */
	public abstract MParticipante obtener(long id);
}
