package com.cyad.producciones.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.producciones.entity.ETipoProduccion;
import com.cyad.producciones.model.MTipoProduccion;
/**
 * Esta clase realiza una conversion de una entidad a un objeto
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_tipo_produccion")
public class ConvertidorTipoProduccion {
	/**
	 * metodo que convierte una lista de entidades en objetos
	 * @param lista de entidades ETipoProduccion
	 * @return lista de objetos MTipoProduccion
	 */
	public List<MTipoProduccion > convertirLista(List<ETipoProduccion > etipos){
		List<MTipoProduccion > mtipos = new ArrayList<>();
		for(ETipoProduccion  tipo : etipos) {
			mtipos.add(new MTipoProduccion (tipo));
		}
		return mtipos;
	}
}
