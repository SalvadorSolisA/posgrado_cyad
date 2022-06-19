package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorTipoProyecto;
import com.cyad.posgrado.entity.ETipoProyecto;
import com.cyad.posgrado.model.MTipoProyecto;
import com.cyad.posgrado.repository.TipoProyectoRepository;
/**
 * implementacion de la interface ITipoProyectoService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_tipo_proyecto")
public class TipoProyectoService implements ITipoProyectoService{
	
	@Autowired
	@Qualifier("repositorio_tipo_proyecto")
	private TipoProyectoRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_tipos_proyectos")
	private ConvertidorTipoProyecto convertidor;
	
	private static final Log logger = LogFactory.getLog(TipoProyectoService.class);

	@Override
	public boolean crear(ETipoProyecto tipo) {
		try {
			logger.info("TIPO DE PROYECTO CREADO");
			repositorio.save(tipo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR TIPO DE PROYECTO");
			return false;
		}
	}

	@Override
	public boolean actualizar(ETipoProyecto tipo) {
		try {
			logger.info("TIPO DE PROYECTO ACTUALIZADO");
			repositorio.save(tipo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR TIPO DE PROYECTO");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			ETipoProyecto tipo = repositorio.findById(id);
			tipo.setActivo(false);
			repositorio.save(tipo);
			logger.info("TIPO DE PROYECTO BORRADO");
			//repositorio.delete(tipo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR TIPO DE PROYECTO");
			return false;
		}
	}

	@Override
	public List<MTipoProyecto> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR TIPO DE PROYECTO");
			return null;
		}
	}

	@Override
	public MTipoProyecto obtener(long id) {
		try {
			return new MTipoProyecto(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR TIPO DE PROYECTO");
			return null;
		}
	}
}
