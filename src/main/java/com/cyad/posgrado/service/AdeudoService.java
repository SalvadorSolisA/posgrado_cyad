package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorAdeudo;
import com.cyad.posgrado.entity.EAdeudo;
import com.cyad.posgrado.model.MAdeudo;
import com.cyad.posgrado.repository.AdeudoRepository;
/**
 * implementacion de la interface IAdeudoService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_adeudos")
public class AdeudoService implements IAdeudoService {
	@Autowired
	@Qualifier("repositorio_adeudos")
	private AdeudoRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_adeudos")
	private ConvertidorAdeudo convertidor;
	
	private static final Log logger = LogFactory.getLog(AdeudoService.class);

	@Override
	public boolean crear(EAdeudo adeudo) {
		try {
			logger.info("ADEUDO CREADO");
			repositorio.save(adeudo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR ADEUDO");
			return false;
		}
	}

	@Override
	public boolean actualizar(EAdeudo adeudo) {
		try {
			logger.info("ADEUDO ACTUALIZADO");
			repositorio.save(adeudo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR ADEUDO");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			logger.info("ADEUDO BORRADO");
			EAdeudo adeudo = repositorio.findById(id);
			adeudo.setActivo(false);
			//repositorio.delete(adeudo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR ADEUDO");
			return false;
		}
	}

	@Override
	public List<MAdeudo> obtener() {
		try {
			logger.info("ERROR AL LISTAR ADEUDOS");
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			return null;
		}
	}
}
