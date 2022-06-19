package com.cyad.posgrado.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * clase entidad representa a los los profesores de los posgrados
 * @author Salvador Solis Atenco
 *
 */
@Table(name="profesor")
@Entity
public class EProfesor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="NUMERO_ECONOMICO")
	private long numero_economico;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="AP_PATERNO")
	private String ap_paterno;
	
	@Column(name="AP_MATERNO")
	private String ap_materno;
	
	@Column(name="CVU")
	private long cvu;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO" )
	private EDepartamento departamento;
	
	@ManyToOne
	@JoinColumn(name="ID_DIVISION")
	private EDivision division;
	
	@ManyToOne
	@JoinColumn(name="ID_INSTITUCION")
	private EInstitucion institucion;
	
	@ManyToOne
	@JoinColumn(name="ID_AREA_INVESTIGACION")
	private EAreaInvestigacion area_investigacion;
	
	public EProfesor() {
		this.activo = true;
		this.numero_economico = 0;
		this.nombre = "";
		this.ap_paterno = "";
		this.ap_materno = "";
		this.cvu = 0;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public EDepartamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(EDepartamento departamento) {
		this.departamento = departamento;
	}

	public EDivision getDivision() {
		return division;
	}

	public void setDivision(EDivision division) {
		this.division = division;
	}

	public EInstitucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(EInstitucion institucion) {
		this.institucion = institucion;
	}

	public EAreaInvestigacion getArea_investigacion() {
		return area_investigacion;
	}

	public void setArea_investigacion(EAreaInvestigacion area_investigacion) {
		this.area_investigacion = area_investigacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}	
