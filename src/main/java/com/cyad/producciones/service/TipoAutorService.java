package com.cyad.producciones.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.producciones.converter.ConvertidorTipoAutor;
import com.cyad.producciones.entity.ETipoAutor;
import com.cyad.producciones.model.MTipoAutor;
import com.cyad.producciones.repository.ITipoAutorRepository;
/**
 * implementacion de la interface ITipoAutorService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_tipo_autor")
public class TipoAutorService implements ITipoAutorService {

	@Autowired
	@Qualifier("repositorio_tipo_autor")
	private ITipoAutorRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_tipo_autor")
	private ConvertidorTipoAutor convertidor;
	
	private static final Log logger = LogFactory.getLog(TipoAutorService.class);
	
	@Override
	public boolean crear(ETipoAutor tipo_autor) {
		try {
			logger.info("TIPO DE AUTOR CREADO");
			repositorio.save(tipo_autor);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR TIPO DE AUTOR " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(ETipoAutor tipo_autor) {
		try {
			logger.info("TIPO DE AUTOR ACTUALIZADO");
			repositorio.save(tipo_autor);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR TIPO DE AUTOR  " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			ETipoAutor tipo_autor = repositorio.findById(id);
			logger.info("TIPO DE AUTOR BORRADO");
			tipo_autor.setActivo(false);
			repositorio.save(tipo_autor);
			//repositorio.delete(tipo_autor);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR TIPO DE AUTOR  " + e);
			return false;
		}
	}

	@Override
	public List<MTipoAutor> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR TIPO DE AUTORES  " + e);
			return null;
		}
	}

	@Override
	public MTipoAutor obtener(long id) {
		try {
			return new MTipoAutor(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR TIPO DE AUTORES  " + e);
			return null;
		}
	}

}
