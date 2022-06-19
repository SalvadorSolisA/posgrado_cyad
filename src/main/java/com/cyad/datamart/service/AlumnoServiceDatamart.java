package com.cyad.datamart.service;

import java.util.List;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.datamart.converter.ConvertidorAlumnoDatamart;
import com.cyad.datamart.entity.EAlumnoDatamart;
import com.cyad.datamart.model.MAlumnoDatamart;
import com.cyad.datamart.repository.IAlumnoRepositoryDatamart;
/**
 * implementacion de la interface IAlumnoService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("data_alumno_service")
public class AlumnoServiceDatamart implements IAlumnoService{
	
	@Autowired
	@Qualifier("data_repositorio_alumnos")
	private IAlumnoRepositoryDatamart repositorio;
	
	@Autowired
	@Qualifier("data_convertidor_alumno")
	private ConvertidorAlumnoDatamart convertidor;
	
	private static final Log logger = LogFactory.getLog(AlumnoServiceDatamart.class);

	@Override
	public boolean crear(EAlumnoDatamart alumno) {
		try {
			repositorio.save(alumno);
			logger.info("ALUMNO CREADO");
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR ALUMNO "+e);
			return false;
		}
	}

	@Override
	public boolean actualizar(EAlumnoDatamart alumno) {
		try {
			repositorio.save(alumno);
			logger.info("ALUMNO ACTUALIZADO");
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR ALUMNO "+e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			EAlumnoDatamart alumno = repositorio.findById(id);
			repositorio.delete(alumno);
			logger.info("ALUMNO BORRADO");
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR ALUMNO "+ e);
			return false;
		}
	}

	@Override
	public List<MAlumnoDatamart> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR "+e);
			return null;
		}
	}

	public MAlumnoDatamart obtener(long id) {
		try {
			EAlumnoDatamart alumno = repositorio.findById(id);
			return new MAlumnoDatamart(alumno);
		}catch(Exception e){
			logger.error("ERROR AL LISTAR "+e);
			return null;
		}
	}

}
