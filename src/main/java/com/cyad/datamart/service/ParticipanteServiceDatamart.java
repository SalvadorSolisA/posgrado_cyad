package com.cyad.datamart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyad.datamart.entity.EParticipanteDatamart;
import com.cyad.datamart.model.MParticipanteDatamart;
/**
 * implementacion de la interface IParticipanteService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("data_pariticipantes_service")
public class ParticipanteServiceDatamart implements IParticipanteService{

	@Override
	public boolean crear(EParticipanteDatamart participante) {
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
	public List<MParticipanteDatamart> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

}
