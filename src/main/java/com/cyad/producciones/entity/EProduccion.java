package com.cyad.producciones.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * clase entidad que representa a una produccion
 * @author Salvador Solis Atenco
 *
 */
@Table(name="PRODUCCION")
@Entity
public class EProduccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="CLAVE_PRODUCTO")
	private String clave_producto;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="NOMBRE_ARCHIVO")
	private String nombre_archivo;
	
	@Column(name="FECHA_PUBLICACION")
	private String fecha_publicacion;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="LGAC")
	private String lgac;
	
	@Lob
	@Column(name="DOCUMENTO_PROBATORIO")
	private byte[] documento;
	
	@Column(name="ACTIVO")
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO")
	private ETipoProduccion tipo;
	
	@OneToMany(mappedBy="produccion", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<EGrupoAutores> autores;
	
	public EProduccion() {
		super();
		this.activo = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClave_producto() {
		return clave_producto;
	}

	public void setClave_producto(String clave_producto) {
		this.clave_producto = clave_producto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLgac() {
		return lgac;
	}

	public void setLgac(String lgac) {
		this.lgac = lgac;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public ETipoProduccion getTipo() {
		return tipo;
	}

	public void setTipo(ETipoProduccion tipo) {
		this.tipo = tipo;
	}

	public List<EGrupoAutores> getAutores() {
		return autores;
	}

	public void setAutores(List<EGrupoAutores> autores) {
		this.autores = autores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNombre_archivo() {
		return nombre_archivo;
	}

	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}
	
	
	
}
