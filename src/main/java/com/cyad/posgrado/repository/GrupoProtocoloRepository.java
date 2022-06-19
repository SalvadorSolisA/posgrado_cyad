package com.cyad.posgrado.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyad.posgrado.entity.EGrupoProtocolo;
/**
 * clase que hace uso de JpaRepository para realizar las operaciones CRUD a la base de datos
 * @author Salvador Solis Atenco
 *
 */
@Repository("repositorio_grupo_protocolo")
public interface GrupoProtocoloRepository extends JpaRepository<EGrupoProtocolo,Serializable>{
	/**
	 * metodo para realizar una busqueda de grupo de protocolo por id
	 * @param id
	 * @return entidad grupo de protocolo
	 */
	public abstract EGrupoProtocolo findById(long id);
	/**
	 * metodo para realizar una busqueda de grupo de protocolo por clave
	 * @param id
	 * @return entidad grupo de protocolo
	 */
	public abstract EGrupoProtocolo findByClave(String clave);
}
