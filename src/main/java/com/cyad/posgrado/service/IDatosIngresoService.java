package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EDatosIngreso;
import com.cyad.posgrado.model.MDatosIngreso;
/**
 * Interface para realizar operaciones CRUD al repositorio de datos de ingreso
 * @author Salvador Solis Atenco
 *
 */
public interface IDatosIngresoService {
	/**
	 * metodo para crear un registro de datos de ingreso
	 * @param entidad datos de ingreso
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EDatosIngreso datos);
	/**
	 * metodo para actualizar un registro de datos de ingreso
	 * @param entidad datos de ingreso
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EDatosIngreso datos);
	/**
	 * metodo para borrar un resgistro de datos de ingreso
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de datos de ingreso del repositorio
	 * @return lista de registros de datos de ingreso
	 */
	public abstract List<MDatosIngreso> obtener();
	/**
	 * metodo para obtener un registro de datos de ingreso del repositorio
	 * @return datos de ingreso
	 */
	public abstract MDatosIngreso obtener(long id);
}
