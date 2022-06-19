package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorProfesor;
import com.cyad.posgrado.entity.EProfesor;
import com.cyad.posgrado.model.MProfesor;
import com.cyad.posgrado.repository.ProfesorRepository;
/**
 * implementacion de la interface IProfesorService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_profesor")
public class ProfesorService implements IProfesorService{
	@Autowired
	@Qualifier("repositorio_profesores")
	private ProfesorRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_profesor")
	private ConvertidorProfesor convertidor;
	
	private static final Log logger = LogFactory.getLog(ProfesorService.class);
	
	@Override
	public boolean crear(EProfesor profesor) {
		try {
			logger.info("PROFESOR CREADO");
			repositorio.save(profesor);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR PROFESOR " + e);
			return false;
		}
	}
	
	@Override
	public boolean actualizar(EProfesor profesor) {
		try {
			logger.info("PROFESOR ACTUALIZADO");
			repositorio.save(profesor);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR DATOS DE PROFESOR " + e);
			return false;
		}
	}
	
	@Override
	public boolean borrar(long id) {
		try {
			EProfesor prof = repositorio.findById(id);
			prof.setActivo(false);
			repositorio.save(prof);
			logger.info("PROFESOR BORRADO");
			//repositorio.delete(prof);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR PROFESOR " + e);
			return false;
		}
	}
	
	@Override
	public List<MProfesor> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR PROFESORES " + e);
			return null;
		}
	}
	
	public List<MProfesor> obtenerPorNombre(String nombre) {
		try {
			return convertidor.convertirLista(repositorio.findByNombre(nombre));
		}catch(Exception e){
			return null;
		}
	}
	

	@Override
	public MProfesor obtener(long id) {
		try {
			return new MProfesor(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR PROFESORES " + e);
			return null;
		}
	}


}
