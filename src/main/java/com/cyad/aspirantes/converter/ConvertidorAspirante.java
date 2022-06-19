package com.cyad.aspirantes.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.aspirantes.entity.EAspirante;
import com.cyad.aspirantes.model.MAspirante;
/**
 * Esta clase realiza una conversion de una entidad a un objeto
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_aspirante")
public class ConvertidorAspirante {
	/**
	 * metodo que convierte una lista de entidades en objetos
	 * @param lista de entidades aspirantes
	 * @return lista de objetos aspirantes
	 */
	public List<MAspirante> convertirLista(List<EAspirante> easpirantes){
		List<MAspirante> maspirantes = new ArrayList<>();
		for(EAspirante aspirante : easpirantes) {
			maspirantes.add(new MAspirante(aspirante));
		}
		return maspirantes;
	}
}
