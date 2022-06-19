package com.cyad.producciones.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.producciones.entity.ETipoProduccion;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_tipo_produccion")
public interface ITipoProduccionRepository extends JpaRepository<ETipoProduccion, Serializable> {
	/**
	 * metodo para realizar una busqueda de tipo de produccion por id
	 * @param id
	 * @return entidad tipo de produccion
	 */
	public abstract ETipoProduccion findById(long id);
}
