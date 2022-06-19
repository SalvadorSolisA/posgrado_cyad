package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EDatosAcademicos;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_datos_academicos")
public interface DatosAcademicosRepository extends JpaRepository<EDatosAcademicos, Serializable> {
	/**
	 * metodo para realizar una busqueda de datos de academicos por id
	 * @param id
	 * @return entidad datos academicos
	 */
	public abstract EDatosAcademicos findById(long id);

}
