package com.cyad.producciones.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.producciones.entity.EGrupoAutores;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_grupo_autores")
public interface IGrupoAutoresRepository extends JpaRepository<EGrupoAutores, Serializable> {
	/**
	 * metodo para realizar una busqueda de grupo de autores por id
	 * @param id
	 * @return entidad grupo de autores
	 */
	public abstract EGrupoAutores findById(long id);
}
