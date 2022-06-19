package com.cyad.datamart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyad.datamart.entity.ETrimestreDatamart;
import com.cyad.datamart.model.MTrimestreDatamart;
/**
 * implementacion de la interface ITrimestreService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("data_trimestre_service")
public class TrimestreServiceDatamart implements ITrimestreService{

	@Override
	public boolean crear(ETrimestreDatamart alumno) {
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
	public List<MTrimestreDatamart> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

}
