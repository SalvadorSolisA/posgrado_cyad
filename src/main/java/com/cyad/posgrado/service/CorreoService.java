package com.cyad.posgrado.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorCorreo;
import com.cyad.posgrado.entity.ECorreo;
import com.cyad.posgrado.model.MCorreo;
import com.cyad.posgrado.repository.CorreoRepository;
/**
 * implementacion de la interface ICorreoService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_correo")
public class CorreoService implements ICorreoService{

	@Autowired
	@Qualifier("repositorio_correos")
	private CorreoRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_correos")
	private ConvertidorCorreo convertidor;
	
	private static final Log logger = LogFactory.getLog(CorreoService.class);
	
	@Override
	public boolean crear(ECorreo correo) {
		try {
			logger.info("CORREO CREADO");
			repositorio.save(correo);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR CORREO " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(ECorreo correo) {
		try {
			logger.info("CORREO ACTUALIZADO");
			repositorio.save(correo);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR CORREO "  + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			ECorreo correo = repositorio.findById(id);
			logger.info("CORREO BORRADO");
			correo.setActivo(false);
			//repositorio.delete(correo);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR CORREO " + e);
			return false;
		}
	}

	@Override
	public List<MCorreo> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR CORREO " + e);
			return null;
		}
	}
	
	@Override
	public MCorreo obtener(long id) {
		try {
			return new MCorreo(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR CORREO " + e);
			return null;
		}
	}

	
	public List<MCorreo> obtenerByAlumno (long id) {
		try {
			return convertidor.convertirLista(findByAlumno(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR CORREO "+ e);
			return null;
		}
	}
	
	private List<ECorreo> findByAlumno(long id_alumno) {
		try {
			List<ECorreo> correos_alumno = new ArrayList<>();
			List<ECorreo> repositorio_ = repositorio.findAll();
			
			for(ECorreo correo : repositorio_) {
				if(correo.getAlumno().getId() == id_alumno)
					correos_alumno.add(correo);
			}
			
			return correos_alumno;
			
		} catch (Exception e) {
			logger.info("ERROR AL LISTAR CORREOS DE ALUMNO " + e);
			return null;
		}
	}

	public boolean borrar_coincidir(String correo, String tipo, long id) {
		try {
			ECorreo correo_ = repositorio.findByCorreoAndTipo(correo, tipo);
			if(correo_  != null)
				if(correo_.getAlumno().getId() == id)
					repositorio.delete(correo_);
			return true;
		} catch (Exception e) {
			logger.info("ERROR AL LISTAR CORREOS DE ALUMNO " + e);
			return false;
		}
	}
}
