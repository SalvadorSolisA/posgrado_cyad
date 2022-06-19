package com.cyad.aspirantes.service;

import java.util.List;

import com.cyad.aspirantes.entity.EAdeudoAspirante;
import com.cyad.aspirantes.model.MAdeudoAspirante;
/**
 * Interface para realizar operaciones CRUD al repositorio de adeudos de aspirante
 * @author Salvador Solis Atenco
 *
 */
public interface IAdeudoAspiranteService {
	/**
	 * metodo para crear un nuevo adeudo
	 * @param entidad adeudo
	 * @return booleano de creacion exitosa
	 */
	public abstract boolean crear(EAdeudoAspirante adeudo);
	/**
	 * metodo para actualizar un adeudo
	 * @param entidad adeudo
	 * @return booleano de registro exitoso
	 */
	public abstract boolean actualizar(EAdeudoAspirante adeudo);
	/**
	 * metodo para borrar un adeudo
	 * @param id del adeudo a borrar
	 * @return booleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para consultar los adeudos en el repositorio
	 * @return lista de objetos adeudo
	 */
	public abstract List<MAdeudoAspirante> obtener();
}
