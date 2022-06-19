package com.cyad.datamart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.datamart.entity.ETrayectoriaDatamart;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("data_repositorio_trayectorias")
public interface ITrayectoriaRepositoryDatamart extends JpaRepository<ETrayectoriaDatamart, Integer>{
	/**
	 * metodo para realizar una busqueda de una trayectoria por id
	 * @param numero de id
	 * @return entidad trayectoria
	 */
	public abstract ETrayectoriaDatamart findById(long id);
}
