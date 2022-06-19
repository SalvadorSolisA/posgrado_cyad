package com.cyad.producciones.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.producciones.entity.ETipoClave;
import com.cyad.producciones.model.MTipoClave;
/**
 * Esta clase realiza una conversion de una entidad a un objeto
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_tipo_clave")
public class ConvertidorTipoClave {
	/**
	 * metodo que convierte una lista de entidades en objetos
	 * @param lista de entidades ETipoClave
	 * @return lista de objetos MTipoClave
	 */
	public List<MTipoClave > convertirLista(List<ETipoClave > eclavesAutor){
		List<MTipoClave > mclavesAutor = new ArrayList<>();
		for(ETipoClave  claveAutor : eclavesAutor) {
			mclavesAutor.add(new MTipoClave (claveAutor));
		}
		return mclavesAutor;
	}
	
}
