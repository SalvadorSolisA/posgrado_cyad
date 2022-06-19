package com.cyad.producciones.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.producciones.entity.EGrupoAutores;
import com.cyad.producciones.model.MGrupoAutores;
/**
 * Esta clase realiza una conversion de una entidad a un objeto
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_grupo_autores")
public class ConvertidorGrupoAutores {
	/**
	 * metodo que convierte una lista de entidades en objetos
	 * @param lista de entidades EGrupoAutores
	 * @return lista de objetos MGrupoAutores
	 */
	public List<MGrupoAutores> convertirLista(List<EGrupoAutores > eautores){
		List<MGrupoAutores > mautores = new ArrayList<>();
		for(EGrupoAutores  autor : eautores) {
			mautores.add(new MGrupoAutores (autor));
		}
		return mautores;
	}
}
