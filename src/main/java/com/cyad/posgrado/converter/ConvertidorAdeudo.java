package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EAdeudo;
import com.cyad.posgrado.model.MAdeudo;
/**
 * clase componente para conversion de entidad  EAdeudo a modelo MAdeudo
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_adeudos")
public class ConvertidorAdeudo {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EAdeudo
	 * @return lista de objetos MAdeudo
	 */
	public List<MAdeudo> convertirLista(List<EAdeudo> eadeudos){
		List<MAdeudo> madeudos = new ArrayList<>();
		for(EAdeudo adeudo : eadeudos) {
			madeudos.add(new MAdeudo(adeudo));
		}
		return madeudos;
	}
}
