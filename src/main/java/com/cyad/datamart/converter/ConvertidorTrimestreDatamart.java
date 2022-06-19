package com.cyad.datamart.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.datamart.entity.ETrayectoriaDatamart;
import com.cyad.datamart.model.MTrayectoriaDatamart;
/**
 * clase componente para conversion de entidad  ETrayectoriaDatamart a modelo MTrayectoriaDatamart
 * @author Salvador Solis Atenco
 *
 */
@Component("data_convertidor_trimestre")
public class ConvertidorTrimestreDatamart {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades ETrayectoriaDatamart
	 * @return lista de objetos MTrayectoriaDatamart
	 */
	public List<MTrayectoriaDatamart> convertirLista(List<ETrayectoriaDatamart> e_trayectorias){
		List<MTrayectoriaDatamart> m_trayectorias = new ArrayList<MTrayectoriaDatamart>();
		for(ETrayectoriaDatamart trayectoria : e_trayectorias)
			m_trayectorias.add(new MTrayectoriaDatamart(trayectoria));
		
		return m_trayectorias;
	}
}
