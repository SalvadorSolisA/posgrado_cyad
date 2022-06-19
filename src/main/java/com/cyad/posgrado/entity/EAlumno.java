package com.cyad.posgrado.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase entidad representa a los alumnos de los posgrados
 * @author Salvador Solis Atenco
 *
 */
@Table(name="ALUMNO")
@Entity
public class EAlumno implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="MATRICULA")
	private long matricula;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="AP_PATERNO")
	private String ap_paterno;
	
	@Column(name="AP_MATERNO")
	private String ap_materno;
	
	@Column(name="CURP")
	private String curp;
	
	@Column(name="RFC")
	private String rfc;
	
	@Column(name="CVU")
	private long cvu;
	
	@Column(name="ORCID")
	private long orcid;
	
	@Column(name="FECHA_NACIMIENTO")
	private String fecha_nacimiento;
	
	@Column(name="EDAD")
	private int edad;
	
	@Column(name="GENERO")
	private char genero;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="NACIONALIDAD")
	private String nacionalidad;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@OneToMany(mappedBy = "alumno", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<EDireccion> direcciones;
	
	@OneToMany(mappedBy = "alumno", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<ECorreo> correos;

	@OneToOne(mappedBy = "alumno")
	@JsonIgnore
	private EDatosIngreso datos_ingreso;
	
	@OneToOne(mappedBy = "alumno")
	@JsonIgnore
	private EDatosAcademicos datos_academicos;

	public EAlumno() {
		this.activo = true;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}



	public long getMatricula() {
		return matricula;
	}



	public void setMatricula(long matricula) {
		this.matricula = matricula;
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



	public String getRfc() {
		return rfc;
	}



	public void setRfc(String rfc) {
		this.rfc = rfc;
	}



	public long getCvu() {
		return cvu;
	}



	public void setCvu(long cvu) {
		this.cvu = cvu;
	}



	public long getOrcid() {
		return orcid;
	}



	public void setOrcid(long orcid) {
		this.orcid = orcid;
	}



	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}



	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public char getGenero() {
		return genero;
	}



	public void setGenero(char genero) {
		this.genero = genero;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String relefono) {
		this.telefono = relefono;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<EDireccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<EDireccion> direcciones) {
		this.direcciones = direcciones;
	}

	public List<ECorreo> getCorreos() {
		return correos;
	}

	public void setCorreos(List<ECorreo> correos) {
		this.correos = correos;
	}

	public EDatosIngreso getDatos_ingreso() {
		return datos_ingreso;
	}

	public void setDatos_ingreso(EDatosIngreso datos_ingreso) {
		this.datos_ingreso = datos_ingreso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EDatosAcademicos getDatos_academicos() {
		return datos_academicos;
	}

	public void setDatos_academicos(EDatosAcademicos datos_academicos) {
		this.datos_academicos = datos_academicos;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	
	
	
}
