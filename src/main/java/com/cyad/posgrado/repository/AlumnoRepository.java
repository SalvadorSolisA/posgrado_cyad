package com.cyad.posgrado.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EAlumno;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_alumnos")
public interface AlumnoRepository  extends JpaRepository<EAlumno, Serializable> {
	/**
	 * metodo para realizar una busqueda de alumno por id
	 * @param id
	 * @return entidad alumno
	 */
	public abstract EAlumno findById(long id);
	
}
