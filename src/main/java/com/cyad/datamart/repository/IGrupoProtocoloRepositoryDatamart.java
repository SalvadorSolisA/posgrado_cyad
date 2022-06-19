package com.cyad.datamart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.datamart.entity.EGrupoProtocoloDatamart;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("data_repositorio_grupo_protocolo")
public interface IGrupoProtocoloRepositoryDatamart extends JpaRepository<EGrupoProtocoloDatamart, Integer>{
	/**
	 * metodo para realizar una busqueda de un grupo de protocolo por id
	 * @param numero de id
	 * @return entidad grupo de protocolo
	 */
	public abstract EGrupoProtocoloDatamart findById(long id); 
}
