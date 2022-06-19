package com.cyad.posgrado.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EDatosIngreso;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_datos_ingreso")
public interface DatosIngresoRepository extends JpaRepository<EDatosIngreso, Serializable>  {
	/**
	 * metodo para realizar una busqueda de datos de ingreso por id
	 * @param id
	 * @return entidad datos de ingreso
	 */
	public abstract EDatosIngreso findById(long id);
}
