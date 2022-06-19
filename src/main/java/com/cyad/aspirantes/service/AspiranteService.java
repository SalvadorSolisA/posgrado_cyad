package com.cyad.aspirantes.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.aspirantes.converter.ConvertidorAspirante;
import com.cyad.aspirantes.entity.EAspirante;
import com.cyad.aspirantes.model.MAspirante;
import com.cyad.aspirantes.repository.AspiranteRepository;
/**
 * esta clase implementa la interfaz IAspiranteService para crear el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_aspirante")
public class AspiranteService implements IAspiranteService{
	@Autowired
	@Qualifier("repositorio_aspirantes")
	private AspiranteRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_aspirante")
	private ConvertidorAspirante convertidor;

	private static final Log logger = LogFactory.getLog(AspiranteService.class);

	@Override
	public boolean crear(EAspirante aspirante) {
		try {
			logger.info("ASPIRANTE CREADO");
			repositorio.save(aspirante);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR ASPIRANTE "+e);
			return false;
		}
	}

	@Override
	public boolean actualizar(EAspirante aspirante) {
		try {
			logger.info("ASPIRANTE ACTUALIZADO");
			repositorio.save(aspirante);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR ASPIRANTE "+e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			
			EAspirante aspirante = repositorio.findById(id);
			aspirante.setActivo(false);
			repositorio.save(aspirante);
			//repositorio.delete(aspirante);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR ASPIRANTE "+e);
			return false;
		}
	}

	@Override
	public List<MAspirante> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR ASPIRANTES" + e);
			return null;
		}
	}

	@Override
	public MAspirante obtener(long id) {
		try {
			return new MAspirante(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR ASPIRANTES" + e);
			return null;
		}
	}
}
