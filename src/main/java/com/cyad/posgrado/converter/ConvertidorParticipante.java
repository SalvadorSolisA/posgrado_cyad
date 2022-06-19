package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EParticipante;
import com.cyad.posgrado.model.MParticipante;
/**
 * clase componente para conversion de entidad  EParticipante a modelo MParticipante
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_participantes")
public class ConvertidorParticipante {
	
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EParticipante
	 * @return lista de objetos MParticipante
	 */
	public List<MParticipante> convertirLista(List<EParticipante> eparticipantes){
		List<MParticipante> mparticipantes = new ArrayList<>();
		for(EParticipante participante : eparticipantes) {
			mparticipantes.add(new MParticipante(participante));
		}
		return mparticipantes;
	}
}
