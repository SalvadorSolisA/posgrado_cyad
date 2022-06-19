package com.cyad.producciones.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cyad.producciones.converter.ConvertidorProduccion;
import com.cyad.producciones.entity.EProduccion;
import com.cyad.producciones.model.MProduccion;
import com.cyad.producciones.repository.IProduccionRepository;
/**
 * implementacion de la interface IProduccionService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_produccion")
public class ProduccionService implements IProduccionService {

	@Autowired
	@Qualifier("repositorio_produccion")
	private IProduccionRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_producciones")
	private ConvertidorProduccion convertidor;
	
	private static final Log logger = LogFactory.getLog(ProduccionService.class);

	@Override
	public MProduccion crear(EProduccion produccion) {
		try {
			logger.info("PRODUCCION CREADA");
			repositorio.save(produccion);
			return new MProduccion(produccion);
		}catch(Exception e){
			logger.info("ERROR AL CREAR PRODUCCION  " + e);
			return null;
		}
	}

	@Override
	public long cargarDocumento(long id, MultipartFile file) {
		try {
			
			EProduccion produccion = repositorio.findById(id);
			produccion.setDocumento(file.getBytes());
			
			logger.info("PRODUCCION CREADA");
			repositorio.save(produccion);
			return produccion.getId();
		}catch(Exception e){
			logger.info("ERROR AL CREAR PRODUCCION  " + e);
			return -1;
		}
	}
	
	@Override
	public boolean descargar(long id) {
		EProduccion documento = repositorio.findById(id);
		
		//convierte el arreglo de bytes a inputstream
		InputStream is = new ByteArrayInputStream(documento.getDocumento());
		
		//creacion de archivo
		File file = new File(System.getProperty("user.home")+File.separator+"Documents",documento.getNombre_archivo()+".pdf");
		
		//buffer de salida
		BufferedInputStream in = new BufferedInputStream(is);
		
		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			
			byte[] bytes = new byte[8096];
			int len = 0;
			
			while( (len = in.read(bytes)) > 0) {
				out.write(bytes, 0, len);
			}
			
			out.flush();
			out.close();
			in.close();
			logger.info("EL DOCUMENTO SE DESCARGO DE FORMA EXITOSA");
			return true;
		} catch (FileNotFoundException e) {
			logger.error("ERROR AL DESCARGAR DOCUMENTO " + e);
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			logger.error("ERROR AL DESCARGAR DOCUMENTO " + e);
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public boolean actualizar(EProduccion produccion) {
		try {
			logger.info("PRODUCCION ACTUALIZADA");
			repositorio.save(produccion);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL ACTUALIZAR PRODUCCION " + e);
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			EProduccion produccion = repositorio.findById(id);
			logger.info("PRODUCCION BORRADA");
			produccion.setActivo(false);
			repositorio.save(produccion);
			//repositorio.delete(produccion);
			return true;
		}catch(Exception e){
			logger.info("ERROR AL BORRAR PRODUCCION  " + e);
			return false;
		}
	}

	@Override
	public List<MProduccion> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.info("ERROR AL LISTAR PRODUCCIONES " + e);
			return null;
		}
	}

	@Override
	public MProduccion obtener(long id) {
		try {
			return new MProduccion(repositorio.findById(id));
		}catch(Exception e){
			logger.info("ERROR AL LISTAR PRODUCCIONES " + e);
			return null;
		}
	}
	
	

}
