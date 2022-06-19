package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorDepartamento;
import com.cyad.posgrado.entity.EDepartamento;
import com.cyad.posgrado.model.MDepartamento;
import com.cyad.posgrado.repository.DepartamentoRepository;
/**
 * implementacion de la interface IDepartamentoService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_departamento")
public class DepartamentoService implements IDepartamentoService{
	@Autowired
	@Qualifier("repositorio_departamentos")
	private DepartamentoRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_departamento")
	private ConvertidorDepartamento convertidor;
	
	private static final Log logger = LogFactory.getLog(DepartamentoService.class);

	@Override
	public boolean crear(EDepartamento departamento) {
		try {
			repositorio.save(departamento);
			logger.info("DEPARTAMENTO CREADO");
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR DEPARTAMENTO");
			return false;
		}
	}
	
	@Override
	public boolean actualizar(EDepartamento departamento) {
		try {
			repositorio.save(departamento);
			logger.info("DEPARTAMENTO ACTUALIZADO");
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR DEPARTAMENTO");
			return false;
		}
	}
	
	@Override
	public boolean borrar(long id_departamento) {
		try {
			EDepartamento depto = repositorio.findById(id_departamento);
			depto.setActivo(false);
			repositorio.save(depto);
			logger.info("DEPARTAMENTO BORRADO");
			//repositorio.delete(depto);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR DEPARTAMENTO");
			return false;
		}
	}
	
	@Override
	public List<MDepartamento> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR DEPARTAMENTO");
			return null;
		}
	}
	

	@Override
	public MDepartamento obtener(long id) {
		try {
			return new MDepartamento(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR DEPARTAMENTO");
			return null;
		}
	}
	
}
