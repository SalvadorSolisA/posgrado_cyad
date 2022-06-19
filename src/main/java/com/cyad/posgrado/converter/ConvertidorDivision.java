package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EDivision;
import com.cyad.posgrado.model.MDivision;
/**
 * clase componente para conversion de entidad  EDivision a modelo MDivision
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_division")
public class ConvertidorDivision {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EDivision
	 * @return lista de objetos MDivision
	 */
	public List<MDivision> convertirLista(List<EDivision> edivisiones){
		List<MDivision> mdivisiones = new ArrayList<>();
		for(EDivision vision : edivisiones) {
			mdivisiones.add(new MDivision(vision));
		}
		return mdivisiones;
	}
}
