package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EInstitucion;
import com.cyad.posgrado.model.MInstitucion;
/**
 * clase componente para conversion de entidad  EInstitucion a modelo MInstitucion
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_instituciones")
public class ConvertidorInstituciones {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EInstitucion
	 * @return lista de objetos MInstitucion
	 */
	public List<MInstitucion> convertirLista(List<EInstitucion> einstituciones){
		List<MInstitucion> minstituciones = new ArrayList<>();
		for(EInstitucion institucion : einstituciones) {
			minstituciones.add(new MInstitucion(institucion));
		}
		return minstituciones;
	}
}
