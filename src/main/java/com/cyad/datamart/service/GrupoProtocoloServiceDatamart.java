package com.cyad.datamart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyad.datamart.entity.EGrupoProtocoloDatamart;
import com.cyad.datamart.model.MGrupoProtocoloDatamart;
/**
 * implementacion de la interface IGrupoProtocoloService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("data_grupo_service")
public class GrupoProtocoloServiceDatamart implements IGrupoProtocoloService{

	@Override
	public boolean crear(EGrupoProtocoloDatamart grupo) {
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
	public List<MGrupoProtocoloDatamart> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

}
