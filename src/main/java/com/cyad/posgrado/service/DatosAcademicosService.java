package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorDatosAcademicos;
import com.cyad.posgrado.entity.EDatosAcademicos;
import com.cyad.posgrado.model.MDatosAcademicos;
import com.cyad.posgrado.repository.DatosAcademicosRepository;
/**
 * implementacion de la interface IDatosAcademicosService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_datos_academicos")
public class DatosAcademicosService implements IDatosAcademicosService {
	@Autowired
	@Qualifier("repositorio_datos_academicos")
	private DatosAcademicosRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_datos_academicos")
	private ConvertidorDatosAcademicos convertidor;
	
	private static final Log logger = LogFactory.getLog(DatosAcademicosService.class);
	
	@Override
	public boolean crear(EDatosAcademicos datos) {
		try {	
			repositorio.save(datos);
			logger.info("DATOS ACADEMICOS CREADOS");
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR DATOS ACADEMICOS "+e);
			return false;
		}
	}
	

	@Override
	public boolean actualizar(EDatosAcademicos datos) {
		try {
			logger.info("DATOS ACADEMICOS ACTUALIZADOS");
			repositorio.save(datos);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR DATOS ACADEMICOS " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			EDatosAcademicos datos = repositorio.findById(id);
			logger.info("DATOS ACADEMICOS BORRADOS");
			datos.setActivo(false);
			//repositorio.delete(datos);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR DATOS ACADEMICOS  " + e);
			return false;
		}
	}

	@Override
	public List<MDatosAcademicos> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR DATOS ACADEMICOS " + e);
			return null;
		}
	}

	@Override
	public MDatosAcademicos obtener(long id) {
		try {
			return new MDatosAcademicos(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR DATOS ACADEMICOS  " + e);
			return null;
		}
	}
}
