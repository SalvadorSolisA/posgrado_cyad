package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorPlan;
import com.cyad.posgrado.entity.EPlan;
import com.cyad.posgrado.model.MPlan;
import com.cyad.posgrado.repository.PlanRepository;
/**
 * implementacion de la interface IPlanService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_plan")
public class PlanService implements IPlanService{
	
	@Autowired
	@Qualifier("repositorio_plan")
	private PlanRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_planes")
	private ConvertidorPlan convertidor;
	
	private static final Log logger = LogFactory.getLog(PlanService.class);

	@Override
	public boolean crear(EPlan plan) {
		try {
			logger.info("PLAN CREADO");
			repositorio.save(plan);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR PLAN " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(EPlan plan) {
		try {
			logger.info("PLAN ACTUALIZADO");
			repositorio.save(plan);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR PLAN " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			EPlan plan = repositorio.findById(id);
			plan.setActivo(false);
			repositorio.save(plan);
			logger.info("PLAN DE ESTUDIOS BORRADO");
			//repositorio.delete(plan);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR PLAN DE ESTUDIOS "+ e);
			return false;
		}
	}

	@Override
	public List<MPlan> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR PLANES" + e);
			return null;
		}
	}

	@Override
	public MPlan obtener(long id) {
		try {
			return new MPlan(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR PLANES" + e);
			return null;
		}
	}

}
