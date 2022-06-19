package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EAreaConcentracion;
import com.cyad.posgrado.model.MAreaConcentracion;
/**
 * clase componente para conversion de entidad  EAreaConcentracion a modelo MAreaConcentracion
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_area_concentracion")
public class ConvertidorAreaConcentracion {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EAreaConcentracion
	 * @return lista de objetos MAreaConcentracion
	 */
	public List<MAreaConcentracion> convertirLista(List<EAreaConcentracion> eareas){
		List<MAreaConcentracion> mareas = new ArrayList<>();
		for(EAreaConcentracion area : eareas) {
			mareas.add(new MAreaConcentracion(area));
		}
		return mareas;
	}
}
