package com.cyad.producciones.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.producciones.entity.EAutor;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_autor")
public interface IAutorRepository extends JpaRepository<EAutor, Serializable>  {
	/**
	 * metodo para realizar una busqueda de autor por id
	 * @param id
	 * @return entidad autor
	 */
	public abstract EAutor findById(long id);
}
