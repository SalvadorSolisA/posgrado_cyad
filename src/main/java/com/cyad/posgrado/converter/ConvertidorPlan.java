package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EPlan;
import com.cyad.posgrado.model.MPlan;
/**
 * clase componente para conversion de entidad  EPlan a modelo MPlan
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_planes")
public class ConvertidorPlan {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EPlan
	 * @return lista de objetos MPlan
	 */
	public List<MPlan> convertirLista(List<EPlan> eplanes){
		List<MPlan> mplanes = new ArrayList<>();
		for(EPlan plan : eplanes) {
			mplanes.add(new MPlan(plan));
		}
		return mplanes;
	}
}
