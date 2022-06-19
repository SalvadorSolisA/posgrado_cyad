package com.cyad.datamart.model;

import java.util.ArrayList;
import java.util.List;

import com.cyad.datamart.entity.EDatosPorTrimestreDatamart;
import com.cyad.datamart.entity.ETrayectoriaDatamart;


/**
 * clase que representa el objeto java de la entidad ETrayectoriaDatamart
 * @author Salvador Solis Atenco
 *
 */
public class MTrayectoriaDatamart {
	private long id;
	private List<MDatosPorTrimestreDatamart> datos;
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad trimestre
	 */
	public MTrayectoriaDatamart(ETrayectoriaDatamart trayectoria) {
		super();
		this.id = trayectoria.getId();
		if(trayectoria.getDatos() != null) {
			this.datos = new ArrayList<MDatosPorTrimestreDatamart>();
			for(EDatosPorTrimestreDatamart dato : trayectoria.getDatos())
				this.datos.add(new MDatosPorTrimestreDatamart(dato));
		}
			
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<MDatosPorTrimestreDatamart> getDatos() {
		return datos;
	}

	public void setDatos(List<MDatosPorTrimestreDatamart> datos) {
		this.datos = datos;
	}
	
	
	
	
}
