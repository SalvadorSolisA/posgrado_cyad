package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EDepartamento;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_departamentos")
public interface DepartamentoRepository extends JpaRepository<EDepartamento, Serializable>{
	/**
	 * metodo para realizar una busqueda de direccion por id
	 * @param id
	 * @return entidad departamento
	 */
	public abstract EDepartamento findById(long id);
	/**
	 * metodo para realizar una busqueda de direccion por departamento
	 * @param nombre de departamento
	 * @return entidad departamento
	 */
	public abstract EDepartamento findByDepartamento(String departamento);
}
