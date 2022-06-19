package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorTrimestre;
import com.cyad.posgrado.entity.ETrimestre;
import com.cyad.posgrado.model.MTrimestre;
import com.cyad.posgrado.repository.TrimestreRepository;
/**
 * implementacion de la interface ITrimestreService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_trimestres")
public class TrimestreService implements ITrimestreService {

	@Autowired
	@Qualifier("repositorio_trimestres")
	private TrimestreRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_trimestres")
	private ConvertidorTrimestre convertidor;
	
	private static final Log logger = LogFactory.getLog(TrimestreService.class);
	
	@Override
	public boolean crear(ETrimestre trimestre) {
		try {
			repositorio.save(trimestre);
			logger.info("TRIMESTRE CREADO");
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR TRIMESTRE " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(ETrimestre trimestre) {
		try {
			logger.info("TRIMESTRE ACTUALIZADO");
			repositorio.save(trimestre);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR TRIMESTRE " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			ETrimestre trimestre = repositorio.findById(id);
			logger.info("TRIMESTRE DE ESTUDIOS BORRADO");
			repositorio.delete(trimestre);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR TRIMESTRE "+ e);
			return false;
		}
	}

	@Override
	public List<MTrimestre> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR TRIMESTRES" + e);
			return null;
		}
	}

	@Override
	public MTrimestre obtener(long id) {
		try {
			return new MTrimestre(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR TRIMESTRES" + e);
			return null;
		}
	}

}
