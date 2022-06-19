package com.cyad.datamart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyad.datamart.entity.EDatosPorTrimestreDatamart;
import com.cyad.datamart.model.MDatosPorTrimestreDatamart;
/**
 * implementacion de la interface IDatosPorTrimestreService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("data_datos_service")
public class DatosPorTrimestreServiceDatamart implements IDatosPorTrimestreService{

	@Override
	public boolean crear(EDatosPorTrimestreDatamart datos) {
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
	public List<MDatosPorTrimestreDatamart> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

}
