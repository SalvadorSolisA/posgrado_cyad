package com.cyad.producciones.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase entidad que representa a un autor
 * @author Salvador Solis Atenco
 *
 */
@Table(name="AUTOR")
@Entity
public class EAutor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="CLAVE_AUTOR")
	private String clave;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="AP_PATERNO")
	private String ap_paterno;
	
	@Column(name="AP_MATERNO")
	private String ap_materno;
	
	@Column(name="NACIONALIDAD")
	private String nacionalidad;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="FK_TIPO_CLAVE")
	private ETipoClave tipo_clave;
	
	@ManyToOne
	@JoinColumn(name="FK_TIPO_AUTOR")
	private ETipoAutor tipo_autor;
	
	@OneToMany(mappedBy="autor")
	@JsonIgnore
	private List<EGrupoAutores> grupo_autores;
	
	public EAutor() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public ETipoClave getTipo_clave() {
		return tipo_clave;
	}

	public void setTipo_clave(ETipoClave tipo_clave) {
		this.tipo_clave = tipo_clave;
	}

	public ETipoAutor getTipo_autor() {
		return tipo_autor;
	}

	public void setTipo_autor(ETipoAutor tipo_autor) {
		this.tipo_autor = tipo_autor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<EGrupoAutores> getAutores() {
		return grupo_autores;
	}

	public void setAutores(List<EGrupoAutores> autores) {
		this.grupo_autores = autores;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<EGrupoAutores> getGrupo_autores() {
		return grupo_autores;
	}

	public void setGrupo_autores(List<EGrupoAutores> grupo_autores) {
		this.grupo_autores = grupo_autores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
