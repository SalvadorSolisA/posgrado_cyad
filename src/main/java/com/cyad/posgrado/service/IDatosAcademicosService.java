package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EDatosAcademicos;
import com.cyad.posgrado.model.MDatosAcademicos;
/**
 * Interface para realizar operaciones CRUD al repositorio de datos academicos
 * @author Salvador Solis Atenco
 *
 */
public interface IDatosAcademicosService {
	/**
	 * metodo para crear un registro de datos academicos
	 * @param entidad datos academicos
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EDatosAcademicos datos);
	/**
	 * metodo para actualizar un registro de datos academicos
	 * @param entidad datos academicos
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EDatosAcademicos datos);
	/**
	 * metodo para borrar un resgistro de datos academicos
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de datos academicos del repositorio
	 * @return lista de registros de datos academicos
	 */
	public abstract List<MDatosAcademicos> obtener();
	/**
	 * metodo para obtener un registro de datos academicos del repositorio
	 * @return datos academicos
	 */
	public abstract MDatosAcademicos obtener(long id);
}
