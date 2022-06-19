package com.cyad.producciones.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.producciones.converter.ConvertidorTipoClave;
import com.cyad.producciones.entity.ETipoClave;
import com.cyad.producciones.model.MTipoClave;
import com.cyad.producciones.repository.ITipoClaveRepository;
/**
 * implementacion de la interface ITipoClaveService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_tipo_clave")
public class TipoClaveService implements ITipoClaveService {
	@Autowired
	@Qualifier("repositorio_tipo_clave")
	private ITipoClaveRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_tipo_clave")
	private ConvertidorTipoClave convertidor;
	
	private static final Log logger = LogFactory.getLog(TipoClaveService.class);
	
	@Override
	public boolean crear(ETipoClave clave) {
		try {
			logger.info("TIPO DE CLAVE CREADO");
			repositorio.save(clave);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR TIPO DE CLAVE  " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(ETipoClave clave) {
		try {
			logger.info("TIPO DE CLAVE ACTUALIZADO");
			repositorio.save(clave);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR TIPO DE CLAVE  " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			ETipoClave clave = repositorio.findById(id);
			logger.info("TIPO DE CLAVE BORRADO");
			clave.setActivo(false);
			repositorio.save(clave);
			//repositorio.delete(clave);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR TIPO DE CLAVE " + e);
			return false;
		}
	}

	@Override
	public List<MTipoClave> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR TIPO DE CLAVES  " + e);
			return null;
		}
	}

	@Override
	public MTipoClave obtener(long id) {
		try {
			return new MTipoClave(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR TIPO DE CLAVES  " + e);
			return null;
		}
	}

}
