package com.cyad.producciones.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.producciones.converter.ConvertidorTipoProduccion;
import com.cyad.producciones.entity.ETipoProduccion;
import com.cyad.producciones.model.MTipoProduccion;
import com.cyad.producciones.repository.ITipoProduccionRepository;
/**
 * implementacion de la interface ITipoProduccionService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_tipo_produccion")
public class TipoProduccionService implements ITipoProduccionService {

	@Autowired
	@Qualifier("repositorio_tipo_produccion")
	private ITipoProduccionRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_tipo_produccion")
	private ConvertidorTipoProduccion convertidor;
	
	private static final Log logger = LogFactory.getLog(TipoProduccionService.class);
	
	@Override
	public boolean crear(ETipoProduccion tipo) {
		try {
			logger.info("TIPO DE PRODUCCION CREADO");
			repositorio.save(tipo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR TIPO DE PRODUCCION  " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(ETipoProduccion tipo) {
		try {
			logger.info("TIPO DE PRODUCCION ACTUALIZADO");
			repositorio.save(tipo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR TIPO DE PRODUCCION  " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			ETipoProduccion tipo = repositorio.findById(id);
			logger.info("TIPO DE PRODUCCION BORRADO");
			tipo.setActivo(false);
			repositorio.save(tipo);
			//repositorio.delete(tipo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR TIPO DE PRODUCCION " + e);
			return false;
		}
	}

	@Override
	public List<MTipoProduccion> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR TIPO DE PRODUCCION " + e);
			return null;
		}
	}

	@Override
	public MTipoProduccion obtener(long id) {
		try {
			return new MTipoProduccion(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR TIPO DE PRODUCCION " + e);
			return null;
		}
	}

}
