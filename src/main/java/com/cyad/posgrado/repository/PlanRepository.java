package com.cyad.posgrado.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EPlan;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_plan")
public interface PlanRepository extends JpaRepository<EPlan, Serializable> {
	/**
	 * metodo para realizar una busqueda de plan de estudios por id
	 * @param numero de id
	 * @return entidad plan
	 */
	public abstract EPlan findById(long id);
	/**
	 * metodo para realizar una busqueda de plan de estudios por division
	 * @param division
	 * @return entidad plan
	 */
	public abstract List<EPlan> findByDivision(String division);
}
