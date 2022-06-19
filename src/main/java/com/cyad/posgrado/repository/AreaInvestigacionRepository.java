package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EAreaInvestigacion;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_areas")
public interface AreaInvestigacionRepository extends JpaRepository<EAreaInvestigacion, Serializable>{
	/**
	 * metodo para realizar una busqueda de area de investigacion por id
	 * @param id
	 * @return entidad area de investigacion
	 */
	public abstract EAreaInvestigacion findById(long id);
}
