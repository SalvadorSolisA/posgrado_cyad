package com.cyad.aspirantes.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.aspirantes.entity.EAspirante;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_aspirantes")
public interface AspiranteRepository extends JpaRepository<EAspirante, Serializable>{
	/**
	 * metodo para realizar una busqueda de aspirante por su id
	 * @param numero de id
	 * @return entidad aspirante
	 */
	public abstract EAspirante findById(long id);
}
