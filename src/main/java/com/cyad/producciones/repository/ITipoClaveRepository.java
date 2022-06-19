package com.cyad.producciones.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.producciones.entity.ETipoClave;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_tipo_clave")
public interface ITipoClaveRepository extends JpaRepository<ETipoClave, Serializable>  {
	/**
	 * metodo para realizar una busqueda de un tipo de clave por id
	 * @param id
	 * @return entidad tipo de clave
	 */
	public abstract ETipoClave findById(long id);
}
