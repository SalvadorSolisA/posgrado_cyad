package com.cyad.posgrado.service;

import java.util.List;

import com.cyad.posgrado.entity.EDepartamento;
import com.cyad.posgrado.model.MDepartamento;
/**
 * Interface para realizar operaciones CRUD al repositorio de departamentos
 * @author Salvador Solis Atenco
 *
 */
public interface IDepartamentoService {
	/**
	 * metodo para crear un registro de departamento
	 * @param entidad departamento
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EDepartamento departamento);
	/**
	 * metodo para actualizar un registro de departamento
	 * @param entidad departamento
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EDepartamento departamento);
	/**
	 * metodo para borrar un resgistro de departamento
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de departamento del repositorio
	 * @return lista de registros de departamento
	 */
	public abstract List<MDepartamento> obtener();
	/**
	 * metodo para obtener un registro de departamento del repositorio
	 * @return departamento
	 */
	public abstract MDepartamento obtener(long id);
}
