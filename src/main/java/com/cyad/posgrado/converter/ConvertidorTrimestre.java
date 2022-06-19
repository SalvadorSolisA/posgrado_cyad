package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.ETrimestre;
import com.cyad.posgrado.model.MTrimestre;
/**
 * clase componente para conversion de entidad  ETrimestre a modelo MTrimestre
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_trimestres")
public class ConvertidorTrimestre {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades ETrimestre
	 * @return lista de objetos MTrimestre
	 */
	public List<MTrimestre> convertirLista(List<ETrimestre> etrimestres){
		List<MTrimestre> mtrimestres = new ArrayList<>();
		for(ETrimestre trimestre : etrimestres) {
			mtrimestres.add(new MTrimestre(trimestre));
		}
		return mtrimestres;
	}
}
