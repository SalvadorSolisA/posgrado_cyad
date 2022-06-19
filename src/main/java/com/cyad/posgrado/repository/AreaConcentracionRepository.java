package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EAreaConcentracion;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_area_concentracion")
public interface AreaConcentracionRepository extends JpaRepository<EAreaConcentracion, Serializable> {
	/**
	 * metodo para realizar una busqueda de area de concentracion por id
	 * @param id
	 * @return entidad area de concentracion
	 */
	public abstract EAreaConcentracion findById(long id);

}
