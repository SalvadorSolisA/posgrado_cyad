package com.cyad.datamart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.datamart.entity.EProyectoDatamart;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("data_repositorio_proyectos")
public interface IProyectoRepositoryDatamart extends JpaRepository<EProyectoDatamart, Integer>{
	/**
	 * metodo para realizar una busqueda de un proyecto por id
	 * @param numero de id
	 * @return entidad proyecto
	 */
	public abstract EProyectoDatamart findById(long id);
}
