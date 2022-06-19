package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EEstadoAcademico;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_estado_academico")
public interface EstadoAcademicoRepository extends JpaRepository<EEstadoAcademico, Serializable>{
	/**
	 * metodo para realizar una busqueda de estado academico por id
	 * @param id
	 * @return entidad estado academico
	 */
	public abstract EEstadoAcademico findById(long id);
}
