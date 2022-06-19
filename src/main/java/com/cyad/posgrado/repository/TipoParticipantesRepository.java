package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.ETipoParticipante;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_tipo_participante")
public interface TipoParticipantesRepository extends JpaRepository <ETipoParticipante , Serializable> {
	/**
	 * metodo para realizar una busqueda de tipo de participante por id
	 * @param numero de id
	 * @return entidad tipo de participante
	 */
	public abstract ETipoParticipante findById(long id);
	/**
	 * metodo para realizar una busqueda de un tipo de participante por tipo
	 * @param tipo
	 * @return entidad tipo de participante
	 */
	public abstract ETipoParticipante findByTipo(String tipo);
}
