package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EEstadoAcademico;
import com.cyad.posgrado.model.MEstadoAcademico;
/**
 * clase componente para conversion de entidad  EEstadoAcademico a modelo MEstadoAcademico
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_estados")
public class ConvertidorEstadoAcademico {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EEstadoAcademico
	 * @return lista de objetos MEstadoAcademico
	 */
	public List<MEstadoAcademico> convertirLista(List<EEstadoAcademico> eestados){
		List<MEstadoAcademico> mestados = new ArrayList<>();
		for(EEstadoAcademico estaado : eestados) {
			mestados.add(new MEstadoAcademico(estaado));
		}
		return mestados;
	}
}
