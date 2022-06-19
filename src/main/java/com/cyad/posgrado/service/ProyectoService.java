package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorProyecto;
import com.cyad.posgrado.entity.EProyecto;
import com.cyad.posgrado.model.MProyecto;
import com.cyad.posgrado.repository.ProyectoRepository;
/**
 * implementacion de la interface IProyectoService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_proyecto")
public class ProyectoService implements IProyectoService{
	@Autowired
	@Qualifier("repositorio_proyectos")
	private ProyectoRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_proyectos")
	private ConvertidorProyecto convertidor;
	
	private static final Log logger = LogFactory.getLog(ProyectoService.class);
	
	
	@Override
	public boolean crear(EProyecto proyecto) {
		try {
			logger.info("PROYECTO CREADO");
			repositorio.save(proyecto);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR PROYECTO " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(EProyecto proyecto) {
		try {
			logger.info("PROYECTO ACTUALIZADO");
			repositorio.save(proyecto);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR PROYECTO " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			EProyecto proyecto = repositorio.findById(id);
			proyecto.setActivo(false);
			repositorio.save(proyecto);
			logger.info("PROYECTO BORRADO");
			//repositorio.delete(proyecto);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR PROYECTO " + e);
			return false;
		}
	}

	@Override
	public List<MProyecto> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR PROYECTOS" + e);
			return null;
		}
	}

	@Override
	public MProyecto obtener(long id) {
		try {
			return new MProyecto(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR PROYECTOS " + e);
			return null;
		}
	}

}
