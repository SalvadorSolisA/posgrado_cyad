package com.cyad.datamart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.datamart.entity.EDatosPorTrimestreDatamart;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("data_repositorio_datos")
public interface IDatosPorTrimestreRepositoryDatamart extends JpaRepository<EDatosPorTrimestreDatamart, Integer>{
	/**
	 * metodo para realizar una busqueda de los datos academicos por trimestre por su numero id
	 * @param numero de id
	 * @return entidad datos por trimestre
	 */
	public abstract EDatosPorTrimestreDatamart findById(long id);
}
