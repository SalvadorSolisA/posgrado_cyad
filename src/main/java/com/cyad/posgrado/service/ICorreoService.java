package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.ECorreo;
import com.cyad.posgrado.model.MCorreo;
/**
 * Interface para realizar operaciones CRUD al repositorio de correos
 * @author Salvador Solis Atenco
 *
 */
public interface ICorreoService {
	/**
	 * metodo para crear un registro de correo
	 * @param entidad correo
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(ECorreo correo);
	/**
	 * metodo para actualizar un registro de correo
	 * @param entidad correo
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(ECorreo correo);
	/**
	 * metodo para borrar un resgistro de correo
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de correo del repositorio
	 * @return lista de registros de correo
	 */
	public abstract List<MCorreo> obtener();
	/**
	 * metodo para obtener un registro de correo del repositorio
	 * @return correo
	 */
	public abstract MCorreo obtener(long id);
}
