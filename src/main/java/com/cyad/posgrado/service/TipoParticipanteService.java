package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorTipoParticipante;
import com.cyad.posgrado.entity.ETipoParticipante;
import com.cyad.posgrado.model.MTipoParticipante;
import com.cyad.posgrado.repository.TipoParticipantesRepository;
/**
 * implementacion de la interface ITipoParticipanteService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_tipo_participante")
public class TipoParticipanteService implements ITipoParticipanteService {
	@Autowired
	@Qualifier("repositorio_tipo_participante")
	private TipoParticipantesRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_tipos_participantes")
	private ConvertidorTipoParticipante convertidor;
	
	private static final Log logger = LogFactory.getLog(ParticipanteService.class);

	@Override
	public boolean crear(ETipoParticipante tipo) {
		try {
			logger.info("TIPO PARTICIPANTE CREADO");
			repositorio.save(tipo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR TIPO PARTICIPANTE");
			return false;
		}
	}

	@Override
	public boolean actualizar(ETipoParticipante tipo) {
		try {
			logger.info("TIPO PARTICIPANTE ACTUALIZADO");
			repositorio.save(tipo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR TIPO PARTICIPANTE");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			ETipoParticipante tipo = repositorio.findById(id);
			logger.info("TIPO PARTICIPANTE BORRADO");
			repositorio.delete(tipo);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR TIPO PARTICIPANTE");
			return false;
		}
	}

	@Override
	public List<MTipoParticipante> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR TIPO PARTICIPANTE");
			return null;
		}
	}

	@Override
	public MTipoParticipante obtener(long id) {
		try {
			return new MTipoParticipante(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR TIPO PARTICIPANTE");
			return null;
		}
	}
}
