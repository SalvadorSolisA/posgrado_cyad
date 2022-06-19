package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorNivel;
import com.cyad.posgrado.entity.ENivel;
import com.cyad.posgrado.model.MNivel;
import com.cyad.posgrado.repository.NivelRepository;
/**
 * implementacion de la interface INivelService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_nivel")
public class NivelService implements INivelService {
	
	@Autowired
	@Qualifier("repositorio_nivel")
	private NivelRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_niveles")
	private ConvertidorNivel convertidor;
	
	private static final Log logger = LogFactory.getLog(NivelService.class);

	@Override
	public boolean crear(ENivel nivel) {
		try {
			logger.info("NIVEL CREADO");
			repositorio.save(nivel);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR NIVEL");
			return false;
		}
	}

	@Override
	public boolean actualizar(ENivel nivel) {
		try {
			logger.info("NIVEL ACTUALIZADO");
			repositorio.save(nivel);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR NIVEL");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			ENivel nivel = repositorio.findById(id);
			nivel.setActivo(false);
			repositorio.save(nivel);
			logger.info("NIVEL BORRADO");
			//repositorio.delete(nivel);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR NIVEL");
			return false;
		}
	}

	@Override
	public List<MNivel> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR NIVELES");
			return null;
		}
	}

	@Override
	public MNivel obtener(long id) {
		try {
			return new MNivel(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR NIVELES");
			return null;
		}
	}
}
