package com.cyad.aspirantes.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Esta clase representa a un aspirante a posgrado
 * @author Salvador Solis Atenco
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="ASPIRANTE")
@Entity
public class EAspirante implements Serializable{
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="CURP")
	private String curp;
	
	@Column(name="RFC")
	private String rfc;
	
	@Column(name="FECHA_NACIMIENTO")
	private String fecha_nacimiento;
	
	@Column(name="EDAD")
	private int edad;
	
	@Column(name="GENERO")
	private char genero;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="CORREO")
	private String correo;
	
	@Column(name="NACIONALIDAD")
	private String nacionalidad;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="AP_PATERNO")
	private String ap_paterno;
	
	@Column(name="AP_MATERNO")
	private String ap_materno;
	
	@Column(name="TRAYECTORIA")
	private String trayectoria;
	
	@Column(name="ANIO_INGRESO")
	private int anio_ingreso;
	
	@Column(name="TRIMESTRE_INGRESO")
	private char trimestre_ingreso;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTADO_ASPIRANTE")
	private EEstadoAspirante estado;
	
	@OneToMany(mappedBy = "aspirante", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<EAdeudoAspirante> adeudos;

	public EAspirante() {
		super();
		this.activo = true;
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

	public EEstadoAspirante getEstado() {
		return estado;
	}

	public void setEstado(EEstadoAspirante estado) {
		this.estado = estado;
	}

	public List<EAdeudoAspirante> getAdeudos() {
		return adeudos;
	}

	public void setAdeudos(List<EAdeudoAspirante> adeudos) {
		this.adeudos = adeudos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
