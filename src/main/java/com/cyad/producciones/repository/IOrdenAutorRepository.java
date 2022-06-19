package com.cyad.producciones.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.producciones.entity.EOrdenAutor;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_orden_autor")
public interface IOrdenAutorRepository extends JpaRepository<EOrdenAutor, Serializable> {
	/**
	 * metodo para realizar una busqueda de orden de autor por id
	 * @param id
	 * @return entidad orden de autor
	 */
	public abstract EOrdenAutor findById(long id);
}
