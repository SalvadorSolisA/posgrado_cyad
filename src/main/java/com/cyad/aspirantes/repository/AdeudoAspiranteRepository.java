package com.cyad.aspirantes.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.aspirantes.entity.EAdeudoAspirante;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_adeudos_aspirantes")
public interface AdeudoAspiranteRepository extends JpaRepository<EAdeudoAspirante, Serializable>{
	/**
	 * metodo para realizar una busqueda de adeudo por id
	 * @param numero de id
	 * @return entidad adeudo aspirante
	 */
	public abstract EAdeudoAspirante findById(long id);
}
