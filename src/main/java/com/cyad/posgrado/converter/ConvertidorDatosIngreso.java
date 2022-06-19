package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EDatosIngreso;
import com.cyad.posgrado.model.MDatosIngreso;
/**
 * clase componente para conversion de entidad  EDatosIngreso a modelo MDepartamento
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_datos_ingreso")
public class ConvertidorDatosIngreso {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EDatosIngreso
	 * @return lista de objetos MDepartamento
	 */
	public List<MDatosIngreso> convertirLista(List<EDatosIngreso> edatosIngresos){
		List<MDatosIngreso> mdatosIngresos = new ArrayList<>();
		for(EDatosIngreso datos : edatosIngresos) {
			mdatosIngresos.add(new MDatosIngreso(datos));
		}
		return mdatosIngresos;
	}
}
