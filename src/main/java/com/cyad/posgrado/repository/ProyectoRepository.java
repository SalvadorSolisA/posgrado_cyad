package com.cyad.posgrado.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EProyecto;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_proyectos")
public interface ProyectoRepository extends JpaRepository<EProyecto,Serializable> {
	/**
	 * metodo para realizar una busqueda de proyecto por id
	 * @param numero de id
	 * @return entidad proyecto
	 */
	public abstract EProyecto findById(long id);
	/**
	 * metodo para realizar una busqueda de proyecto por lgac
	 * @param lgac
	 * @return entidad proyecto
	 */
	public abstract List<EProyecto> findByLgac(String lgac);
}
