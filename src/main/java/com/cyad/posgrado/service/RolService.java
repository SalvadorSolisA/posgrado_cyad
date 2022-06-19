package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorRol;
import com.cyad.posgrado.entity.ERol;
import com.cyad.posgrado.model.MRol;
import com.cyad.posgrado.repository.RolRepository;
/**
 * implementacion de la interface IRolService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_rol")
public class RolService implements IRolService{
	@Autowired
	@Qualifier("repositorio_rol")
	private RolRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_rol")
	private ConvertidorRol convertidor;
	
	private static final Log logger = LogFactory.getLog(ParticipanteService.class);

	@Override
	public boolean crear(ERol rol) {
		try {
			logger.info("ROL PARTICIPANTE CREADO");
			repositorio.save(rol);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR ROL PARTICIPANTE");
			return false;
		}
	}

	@Override
	public boolean actualizar(ERol rol) {
		try {
			logger.info("ROL PARTICIPANTE ACTUALIZADO");
			repositorio.save(rol);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR ROL PARTICIPANTE");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			ERol rol = repositorio.findById(id);
			logger.info("ROL PARTICIPANTE BORRADO");
			repositorio.delete(rol);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR ROL PARTICIPANTE");
			return false;
		}
	}

	@Override
	public List<MRol> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR ROL PARTICIPANTE");
			return null;
		}
	}

	@Override
	public MRol obtener(long id) {
		try {
			return new MRol(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR ROL PARTICIPANTE");
			return null;
		}
	}

}	
