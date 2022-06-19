package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EDireccion;
import com.cyad.posgrado.model.MDireccion;
/**
 * clase componente para conversion de entidad  EDireccion a modelo MDireccion
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_direcciones")
public class ConvertidorDireccion {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EDireccion
	 * @return lista de objetos MDireccion
	 */
	public List<MDireccion> convertirLista(List<EDireccion> edirecciones){
		List<MDireccion> mdirecciones = new ArrayList<>();
		for(EDireccion direccion : edirecciones) {
			mdirecciones.add(new MDireccion(direccion));
		}
		return mdirecciones;
	}
}
