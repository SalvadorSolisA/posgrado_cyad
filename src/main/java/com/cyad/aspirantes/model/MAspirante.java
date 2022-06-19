package com.cyad.aspirantes.model;

import java.util.ArrayList;
import java.util.List;

import com.cyad.aspirantes.entity.EAdeudoAspirante;
import com.cyad.aspirantes.entity.EAspirante;
/**
 * clase que reprenta el modelo de objeto de un aspirante a posgrado
 * @author Salvador Solis Atenco
 *
 */
public class MAspirante {
	private long id;
	private String curp;
	private String rfc;
	private String fecha_nacimiento;
	private int edad;
	private char genero;
	private String telefono;
	private String correo;
	private String nacionalidad;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private String trayectoria;
	private int anio_ingreso;
	private char trimestre_ingreso;
	private boolean activo;
	private MEstadoAspirante estado;
	private List<MAdeudoAspirante> adeudos;
	
	public MAspirante() {
		super();
	}

	public MAspirante(EAspirante aspirante) {
		super();
		this.id = aspirante.getId();
		this.curp = aspirante.getCurp();
		this.rfc = aspirante.getRfc();
		this.fecha_nacimiento = aspirante.getFecha_nacimiento();
		this.edad = aspirante.getEdad();
		this.genero = aspirante.getGenero();
		this.telefono = aspirante.getTelefono();
		this.correo = aspirante.getCorreo();
		this.nacionalidad = aspirante.getNacionalidad();
		this.nombre = aspirante.getNombre();
		this.ap_paterno = aspirante.getAp_paterno();
		this.ap_materno = aspirante.getAp_materno();
		this.trayectoria = aspirante.getTrayectoria();
		this.anio_ingreso = aspirante.getAnio_ingreso();
		this.trimestre_ingreso = aspirante.getTrimestre_ingreso();
		this.activo = aspirante.isActivo();
		if(aspirante.getEstado() != null)
			this.estado = new MEstadoAspirante(aspirante.getEstado());
		if(aspirante.getAdeudos()!= null) {
			this.adeudos = new ArrayList<MAdeudoAspirante>();
			for(EAdeudoAspirante adeudo : aspirante.getAdeudos()) {
				this.adeudos.add(new MAdeudoAspirante(adeudo));
			}
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
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

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_parterno() {
		return ap_paterno;
	}

	public void setAp_parterno(String ap_parterno) {
		this.ap_paterno = ap_parterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}

	public String getTrayectoria() {
		return trayectoria;
	}

	public void setTrayectoria(String trayectoria) {
		this.trayectoria = trayectoria;
	}

	public int getAnio_ingreso() {
		return anio_ingreso;
	}

	public void setAnio_ingreso(int anio_ingreso) {
		this.anio_ingreso = anio_ingreso;
	}

	public char getTrimestre_ingreso() {
		return trimestre_ingreso;
	}

	public void setTrimestre_ingreso(char trimestre_ingreso) {
		this.trimestre_ingreso = trimestre_ingreso;
	}

	public MEstadoAspirante getEstado() {
		return estado;
	}

	public void setEstado(MEstadoAspirante estado) {
		this.estado = estado;
	}

	public List<MAdeudoAspirante> getAdeudos() {
		return adeudos;
	}

	public void setAdeudos(List<MAdeudoAspirante> adeudos) {
		this.adeudos = adeudos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}
	
	
	
	
}
