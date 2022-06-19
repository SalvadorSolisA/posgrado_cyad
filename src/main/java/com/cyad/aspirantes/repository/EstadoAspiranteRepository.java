package com.cyad.aspirantes.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.aspirantes.entity.EEstadoAspirante;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_estados_aspirantes")
public interface EstadoAspiranteRepository extends JpaRepository<EEstadoAspirante, Serializable>{
	/**
	 * metodo para realizar una busqueda de estado por id
	 * @param numero de id
	 * @return entidad estado aspirante
	 */
	public abstract EEstadoAspirante findById(long id);
}
