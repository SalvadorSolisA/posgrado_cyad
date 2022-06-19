package com.cyad.producciones.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.producciones.entity.EProduccion;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_produccion")
public interface IProduccionRepository extends JpaRepository<EProduccion, Serializable> {
	/**
	 * metodo para realizar una busqueda de una produccion por id
	 * @param id
	 * @return entidad produccion
	 */
	public abstract EProduccion findById(long id);
	
}
