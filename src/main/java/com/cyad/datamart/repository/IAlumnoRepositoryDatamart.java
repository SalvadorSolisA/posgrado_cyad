package com.cyad.datamart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.datamart.entity.EAlumnoDatamart;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("data_repositorio_alumnos")
public interface IAlumnoRepositoryDatamart extends JpaRepository<EAlumnoDatamart, Integer> {
	/**
	 * metodo para realizar una busqueda de un alumo por id
	 * @param numero de id
	 * @return entidad alumno
	 */
	public abstract EAlumnoDatamart findById(long id);
}
