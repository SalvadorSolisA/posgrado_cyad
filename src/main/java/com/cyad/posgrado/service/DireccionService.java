package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorDireccion;
import com.cyad.posgrado.entity.EAlumno;
import com.cyad.posgrado.entity.EDireccion;
import com.cyad.posgrado.model.MDireccion;
import com.cyad.posgrado.repository.DireccionRepository;
/**
 * implementacion de la interface IDireccionService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_direccion")
public class DireccionService implements IDireccionService{
	@Autowired
	@Qualifier("repositorio_direcciones")
	private DireccionRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_direcciones")
	private ConvertidorDireccion convertidor;
	
	private static final Log logger = LogFactory.getLog(DireccionService.class);
	
	@Override
	public boolean crear(EDireccion direccion) {
		try {
			logger.info("DIRECCION CREADA");
			repositorio.save(direccion);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR DIRECCION");
			return false;
		}
	}

	@Override
	public boolean actualizar(EDireccion direccion) {
		try {
			logger.info("DIRECCION ACTUALIZADA");
			repositorio.save(direccion);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR DIRECCION");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			logger.info("DIRECCION BORRADA");
			EDireccion direc = repositorio.findById(id);
			direc.setActivo(false);
			//repositorio.delete(direc);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR DIRECCION");
			return false;
		}
	}

	@Override
	public List<MDireccion> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR DIRECCIONES");
			return null;
		}
	}

	@Override
	public MDireccion obtener(long id) {
		try {
			return new MDireccion(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR DIRECCIONES");
			return null;
		}
	}

	public MDireccion obtenerDireccionAlumno(long id) {
		try {
			EAlumno alumno = new EAlumno();
			alumno.setId(id);
			return new MDireccion(repositorio.findByAlumno(alumno));
		}catch(Exception e){
			logger.error("ERROR BUSCAR DIRECCIÓN DE ALUMNO"+e);
			return null;
		}
	}

	public boolean borrar_coincidir(String calle, int numero, long id) {
		try {
			EDireccion direccion_ = repositorio.findByCalleAndNumero(calle, numero);
			if(direccion_ != null)
				if(direccion_.getAlumno().getId() == id)
					repositorio.delete(direccion_);
			return true;
		}catch(Exception e){
			logger.error("ERROR BORRAR DIRECCIÓN DE ALUMNO"+e);
			return false;
		}
	}

}
