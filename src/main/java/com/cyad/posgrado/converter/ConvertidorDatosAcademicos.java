package com.cyad.posgrado.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cyad.posgrado.entity.EDatosAcademicos;
import com.cyad.posgrado.model.MDatosAcademicos;
/**
 * clase componente para conversion de entidad  EDatosAcademicos a modelo MDatosAcademicos
 * @author Salvador Solis Atenco
 *
 */
@Component("convertidor_datos_academicos")
public class ConvertidorDatosAcademicos {
	/**
	 * metodo que convierte una lista de entidades a objetos
	 * @param lista de entidades EDatosAcademicos
	 * @return lista de objetos MDatosAcademicos
	 */
	public List<MDatosAcademicos> convertirLista(List<EDatosAcademicos> edatos){
		List<MDatosAcademicos> mDatosAcademicoss = new ArrayList<>();
		for(EDatosAcademicos DatosAcademicos : edatos) {
			mDatosAcademicoss.add(new MDatosAcademicos(DatosAcademicos));
		}
		return mDatosAcademicoss;
	}
}
