package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorDivision;
import com.cyad.posgrado.entity.EDivision;
import com.cyad.posgrado.model.MDivision;
import com.cyad.posgrado.repository.DivisionRepository;
/**
 * implementacion de la interface IDivisionService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_division")
public class DivisionService implements IDivisionService{
	@Autowired
	@Qualifier("repositorio_divisiones")
	private DivisionRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_division")
	private ConvertidorDivision convertidor;

	private static final Log logger = LogFactory.getLog(DivisionService.class);
	
	@Override
	public boolean crear(EDivision division) {
		try {
			logger.info("DIVISION CREADA");
			repositorio.save(division);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR DIVISION");
			return false;
		}
	}

	@Override
	public boolean actualizar(EDivision division) {
		try {
			logger.info("DIVISION ACTUALIZADA");
			repositorio.save(division);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR DIVISION");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			logger.info("DIVISION BORRADA");
			EDivision div = repositorio.findById(id);
			div.setActivo(false);
			repositorio.save(div);
			//repositorio.delete(div);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR DIVISION");
			return false;
		}
	}

	@Override
	public List<MDivision> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR DIVISIONES");
			return null;
		}
	}


}
