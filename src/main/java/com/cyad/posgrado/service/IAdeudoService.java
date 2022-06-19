package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EAdeudo;
import com.cyad.posgrado.model.MAdeudo;
/**
 * Interface para realizar operaciones CRUD al repositorio de adeudos
 * @author Salvador Solis Atenco
 *
 */
public interface IAdeudoService {
	/**
	 * metodo para crear un registro de adeudo
	 * @param entidad adeudo
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EAdeudo adeudo);
	/**
	 * metodo para actualizar un registro de adeudo
	 * @param entidad area de adeudo
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EAdeudo adeudo);
	/**
	 * metodo para borrar un resgistro de adeudo
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de adeudos del repositorio
	 * @return lista de registros de alumnos
	 */
	public abstract List<MAdeudo> obtener();
}
