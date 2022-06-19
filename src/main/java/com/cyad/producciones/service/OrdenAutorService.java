package com.cyad.producciones.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.producciones.converter.ConvertidorOrdenAutor;
import com.cyad.producciones.entity.EOrdenAutor;
import com.cyad.producciones.model.MOrdenAutor;
import com.cyad.producciones.repository.IOrdenAutorRepository;
/**
 * implementacion de la interface IOrdenAutorService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_orden_autor")
public class OrdenAutorService implements IOrdenAutorService {
	
	@Autowired
	@Qualifier("repositorio_orden_autor")
	private IOrdenAutorRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_orden_autor")
	private ConvertidorOrdenAutor convertidor;
	
	private static final Log logger = LogFactory.getLog(OrdenAutorService.class);
	
	@Override
	public boolean crear(EOrdenAutor orden) {
		try {
			logger.info("ORDEN DE AUTOR CREADO");
			repositorio.save(orden);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR ORDEN DE AUTOR " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(EOrdenAutor orden) {
		try {
			logger.info("ORDEN DE AUTOR ACTUALIZADO");
			repositorio.save(orden);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR ORDEN DE AUTOR  " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			EOrdenAutor orden = repositorio.findById(id);
			logger.info("ORDEN DE AUTOR BORRADO");
			orden.setActivo(false);
			repositorio.save(orden);
			//repositorio.delete(orden);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR ORDEN DE AUTOR " + e);
			return false;
		}
	}

	@Override
	public List<MOrdenAutor> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR ORDEN DE AUTOR " + e);
			return null;
		}
	}

	@Override
	public MOrdenAutor obtener(long id) {
		try {
			return new MOrdenAutor(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR ORDEN DE AUTOR " + e);
			return null;
		}
	}

}
