package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.ETipoProyecto;
import com.cyad.posgrado.model.MTipoProyecto;
/**
 * clase componente para conversion de entidad  ETipoProyecto a modelo MTipoProyecto
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_tipos_proyectos")
public class ConvertidorTipoProyecto {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades ETipoProyecto
	 * @return lista de objetos MTipoProyecto
	 */
	public List<MTipoProyecto> convertirLista(List<ETipoProyecto> etipos){
		List<MTipoProyecto> mtipos = new ArrayList<>();
		for(ETipoProyecto tipo : etipos) {
			mtipos.add(new MTipoProyecto(tipo));
		}
		return mtipos;
	}
}
