package com.cyad.aspirantes.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.aspirantes.converter.ConvertidorAdeudoAspirante;
import com.cyad.aspirantes.entity.EAdeudoAspirante;
import com.cyad.aspirantes.model.MAdeudoAspirante;
import com.cyad.aspirantes.repository.AdeudoAspiranteRepository;
/**
 * esta clase implementa la interfaz IAdeudoAspiranteService para crear el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_adeudo_aspirante")
public class AdeudoAspiranteService implements IAdeudoAspiranteService{
	@Autowired
	@Qualifier("repositorio_adeudos_aspirantes")
	private AdeudoAspiranteRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_adeudo_aspirante")
	private ConvertidorAdeudoAspirante convertidor;

	private static final Log logger = LogFactory.getLog(AdeudoAspiranteService.class);

	@Override
	public boolean crear(EAdeudoAspirante adeudo) {
		try {
			logger.info("ADEUDO ASPIRANTE CREADO");
			repositorio.save(adeudo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR ADEUDO ASPIRANTE");
			return false;
		}
	}

	@Override
	public boolean actualizar(EAdeudoAspirante adeudo) {
		try {
			logger.info("ADEUDO ASPIRANTE ACTUALIZADO");
			repositorio.save(adeudo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR ADEUDO ASPIRANTE");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			logger.info("ADEUDO ASPIRANTE BORRADO");
			EAdeudoAspirante adeudo = repositorio.findById(id);
			adeudo.setActivo(false);
			//repositorio.delete(adeudo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR ADEUDO ASPIRANTE");
			return false;
		}
	}

	@Override
	public List<MAdeudoAspirante> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR ADEUDO ASPIRANTES");
			return null;
		}
	}	
}
