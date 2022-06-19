package com.cyad.posgrado.repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EDivision;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_divisiones")
public interface DivisionRepository extends JpaRepository<EDivision, Serializable>{
	/**
	 * metodo para realizar una busqueda de division por id
	 * @param id
	 * @return entidad division
	 */
	public abstract EDivision findById(long id);
	/**
	 * metodo para realizar una busqueda de division por id
	 * @param nombre division
	 * @return entidad division
	 */
	public abstract EDivision findByDivision(String division);
}
