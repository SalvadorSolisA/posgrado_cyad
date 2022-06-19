package com.cyad.datamart.service;

import java.util.List;

import com.cyad.datamart.entity.EDatosPorTrimestreDatamart;
import com.cyad.datamart.model.MDatosPorTrimestreDatamart;
/**
 * Interface para realizar operaciones CRUD al repositorio de datos por trimestre en el datamart
 * @author Salvador Solis Atenco
 *
 */
public interface IDatosPorTrimestreService {
	/**
	 * metodo para crear un registro de datos por trimestre
	 * @param entidad datos por trimestre
	 * @return boleano de registro exitoso
	 */
	public abstract boolean crear(EDatosPorTrimestreDatamart datos);
	/**
	 * metodo para actualizar un registro de datos por trimestre
	 * @param entidad datos por trimestre
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar();
	/**
	 * metodo para borrar un resgistro de datos por trimestre
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de datos por trimestre en el repositorio
	 * @return lista de registros datos por trimestre
	 */
	public abstract List<MDatosPorTrimestreDatamart> obtener();
}
