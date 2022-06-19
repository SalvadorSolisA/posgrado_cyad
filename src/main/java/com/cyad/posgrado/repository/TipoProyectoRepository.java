package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.ETipoProyecto;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_tipo_proyecto")
public interface TipoProyectoRepository extends JpaRepository<ETipoProyecto,Serializable>{
	/**
	 * metodo para realizar una busqueda de un tipo de proyecto por id
	 * @param numero de id
	 * @return entidad tipo de proyecto
	 */
	public abstract ETipoProyecto findById(long id);
	/**
	 * metodo para realizar una busqueda de un tipo de proyecto por tipo
	 * @param tipo
	 * @return entidad tipo de proyecto
	 */
	public abstract ETipoProyecto findByTipo(String tipo);
}
