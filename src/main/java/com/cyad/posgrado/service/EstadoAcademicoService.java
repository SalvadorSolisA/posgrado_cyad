package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorEstadoAcademico;
import com.cyad.posgrado.entity.EEstadoAcademico;
import com.cyad.posgrado.model.MEstadoAcademico;
import com.cyad.posgrado.repository.EstadoAcademicoRepository;
/**
 * implementacion de la interface IEstadoAcademicoService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_estado_academico")
public class EstadoAcademicoService implements IEstadoAcademicoService{
	
	@Autowired
	@Qualifier("repositorio_estado_academico")
	private EstadoAcademicoRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_estados")
	private ConvertidorEstadoAcademico convertidor;
	
	private static final Log logger = LogFactory.getLog(EstadoAcademicoService.class);

	@Override
	public boolean crear(EEstadoAcademico estado) {
		try {
			logger.info("ESTADO CREADO");
			repositorio.save(estado);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL CREAR ESTADO");
			return false;
		}
	}

	@Override
	public boolean actualizar(EEstadoAcademico estado) {
		try {
			logger.info("ESTADO ACTUALIZADO");
			repositorio.save(estado);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR ESTADO");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			EEstadoAcademico estado = repositorio.findById(id);
			logger.info("ESTADO BORRADO");
			estado.setActivo(false);
			repositorio.save(estado);
			//repositorio.delete(estado);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR ESTADO");
			return false;
		}
	}

	@Override
	public List<MEstadoAcademico> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR ESTADOS");
			return null;
		}
	}

	@Override
	public MEstadoAcademico obtener(long id) {
		try {
			return new MEstadoAcademico(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR ESTADOS");
			return null;
		}
	}

}
