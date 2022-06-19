package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.ERol;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_rol")
public interface RolRepository extends JpaRepository <ERol , Serializable>{
	/**
	 * metodo para realizar una busqueda de rol por id
	 * @param numero de id
	 * @return entidad rol
	 */
	public abstract ERol findById(long id);
	/**
	 * metodo para realizar una busqueda de un rol por rol
	 * @param rol
	 * @return entidad rol
	 */
	public abstract ERol findByRol(String rol);
}
