package com.cyad.posgrado.model;

import java.util.ArrayList;
import java.util.List;

import com.cyad.posgrado.entity.EAlumno;
import com.cyad.posgrado.entity.ECorreo;
import com.cyad.posgrado.entity.EDireccion;
/**
 * clase que representa el objeto java de la entidad EAlumno
 * @author Salvador Solis Atenco
 *
 */
public class MAlumno {
	private long id;
	private long matricula;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private String curp;
	private String rfc;
	private long cvu;
	private long orcid;
	private String fecha_nacimiento;
	private int edad;
	private char genero;	
	private String telefono;
	private String nacionalidad;
	private boolean activo;
	private List<MDireccion> direcciones;
	private List<MCorreo> correos;
	private MDatosIngreso datos_ingreso;
	private MDatosAcademicos datos_academicos;
	
	public MAlumno() {
		super();
	}
	/**
	 * constructor para la conversion de entidad a objeto
	 * @param entidad alumno
	 */
	public MAlumno(EAlumno alumno) {
		super();
		this.id = alumno.getId();
		this.matricula = alumno.getMatricula();
		this.nombre = alumno.getNombre();
		this.ap_paterno = alumno.getAp_paterno();
		this.ap_materno = alumno.getAp_materno();
		this.curp = alumno.getCurp();
		this.rfc = alumno.getRfc();
		this.cvu = alumno.getCvu();
		this.orcid = alumno.getOrcid();
		this.fecha_nacimiento = alumno.getFecha_nacimiento();
		this.edad = alumno.getEdad();
		this.genero = alumno.getGenero();
		this.telefono = alumno.getTelefono();
		this.nacionalidad = alumno.getNacionalidad();
		this.activo = alumno.isActivo();
		if(alumno.getCorreos()!= null) {
			this.correos = new ArrayList<MCorreo>();
			for(ECorreo correo : alumno.getCorreos()) {
				this.correos.add(new MCorreo(correo));
			}
		}
		
		if(alumno.getDirecciones()!= null) {
			this.direcciones = new ArrayList<MDireccion>();
			for(EDireccion direccion : alumno.getDirecciones()) {
				this.direcciones.add(new MDireccion(direccion));
			}
		}
		
		if(alumno.getDatos_ingreso()!= null) 
			this.datos_ingreso = new MDatosIngreso(alumno.getDatos_ingreso());
		
		if(alumno.getDatos_academicos() != null)
			this.datos_academicos = new MDatosAcademicos(alumno.getDatos_academicos());
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

	public List<MDireccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<MDireccion> direcciones) {
		this.direcciones = direcciones;
	}

	public List<MCorreo> getCorreos() {
		return correos;
	}

	public void setCorreos(List<MCorreo> correos) {
		this.correos = correos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public MDatosIngreso getDatos_ingreso() {
		return datos_ingreso;
	}

	public void setDatos_ingreso(MDatosIngreso datos_ingreso) {
		this.datos_ingreso = datos_ingreso;
	}

	public MDatosAcademicos getDatos_academicos() {
		return datos_academicos;
	}

	public void setDatos_academicos(MDatosAcademicos datos_academicos) {
		this.datos_academicos = datos_academicos;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	
	
}
