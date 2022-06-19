package com.cyad.datamart.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.datamart.entity.EDatosPorTrimestreDatamart;
import com.cyad.datamart.model.MDatosPorTrimestreDatamart;
/**
 * clase componente para conversion de entidad  EGrupoProtocoloDatamart a modelo MGrupoProtocoloDatamart
 * @author Salvador Solis Atenco
 *
 */
@Component("data_convertidor_datos")
public class ConvertidorDatosPorTrimestreDatamart {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EDatosPorTrimestreDatamart
	 * @return lista de objetos MDatosPorTrimestreDatamart
	 */
	public List<MDatosPorTrimestreDatamart> convertirLista(List<EDatosPorTrimestreDatamart> e_datos){
		List<MDatosPorTrimestreDatamart> m_datos = new ArrayList<MDatosPorTrimestreDatamart>();
		for(EDatosPorTrimestreDatamart datos : e_datos)
			m_datos.add(new MDatosPorTrimestreDatamart(datos));
		
		return m_datos;
	}
}
