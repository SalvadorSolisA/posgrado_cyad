package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.ENivel;
import com.cyad.posgrado.model.MNivel;
/**
 * clase componente para conversion de entidad  ENivel a modelo MNivel
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_niveles")
public class ConvertidorNivel {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades ENivel
	 * @return lista de objetos MNivel
	 */
	public List<MNivel> convertirLista(List<ENivel> eniveles){
		List<MNivel> mniveles = new ArrayList<>();
		for(ENivel nivel : eniveles) {
			mniveles.add(new MNivel(nivel));
		}
		return mniveles;
	}
}
