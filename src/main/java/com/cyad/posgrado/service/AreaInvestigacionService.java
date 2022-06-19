package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorArea;
import com.cyad.posgrado.entity.EAreaInvestigacion;
import com.cyad.posgrado.model.MAreaInvestigacion;
import com.cyad.posgrado.repository.AreaInvestigacionRepository;
/**
 * implementacion de la interface IAreaInvestigacionService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_area_investigacion")
public class AreaInvestigacionService implements IAreaInvestigacionService{
	@Autowired
	@Qualifier("repositorio_areas")
	private AreaInvestigacionRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_areas")
	private ConvertidorArea convertidor;
	
	private static final Log logger = LogFactory.getLog(AreaInvestigacionRepository.class);
	
	@Override
	public boolean crear(EAreaInvestigacion area) {
		try {
			logger.info("AREA DE INVESTIGACION CREADA");
			repositorio.save(area);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR AREA DE INVESTIGACION");
			return false;
		}
	}

	@Override
	public boolean actualizar(EAreaInvestigacion area) {
		try {
			logger.info("ID "+area.getId());
			logger.info("AREA "+area.getArea());
			repositorio.save(area);
			logger.info("AREA DE INVESTIGACION ACTUALIZADA");
			return true;
		}catch(Exception e){
			logger.warn("ERROR AL ACTUALIZAR AREA DE INVESTIGACION");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			EAreaInvestigacion area = repositorio.findById(id);
			area.setActivo(false);
			repositorio.save(area);
			logger.info("AREA DE INVESTIGACION BORRADA");
			//repositorio.delete(area);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR AREA DE INVESTIGACION");
			return false;
		}
	}

	@Override
	public List<MAreaInvestigacion> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR AREA DE INVESTIGACION");
			return null;
		}
	}

	@Override
	public MAreaInvestigacion obtener(long id) {
		try {
			return new MAreaInvestigacion(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR AREA DE INVESTIGACION");
			return null;
		}
	}

}
