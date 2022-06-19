package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EDepartamento;
import com.cyad.posgrado.model.MDepartamento;
/**
 * clase componente para conversion de entidad  EDepartamento a modelo MDepartamento
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_departamento")
public class ConvertidorDepartamento {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EDepartamento
	 * @return lista de objetos MDepartamento
	 */
	public List<MDepartamento> convertirLista(List<EDepartamento> departamentos){
		List<MDepartamento> mdepartamentos = new ArrayList<>();
		for(EDepartamento departamento : departamentos) {
			mdepartamentos.add(new MDepartamento(departamento));
		}
		return mdepartamentos;
	}
		
}
