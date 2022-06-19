package com.cyad.producciones.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.producciones.entity.EOrdenAutor;
import com.cyad.producciones.model.MOrdenAutor;
/**
 * Esta clase realiza una conversion de una entidad a un objeto
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_orden_autor")
public class ConvertidorOrdenAutor {
	/**
	 * metodo que convierte una lista de entidades en objetos
	 * @param lista de entidades EOrdenAutor
	 * @return lista de objetos MOrdenAutor
	 */
	public List<MOrdenAutor> convertirLista(List<EOrdenAutor> eordenes){
		List<MOrdenAutor> mordenes = new ArrayList<>();
		for(EOrdenAutor orden : eordenes) {
			mordenes.add(new MOrdenAutor(orden));
		}
		return mordenes;
	}

}
