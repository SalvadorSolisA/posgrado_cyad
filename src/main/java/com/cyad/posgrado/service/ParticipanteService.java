package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorParticipante;
import com.cyad.posgrado.entity.EParticipante;
import com.cyad.posgrado.model.MParticipante;
import com.cyad.posgrado.repository.ParticipantesRepository;
/**
 * implementacion de la interface IParticipanteService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_participante")
public class ParticipanteService implements IParticipanteService{
	@Autowired
	@Qualifier("repositorio_participantes")
	private ParticipantesRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_participantes")
	private ConvertidorParticipante convertidor;
	
	private static final Log logger = LogFactory.getLog(ParticipanteService.class);
	
	@Override
	public boolean crear(EParticipante participante) {
		try {
			logger.info("PARTICIPANTE CREADO");
			repositorio.save(participante);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR PARTICIPANTE " + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(EParticipante participante) {
		try {
			logger.info("PARTICIPANTE ACTUALIZADO");
			repositorio.save(participante);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR PARTICIPANTE "+ e );
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			EParticipante participante = repositorio.findById(id);
			logger.info("PARTICIPANTE BORRADO");
			repositorio.delete(participante);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR PARTICIPANTE " + e);
			return false;
		}
	}

	@Override
	public List<MParticipante> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR PARTICIPANTES " + e);
			return null;
		}
	}

	@Override
	public MParticipante obtener(long id) {
		try {
			return new MParticipante(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR PARTICIPANTES " + e);
			return null;
		}
	}

}
