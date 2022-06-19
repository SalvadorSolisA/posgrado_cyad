package com.cyad.datamart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.datamart.entity.ETrimestreDatamart;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("data_repositorio_trimestres")
public interface ITrimestreRepositoryDatamart extends JpaRepository<ETrimestreDatamart, Integer>{
	/**
	 * metodo para realizar una busqueda de un trimestre por id
	 * @param numero de id
	 * @return entidad trimestre
	 */
	public abstract ETrimestreDatamart findById(long id);
}
