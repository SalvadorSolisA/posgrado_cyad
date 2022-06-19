package com.cyad.datamart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.datamart.entity.EParticipanteDatamart;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("data_repositorio_participantes")
public interface IParticipanteRepositoryDatamart extends JpaRepository<EParticipanteDatamart, Integer>{
	/**
	 * metodo para realizar una busqueda de un participante por id
	 * @param numero de id
	 * @return entidad participante
	 */
	public abstract EParticipanteDatamart findById(long id); 
}
