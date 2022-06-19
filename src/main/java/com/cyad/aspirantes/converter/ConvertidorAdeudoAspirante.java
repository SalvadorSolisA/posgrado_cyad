package com.cyad.aspirantes.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.aspirantes.entity.EAdeudoAspirante;
import com.cyad.aspirantes.model.MAdeudoAspirante;
/**
 * Esta clase realiza una conversion de una entidad a un objeto
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_adeudo_aspirante")
public class ConvertidorAdeudoAspirante {
	/**
	 * metodo que convierte una lista de entidades en objetos
	 * @param lista de entidades adeudos de aspirante
	 * @return lista de objetos adeudos de aspirante
	 */
	public List<MAdeudoAspirante> convertirLista(List<EAdeudoAspirante> eadeudos){
		List<MAdeudoAspirante> madeudos = new ArrayList<>();
		for(EAdeudoAspirante adeudo : eadeudos) {
			madeudos.add(new MAdeudoAspirante(adeudo));
		}
		return madeudos;
	}
}
