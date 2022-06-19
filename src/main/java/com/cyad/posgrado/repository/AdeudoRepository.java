package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EAdeudo;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_adeudos")
public interface AdeudoRepository extends JpaRepository<EAdeudo, Serializable> {
	/**
	 * metodo para realizar una busqueda de adeudo por id
	 * @param id
	 * @return entidad adeudo
	 */
	public abstract EAdeudo findById(long id);
}
