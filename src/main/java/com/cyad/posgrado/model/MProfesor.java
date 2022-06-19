package com.cyad.posgrado.model;

import com.cyad.posgrado.entity.EProfesor;
/**
 * clase que representa el objeto java de la entidad EProfesor
 * @author Salvador Solis Atenco
 *
 */
public class MProfesor {
	private long id;
	private long numero_economico;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private long cvu;
	private boolean activo;
	private MDepartamento departamento;
	private MDivision division;
	private MInstitucion institucion;
	private MAreaInvestigacion area_investigacion;
	
	public MProfesor() {
		
	}

	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad profesor
	 */
	public MProfesor(EProfesor profesor) {
		super();
		this.id = profesor.getId();
		this.numero_economico = profesor.getNumero_economico();
		this.nombre = profesor.getNombre();
		this.ap_paterno = profesor.getAp_paterno();
		this.ap_materno = profesor.getAp_materno();
		if(profesor.getCvu() != 0)
			this.cvu = profesor.getCvu();
		this.activo = profesor.isActivo();
		if(profesor.getDepartamento() != null)
			this.departamento = new MDepartamento(profesor.getDepartamento());
		if(profesor.getDivision() != null)
			this.division = new MDivision(profesor.getDivision());
		if(profesor.getInstitucion() != null)
			this.institucion = new MInstitucion(profesor.getInstitucion());
		if(profesor.getArea_investigacion() != null)
			this.area_investigacion = new MAreaInvestigacion(profesor.getArea_investigacion());
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumero_economico() {
		return numero_economico;
	}

	public void setNumero_economico(long numero_economico) {
		this.numero_economico = numero_economico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}

	public long getCvu() {
		return cvu;
	}

	public void setCvu(long cvu) {
		this.cvu = cvu;
	}

	public MDepartamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(MDepartamento departamento) {
		this.departamento = departamento;
	}

	public MDivision getDivision() {
		return division;
	}

	public void setDivision(MDivision division) {
		this.division = division;
	}

	public MInstitucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(MInstitucion institucion) {
		this.institucion = institucion;
	}

	public MAreaInvestigacion getArea_investigacion() {
		return area_investigacion;
	}

	public void setArea_investigacion(MAreaInvestigacion area_investigacion) {
		this.area_investigacion = area_investigacion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	
}	