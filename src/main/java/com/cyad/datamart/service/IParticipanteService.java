package com.cyad.datamart.service;

import java.util.List;

import com.cyad.datamart.entity.EParticipanteDatamart;
import com.cyad.datamart.model.MParticipanteDatamart;
/**
 * Interface para realizar operaciones CRUD al repositorio de participantes en el datamart
 * @author Salvador Solis Atenco
 *
 */
public interface IParticipanteService {
	/**
	 * metodo para crear un participante
	 * @param entidad participante
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EParticipanteDatamart participante);
	/**
	 * metodo para actualizar un participante
	 * @param entidad proyecto
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar();
	/**
	 * metodo para borrar un participante
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los participante en el repositorio
	 * @return lista de participantes
	 */
	public abstract List<MParticipanteDatamart> obtener();
}
