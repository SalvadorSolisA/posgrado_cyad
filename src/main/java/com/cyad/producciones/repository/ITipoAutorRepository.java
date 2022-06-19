package com.cyad.producciones.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.producciones.entity.ETipoAutor;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_tipo_autor")
public interface ITipoAutorRepository extends JpaRepository<ETipoAutor, Serializable> {
	/**
	 * metodo para realizar una busqueda de un tipo de autor por id
	 * @param id
	 * @return entidad tipo de autor
	 */
	public abstract ETipoAutor findById(long id);
}
