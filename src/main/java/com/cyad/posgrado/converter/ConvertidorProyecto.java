package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EProyecto;
import com.cyad.posgrado.model.MProyecto;
/**
 * clase componente para conversion de entidad  EProyecto a modelo MProyecto
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_proyectos")
public class ConvertidorProyecto {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EProyecto
	 * @return lista de objetos MProyecto
	 */
	public List<MProyecto> convertirLista(List<EProyecto> eproyectos){
		List<MProyecto> mproyectos = new ArrayList<>();
		for(EProyecto proyecto : eproyectos) {
			mproyectos.add(new MProyecto(proyecto));
		}
		return mproyectos;
	}
}
