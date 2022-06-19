package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EGrupoProtocolo;
import com.cyad.posgrado.model.MGrupoProtocolo;
/**
 * clase componente para conversion de entidad  EGrupoProtocolo a modelo MGrupoProtocolo
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_grupo_protocolo")
public class ConvertidorGrupoProtocolo {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EGrupoProtocolo
	 * @return lista de objetos MGrupoProtocolo
	 */
	public List<MGrupoProtocolo> convertirLista(List<EGrupoProtocolo> egrupos){
		List<MGrupoProtocolo> mgrupos = new ArrayList<>();
		for(EGrupoProtocolo grupo : egrupos) {
			mgrupos.add(new MGrupoProtocolo(grupo));
		}
		return mgrupos;
	}
}
