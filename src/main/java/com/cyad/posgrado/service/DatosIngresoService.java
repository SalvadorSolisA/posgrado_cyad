package com.cyad.posgrado.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorDatosIngreso;
import com.cyad.posgrado.entity.EDatosIngreso;
import com.cyad.posgrado.model.MDatosIngreso;
import com.cyad.posgrado.repository.DatosIngresoRepository;
/**
 * implementacion de la interface IDatosIngresoService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_datos_ingreso")
public class DatosIngresoService implements IDatosIngresoService {
	@Autowired
	@Qualifier("repositorio_datos_ingreso")
	private DatosIngresoRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_datos_ingreso")
	private ConvertidorDatosIngreso convertidor;
	
	private static final Log logger = LogFactory.getLog(DatosIngresoService.class);

	@Override
	public boolean crear(EDatosIngreso datos) {
		try {
			logger.info("DATOS DE INGRESO CREADOS");
			repositorio.save(datos);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR DATOS DE INGRESO");
			return false;
		}
	}

	@Override
	public boolean actualizar(EDatosIngreso datos) {
		try {
			logger.info("DATOS DE INGRESO ACTUALIZADOS");
			repositorio.save(datos);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR DATOS DE INGRESO");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {
			logger.info("DATOS DE INGRESO BORRADO");
			EDatosIngreso datos = repositorio.findById(id);
			datos.setActivo(false);
			//repositorio.delete(datos);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR DATOS DE INGRESO");
			return false;
		}
	}

	@Override
	public List<MDatosIngreso> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR DATOS DE INGRESOS");
			return null;
		}

	}

	@Override
	public MDatosIngreso obtener(long id) {
		try {
			return new MDatosIngreso(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR DATOS DE INGRESOS");
			return null;
		}
	}
}
