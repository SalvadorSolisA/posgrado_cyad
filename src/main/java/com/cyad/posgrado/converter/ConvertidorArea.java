package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EAreaInvestigacion;
import com.cyad.posgrado.model.MAreaInvestigacion;
/**
 * clase componente para conversion de entidad  EAreaInvestigacion a modelo MAreaInvestigacion
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_areas")
public class ConvertidorArea {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EAreaInvestigacion
	 * @return lista de objetos MAreaInvestigacion
	 */
	public List<MAreaInvestigacion> convertirLista(List<EAreaInvestigacion> eareas){
		List<MAreaInvestigacion> mareas = new ArrayList<>();
		for(EAreaInvestigacion area : eareas) {
			mareas.add(new MAreaInvestigacion(area));
		}
		return mareas;
	}
}
