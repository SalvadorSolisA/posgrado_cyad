package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorAreaConcentracion;
import com.cyad.posgrado.entity.EAreaConcentracion;
import com.cyad.posgrado.model.MAreaConcentracion;
import com.cyad.posgrado.repository.AreaConcentracionRepository;
/**
 * implementacion de la interface IAreaConcentracionService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_area_concentracion")
public class AreaConcentracionService implements IAreaConcentracionService{
	@Autowired
	@Qualifier("repositorio_area_concentracion")
	private AreaConcentracionRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_area_concentracion")
	private ConvertidorAreaConcentracion convertidor;
	
	private static final Log logger = LogFactory.getLog(PlanService.class);

	@Override
	public boolean crear(EAreaConcentracion area) {
		try {
			logger.info("AREA CREADA");
			repositorio.save(area);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR AREA");
			return false;
		}
	}

	@Override
	public boolean actualizar(EAreaConcentracion area) {
		try {
			logger.info("AREA ACTUALIZADA");
			repositorio.save(area);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR AREA");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			EAreaConcentracion area = repositorio.findById(id);
			logger.info("AREA DE CONCENTRACIÓN BORRADA");
			area.setActivo(false);
			repositorio.save(area);
			//repositorio.delete(area);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR AREA");
			return false;
		}
	}

	@Override
	public List<MAreaConcentracion> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR AREAS");
			return null;
		}
	}

	@Override
	public MAreaConcentracion obtener(long id) {
		try {
			return new MAreaConcentracion(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL CONSULTAR " + e );
			return null;
		}
	}
}
