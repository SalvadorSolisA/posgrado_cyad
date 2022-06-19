package com.cyad.producciones.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.producciones.converter.ConvertidorAutor;
import com.cyad.producciones.entity.EAutor;
import com.cyad.producciones.model.MAutor;
import com.cyad.producciones.repository.IAutorRepository;
/**
 * implementacion de la interface IAutorService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_autor")
public class AutorService implements IAutorService {

	@Autowired
	@Qualifier("repositorio_autor")
	private IAutorRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_autor")
	private ConvertidorAutor convertidor;
	
	private static final Log logger = LogFactory.getLog(AutorService.class);
	
	@Override
	public boolean crear(EAutor autor) {
		try {
			logger.info("AUTOR CREADO");
			repositorio.save(autor);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR AUTOR " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(EAutor autor) {
		try {
			logger.info("AUTOR ACTUALIZADO");
			repositorio.save(autor);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR AUTOR " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			EAutor autor = repositorio.findById(id);
			logger.info("AUTOR BORRADO");
			autor.setActivo(false);
			repositorio.save(autor);
			//repositorio.delete(autor);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR AUTOR " + e);
			return false;
		}
	}

	@Override
	public List<MAutor> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR AUTORES " + e);
			return null;
		}
	}

	public MAutor obtener(long id) {
		try {
			EAutor autor = repositorio.findById(id);
			return new MAutor(autor);
		}catch(Exception e){
			logger.info("ERROR AL CONSULTAR AUTOR " + e);
			return null;
		}
	}

}
