package com.cyad.datamart.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.datamart.entity.EAlumnoDatamart;
import com.cyad.datamart.model.MAlumnoDatamart;
/**
 * clase componente para conversion de entidad  EAlumnoDatamart a modelo MAlumnoDatamart
 * @author Salvador Solis Atenco
 *
 */
@Component("data_convertidor_alumno")
public class ConvertidorAlumnoDatamart {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EAlumnoDatamart
	 * @return lista de objetos MAlumnoDatamart
	 */
	public List<MAlumnoDatamart> convertirLista(List<EAlumnoDatamart> e_alumnos){
		List<MAlumnoDatamart> m_alumnos = new ArrayList<MAlumnoDatamart>();
		for(EAlumnoDatamart alumno : e_alumnos)
			m_alumnos.add(new MAlumnoDatamart(alumno));
		
		return m_alumnos;
	}
}
