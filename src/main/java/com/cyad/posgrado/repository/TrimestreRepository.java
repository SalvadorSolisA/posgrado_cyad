package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.ETrimestre;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_trimestres")
public interface TrimestreRepository extends JpaRepository<ETrimestre ,Serializable>{
	/**
	 * metodo para realizar una busqueda de un alumo por id
	 * @param numero de id
	 * @return entidad trimestre
	 */
	public abstract ETrimestre findById(long id);
}
