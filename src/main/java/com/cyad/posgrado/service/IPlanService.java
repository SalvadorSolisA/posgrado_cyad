package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EPlan;
import com.cyad.posgrado.model.MPlan;
/**
 * Interface para realizar operaciones CRUD al repositorio de planes de estudio
 * @author Salvador Solis Atenco
 *
 */
public interface IPlanService {
	/**
	 * metodo para crear un registro de plan de estudio
	 * @param entidad plan de estudio
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EPlan plan);
	/**
	 * metodo para actualizar un registro de plan de estudio
	 * @param entidad plan de estudio
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EPlan plan);
	/**
	 * metodo para borrar un resgistro de plan de estudio
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de plan de estudio del repositorio
	 * @return lista de registros de planes de estudio
	 */
	public abstract List<MPlan> obtener();
	/**
	 * metodo para obtener un registro de plan de estudio del repositorio
	 * @return plan de estudio
	 */
	public abstract MPlan obtener(long id);
}
