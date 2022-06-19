package com.cyad.producciones.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cyad.producciones.entity.EProduccion;
import com.cyad.producciones.model.MProduccion;
/**
 * Interface para realizar operaciones CRUD al repositorio de producciones
 * @author Salvador Solis Atenco
 *
 */
public interface IProduccionService {
	/**
	 * metodo para crear un registro de produccion
	 * @param entidad produccion
	 * @return boleano de registro exitoso
	 */
	public abstract MProduccion crear(EProduccion produccion);
	/**
	 * metodo para cargar un documento a la base de datos
	 * @param id
	 * @param file
	 * @return id del documento cargado
	 */
	public abstract long cargarDocumento(long id, MultipartFile file);
	/**
	 * metodo para descargar un documento en registrado en la base de datos
	 * @param id
	 * @return boolean de descarga exitosa
	 */
	public abstract boolean descargar(long id);
	/**
	 * metodo para actualizar un registro de produccion
	 * @param entidad area de produccion
	 * @return boleano de registro exitoso
	 */
	public abstract boolean actualizar(EProduccion produccion);
	/**
	 * metodo para borrar un resgistro de produccion
	 * @param id del registro a borrar
	 * @return boleano de borrado exitoso
	 */
	public abstract boolean borrar(long id);
	/**
	 * metodo para obtener todos los registros de produccion del repositorio
	 * @return lista de registros de produccion
	 */
	public abstract List<MProduccion> obtener();
	/**
	 * metodo para obtener un registro de produccion del repositorio
	 * @return produccion
	 */
	public abstract MProduccion obtener(long id);
}
