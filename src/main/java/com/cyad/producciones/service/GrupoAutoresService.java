package com.cyad.producciones.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.producciones.converter.ConvertidorGrupoAutores;
import com.cyad.producciones.entity.EGrupoAutores;
import com.cyad.producciones.model.MGrupoAutores;
import com.cyad.producciones.repository.IGrupoAutoresRepository;
/**
 * implementacion de la interface IGrupoAutoresService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_grupo_autores")
public class GrupoAutoresService implements IGrupoAutoresService {

	@Autowired
	@Qualifier("repositorio_grupo_autores")
	private IGrupoAutoresRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_grupo_autores")
	private ConvertidorGrupoAutores convertidor;
	
	private static final Log logger = LogFactory.getLog(GrupoAutoresService.class);
	
	@Override
	public boolean crear(EGrupoAutores autores) {
		try {
			logger.info("GRUPO DE AUTORES CREADO");
			repositorio.save(autores);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR GRUPO DE AUTORES " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(EGrupoAutores autores) {
		try {
			logger.info("GRUPO DE AUTORES ACTUALIZADO");
			repositorio.save(autores);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR GRUPO DE AUTORES " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			EGrupoAutores autores = repositorio.findById(id);
			repositorio.delete(autores);
			logger.info("GRUPO DE AUTORES BORRADO");
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR GRUPO DE AUTORES " + e);
			return false;
		}
	}

	@Override
	public List<MGrupoAutores> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR GRUPO DE AUTORES " + e);
			return null;
		}
	}

	@Override
	public MGrupoAutores obtener(long id) {
		try {
			return new MGrupoAutores(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR GRUPO DE AUTORES " + e);
			return null;
		}
	}

}
