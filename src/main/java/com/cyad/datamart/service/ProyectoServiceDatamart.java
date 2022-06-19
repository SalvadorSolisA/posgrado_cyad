package com.cyad.datamart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyad.datamart.entity.EProyectoDatamart;
import com.cyad.datamart.model.MProyectoDatamart;
/**
 * implementacion de la interface IProyectoService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("data_proyecto_service")
public class ProyectoServiceDatamart implements IProyectoService {

	@Override
	public boolean crear(EProyectoDatamart proyecto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MProyectoDatamart> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

}
