package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.ECorreo;
import com.cyad.posgrado.model.MCorreo;
/**
 * clase componente para conversion de entidad  ECorreo a modelo MCorreo
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_correos")
public class ConvertidorCorreo {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades ECorreo
	 * @return lista de objetos MCorreo
	 */
	public List<MCorreo> convertirLista(List<ECorreo> ecorreos){
		List<MCorreo> mcorreos = new ArrayList<>();
		for(ECorreo correo : ecorreos) {
			mcorreos.add(new MCorreo(correo));
		}
		return mcorreos;
	}
}
