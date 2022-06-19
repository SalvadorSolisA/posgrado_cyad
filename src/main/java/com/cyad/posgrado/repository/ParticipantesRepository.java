package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EParticipante;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_participantes")
public interface ParticipantesRepository extends JpaRepository <EParticipante,Serializable>{
	/**
	 * metodo para realizar una busqueda de alumno por id
	 * @param id
	 * @return entidad participante
	 */
	public abstract EParticipante findById(long id);
}
