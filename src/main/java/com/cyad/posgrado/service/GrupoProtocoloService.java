package com.cyad.posgrado.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cyad.posgrado.converter.ConvertidorGrupoProtocolo;
import com.cyad.posgrado.entity.EGrupoProtocolo;
import com.cyad.posgrado.model.MGrupoProtocolo;
import com.cyad.posgrado.repository.GrupoProtocoloRepository;
/**
 * implementacion de la interface IGrupoProtocoloService para establecer el servicio
 * @author Salvador Solis Atenco
 *
 */
@Service("servicio_grupo_protocolo")
public class GrupoProtocoloService implements IGrupoProtocoloService{
	
	@Autowired
	@Qualifier("repositorio_grupo_protocolo")
	private GrupoProtocoloRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor_grupo_protocolo")
	private ConvertidorGrupoProtocolo convertidor;
	
	private static final Log logger = LogFactory.getLog(GrupoProtocoloService.class);

	@Override
	public boolean crear(EGrupoProtocolo grupo) {
		try {
			logger.info("GRUPO PROTOCOLO CREADO");
			repositorio.save(grupo);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL CREAR GRUPO PROTOCOLO");
			return false;
		}
	}

	@Override
	public MGrupoProtocolo crear() {
		
		String clave = generarClave();
		
		while(search(clave)) {
			clave = generarClave();
		}
		
		EGrupoProtocolo grupo = new EGrupoProtocolo();
		grupo.setClave(clave);
		
		try {
			logger.info("GRUPO PROTOCOLO CREADO");
			return new MGrupoProtocolo(repositorio.save(grupo));
		}catch(Exception e){
			logger.error("ERROR AL CREAR GRUPO PROTOCOLO");
			return null;
		}
		
	}
	
	
	@Override
	public boolean actualizar(EGrupoProtocolo grupo) {
		try {
			logger.info("GRUPO PROTOCOLO ACTUALIZADO");
			repositorio.save(grupo);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL ACTUALIZAR GRUPO PROTOCOLO");
			return false;
		}
	}

	@Override
	public boolean borrar(long id) {
		try {	
			EGrupoProtocolo grupo = repositorio.findById(id);
			logger.info("GRUPO PROTOCOLO BORRADO");
			grupo.setActivo(false);
			//repositorio.delete(grupo);
			return true;
		}catch(Exception e){
			logger.error("ERROR AL BORRAR GRUPO PROTOCOLO");
			return false;
		}
	}

	@Override
	public List<MGrupoProtocolo> obtener() {
		try {
			return convertidor.convertirLista(repositorio.findAll());
		}catch(Exception e){
			logger.error("ERROR AL LISTAR GRUPO PROTOCOLO");
			return null;
		}
	}

	@Override
	public MGrupoProtocolo obtener(long id) {
		try {
			return new MGrupoProtocolo(repositorio.findById(id));
		}catch(Exception e){
			logger.error("ERROR AL LISTAR GRUPO PROTOCOLO");
			return null;
		}
	}

	@Override
	public boolean search(String clave) {
		try {	
			EGrupoProtocolo grupo = repositorio.findByClave(clave);
			if(grupo != null) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			logger.error("ERROR AL BUSCAR GRUPO PROTOCOLO" + e);
			return false;
		}
		
	}
	
	/**metodos para generar clave
	 */
	public String generarClave() {
		String cadena = "";
		
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890$%&.?";
        for (int x = 0; x < 10; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
	}
	
	public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

}
