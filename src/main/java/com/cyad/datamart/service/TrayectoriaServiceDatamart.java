package com.cyad.datamart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyad.datamart.entity.ETrayectoriaDatamart;
import com.cyad.datamart.model.MTrayectoriaDatamart;
/**
 * implementacion de la interface ITrayectoriaService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("data_trayectoria_service")
public class TrayectoriaServiceDatamart implements ITrayectoriaService {

	@Override
	public boolean crear(ETrayectoriaDatamart trayectoria) {
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
	public List<MTrayectoriaDatamart> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

}
