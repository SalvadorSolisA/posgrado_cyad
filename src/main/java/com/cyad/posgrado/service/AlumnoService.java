package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorAlumno;
import com.cyad.posgrado.entity.EAlumno;
import com.cyad.posgrado.model.MAlumno;
import com.cyad.posgrado.repository.AlumnoRepository;
/**
 * implementacion de la interface IAlumnoService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_alumno")
public class AlumnoService implements IAlumnoService{
	@Autowired
	@Qualifier("repositorio_alumnos")
	private AlumnoRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_alumnos")
	private ConvertidorAlumno convertidor;
	
	private static final Log logger = LogFactory.getLog(AlumnoService.class);
	
	@Override
	public long crear(EAlumno alumno) {
		try {
			
			repositorio.save(alumno);
			logger.info("ALUMNO CREADO");
			
			return alumno.getId();
		}catch(Exception e){
			logger.error("ERROR AL CREAR ALUMNO " + e);
			return 0;
		}
	}

	@Override
	public boolean actualizar(EAlumno alumno) {
		try {
			logger.info("ALUMNO ACTUALIZADO");
			repositorio.save(alumno);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR ALUMNO " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			logger.info("ALUMNO BORRADO");
			EAlumno alum = repositorio.findById(id);
			alum.setActivo(false);
			//repositorio.delete(alum);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR ALUMNO " + e);
			return false;
		}
	}

	@Override
	public List<MAlumno> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR ALUMNOS " + e);
			return null;
		}
	}

	@Override
	public MAlumno obtener(long id) {
		try {
			return new MAlumno(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR ALUMNOS " + e);
			return null;
		}
	}

}
