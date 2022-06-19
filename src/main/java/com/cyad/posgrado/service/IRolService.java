package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.ERol;
import com.cyad.posgrado.model.MRol;
/**
 * Interface para realizar operaciones CRUD al repositorio de roles
 * @author Salvador Solis Atenco
 *
 */
public interface IRolService {
	/**
	 * metodo para crear un registro de rol
	 * @param entidad rol
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ERol rol);
	/**
	 * metodo para actualizar un registro de rol
	 * @param entidad rol
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(ERol rol);
	/**
	 * metodo para borrar un resgistro de rol
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de rol del repositorio
	 * @return lista de registros de roles
	 */
	public abstract List<MRol> obtener();
	/**
	 * metodo para obtener un registro de rol del repositorio
	 * @return rol
	 */
	public abstract MRol obtener(long id);
}
