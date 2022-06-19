package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EAreaInvestigacion;
import com.cyad.posgrado.model.MAreaInvestigacion;
/**
 * Interface para realizar operaciones CRUD al repositorio de areas de investigacion
 * @author Salvador Solis Atenco
 *
 */
public interface IAreaInvestigacionService {
	/**
	 * metodo para crear un registro de area de investigacion
	 * @param entidad area de investigacion
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EAreaInvestigacion area);
	/**
	 * metodo para actualizar un registro de area de investigacion
	 * @param entidad area de investigacion
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EAreaInvestigacion area);
	/**
	 * metodo para borrar un resgistro de area de investigacion
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de area de investigacion del repositorio
	 * @return lista de registros de area de investigacion
	 */
	public abstract List<MAreaInvestigacion> obtener();
	/**
	 * metodo para obtener un registro de area de investigacion del repositorio
	 * @return area de investigacion
	 */
	public abstract MAreaInvestigacion obtener(long id);
}
