package com.cyad.aspirantes.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.aspirantes.converter.ConvertidorEstadoAspirante;
import com.cyad.aspirantes.entity.EEstadoAspirante;
import com.cyad.aspirantes.model.MEstadoAspirante;
import com.cyad.aspirantes.repository.EstadoAspiranteRepository;
/**
 * esta clase implementa la interfaz IEstadoAspiranteService para crear el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_estado_aspirante")
public class EstadoAspiranteService implements IEstadoAspiranteService{
	@Autowired
	@Qualifier("repositorio_estados_aspirantes")
	private EstadoAspiranteRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_estado_aspirante")
	private ConvertidorEstadoAspirante convertidor;

	private static final Log logger = LogFactory.getLog(EstadoAspiranteService.class);

	@Override
	public boolean crear(EEstadoAspirante aspirante) {
		try {
			logger.info("ESTADO ASPIRANTE CREADO");
			repositorio.save(aspirante);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR ESTADO ASPIRANTE");
			return false;
		}
	}

	@Override
	public boolean actualizar(EEstadoAspirante aspirante) {
		try {
			logger.info("ESTADO ASPIRANTE ACTUALIZADO");
			repositorio.save(aspirante);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR ESTADO ASPIRANTE");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			
			EEstadoAspirante aspirante = repositorio.findById(id);
			aspirante.setActivo(false);
			repositorio.save(aspirante);
			logger.info("ESTADO ASPIRANTE BORRADO");
			//repositorio.delete(aspirante);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR ESTADO ASPIRANTE");
			return false;
		}
	}

	@Override
	public List<MEstadoAspirante> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR ESTADO ASPIRANTES");
			return null;
		}
	}

	@Override
	public MEstadoAspirante obtener(long id) {
		try {
			return new MEstadoAspirante(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR ESTADO ASPIRANTES");
			return null;
		}
	}
}
