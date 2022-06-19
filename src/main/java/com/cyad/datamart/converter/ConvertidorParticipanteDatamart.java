package com.cyad.datamart.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.datamart.entity.EParticipanteDatamart;
import com.cyad.datamart.model.MParticipanteDatamart;
/**
 * clase componente para conversion de entidad  EParticipanteDatamart a modelo MParticipanteDatamart
 * @author Salvador Solis Atenco
 *
 */
@Component("data_convertidor_participante")
public class ConvertidorParticipanteDatamart {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EParticipanteDatamart
	 * @return lista de objetos MParticipanteDatamart
	 */
	public List<MParticipanteDatamart> convertirLista(List<EParticipanteDatamart> e_participantes){
		List<MParticipanteDatamart> m_participantes = new ArrayList<MParticipanteDatamart>();
		for(EParticipanteDatamart partiocipante : e_participantes)
			m_participantes.add(new MParticipanteDatamart(partiocipante));
		
		return m_participantes;
	}
}
