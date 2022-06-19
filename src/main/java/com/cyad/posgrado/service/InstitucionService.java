package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorInstituciones;
import com.cyad.posgrado.entity.EInstitucion;
import com.cyad.posgrado.model.MInstitucion;
import com.cyad.posgrado.repository.InstitucionRepository;
/**
 * implementacion de la interface IInstitucionService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_institucion")
public class InstitucionService implements IInstitucionService {
	
	@Autowired
	@Qualifier("repositorio_instituciones")
	private InstitucionRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_instituciones")
	private ConvertidorInstituciones convertidor;

	private static final Log logger = LogFactory.getLog(InstitucionService.class);
	
	@Override
	public boolean crear(EInstitucion institucion) {
		try {
			repositorio.save(institucion);
			logger.info("INSTITUCIÓN CREADA");
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR INSTITUCIÓN");
			return false;
		}
	}

	@Override
	public boolean actualizar(EInstitucion institucion) {
		try {
			repositorio.save(institucion);
			logger.info("INSTITUCIÓN ACTUALIZADA");
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR INSTITUCIÓN");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			EInstitucion inst = repositorio.findById(id);
			inst.setActivo(false);
			repositorio.save(inst);
			logger.info("INSTITUCIÓN BORRADA");
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR INSTITUCIÓN");
			return false;
		}
	}

	@Override
	public List<MInstitucion> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR INSTITUCIÓN");
			return null;
		}
	}

	@Override
	public MInstitucion obtener(long id) {
		try {
			return new MInstitucion(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR INSTITUCIÓN");
			return null;
		}
	}

}
