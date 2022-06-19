package com.cyad.aspirantes.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.aspirantes.entity.EEstadoAspirante;
import com.cyad.aspirantes.model.MEstadoAspirante;
/**
 * Esta clase realiza una conversion de una entidad a un objeto
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_estado_aspirante")
public class ConvertidorEstadoAspirante {
	/**
	 * metodo que convierte una lista de entidades en objetos
	 * @param lista de entidades estados
	 * @return lista de objetos estados
	 */
	public List<MEstadoAspirante> convertirLista(List<EEstadoAspirante> eestados){
		List<MEstadoAspirante> mestados = new ArrayList<>();
		for(EEstadoAspirante estado : eestados) {
			mestados.add(new MEstadoAspirante(estado));
		}
		return mestados;
	}
}
