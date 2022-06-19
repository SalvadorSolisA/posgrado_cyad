package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EAlumno;
import com.cyad.posgrado.model.MAlumno;
/**
 * clase componente para conversion de entidad  EAlumno a modelo MAlumno
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_alumnos")
public class ConvertidorAlumno {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EAlumno
	 * @return lista de objetos MAlumno
	 */
	public List<MAlumno> convertirLista(List<EAlumno> ealumnos){
		List<MAlumno> malumnos = new ArrayList<>();
		for(EAlumno elumno : ealumnos) {
			malumnos.add(new MAlumno(elumno));
		}
		return malumnos;
	}
}
