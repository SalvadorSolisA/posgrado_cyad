package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EProfesor;
import com.cyad.posgrado.model.MProfesor;
/**
 * clase componente para conversion de entidad  EProfesor a modelo MProfesor
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_profesor")
public class ConvertidorProfesor {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EProfesor
	 * @return lista de objetos MProfesor
	 */
	public List<MProfesor> convertirLista(List<EProfesor> profesores){
		List<MProfesor> mprofesores = new ArrayList<>();
		for(EProfesor profesor : profesores) {
			mprofesores.add(new MProfesor(profesor));
		}
		return mprofesores;
	}
}
