package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.ERol;
import com.cyad.posgrado.model.MRol;
/**
 * clase componente para conversion de entidad  ERol a modelo MRol
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_rol")
public class ConvertidorRol {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades ERol
	 * @return lista de objetos MRol
	 */
	public List<MRol> convertirLista(List<ERol> roles){
		List<MRol> mroles = new ArrayList<>();
		for(ERol rol : roles) {
			mroles.add(new MRol(rol));
		}
		return mroles;
	}
}
