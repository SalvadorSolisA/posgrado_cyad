package com.cyad.producciones.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.producciones.entity.ETipoAutor;
import com.cyad.producciones.model.MTipoAutor;
/**
 * Esta clase realiza una conversion de una entidad a un objeto
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_tipo_autor")
public class ConvertidorTipoAutor {
	/**
	 * metodo que convierte una lista de entidades en objetos
	 * @param lista de entidades ETipoAutor
	 * @return lista de objetos MTipoAutor
	 */
	public List<MTipoAutor > convertirLista(List<ETipoAutor > etiposAutor){
		List<MTipoAutor > mtiposAutor = new ArrayList<>();
		for(ETipoAutor  tipoAutor : etiposAutor) {
			mtiposAutor.add(new MTipoAutor (tipoAutor));
		}
		return mtiposAutor;
	}
	
}
