package com.cyad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cyad.aspirantes.entity.EAdeudoAspirante;
import com.cyad.aspirantes.entity.EAspirante;
import com.cyad.aspirantes.entity.EEstadoAspirante;
import com.cyad.aspirantes.model.MAdeudoAspirante;
import com.cyad.aspirantes.model.MAspirante;
import com.cyad.aspirantes.model.MEstadoAspirante;
import com.cyad.aspirantes.service.AdeudoAspiranteService;
import com.cyad.aspirantes.service.AspiranteService;
import com.cyad.aspirantes.service.EstadoAspiranteService;
import com.cyad.datamart.service.AlumnoServiceDatamart;
import com.cyad.posgrado.entity.EAdeudo;
import com.cyad.posgrado.entity.EAlumno;
import com.cyad.posgrado.entity.EAreaConcentracion;
import com.cyad.posgrado.entity.EAreaInvestigacion;
import com.cyad.posgrado.entity.ECorreo;
import com.cyad.posgrado.entity.EDatosAcademicos;
import com.cyad.posgrado.entity.EDatosIngreso;
import com.cyad.posgrado.entity.EDepartamento;
import com.cyad.posgrado.entity.EDireccion;
import com.cyad.posgrado.entity.EDivision;
import com.cyad.posgrado.entity.EEstadoAcademico;
import com.cyad.posgrado.entity.EGrupoProtocolo;
import com.cyad.posgrado.entity.EInstitucion;
import com.cyad.posgrado.entity.ENivel;
import com.cyad.posgrado.entity.EParticipante;
import com.cyad.posgrado.entity.EPlan;
import com.cyad.posgrado.entity.EProfesor;
import com.cyad.posgrado.entity.EProyecto;
import com.cyad.posgrado.entity.ERol;
import com.cyad.posgrado.entity.ETipoParticipante;
import com.cyad.posgrado.entity.ETipoProyecto;
import com.cyad.posgrado.entity.ETrimestre;
import com.cyad.posgrado.model.MAdeudo;
import com.cyad.posgrado.model.MAlumno;
import com.cyad.posgrado.model.MAreaConcentracion;
import com.cyad.posgrado.model.MAreaInvestigacion;
import com.cyad.posgrado.model.MCorreo;
import com.cyad.posgrado.model.MDatosAcademicos;
import com.cyad.posgrado.model.MDatosIngreso;
import com.cyad.posgrado.model.MDepartamento;
import com.cyad.posgrado.model.MDireccion;
import com.cyad.posgrado.model.MDivision;
import com.cyad.posgrado.model.MEstadoAcademico;
import com.cyad.posgrado.model.MGrupoProtocolo;
import com.cyad.posgrado.model.MInstitucion;
import com.cyad.posgrado.model.MNivel;
import com.cyad.posgrado.model.MParticipante;
import com.cyad.posgrado.model.MPlan;
import com.cyad.posgrado.model.MProfesor;
import com.cyad.posgrado.model.MProyecto;
import com.cyad.posgrado.model.MRol;
import com.cyad.posgrado.model.MTipoParticipante;
import com.cyad.posgrado.model.MTipoProyecto;
import com.cyad.posgrado.model.MTrimestre;
import com.cyad.posgrado.service.AdeudoService;
import com.cyad.posgrado.service.AlumnoService;
import com.cyad.posgrado.service.AreaConcentracionService;
import com.cyad.posgrado.service.AreaInvestigacionService;
import com.cyad.posgrado.service.CorreoService;
import com.cyad.posgrado.service.DatosAcademicosService;
import com.cyad.posgrado.service.DatosIngresoService;
import com.cyad.posgrado.service.DepartamentoService;
import com.cyad.posgrado.service.DireccionService;
import com.cyad.posgrado.service.DivisionService;
import com.cyad.posgrado.service.EstadoAcademicoService;
import com.cyad.posgrado.service.GrupoProtocoloService;
import com.cyad.posgrado.service.InstitucionService;
import com.cyad.posgrado.service.NivelService;
import com.cyad.posgrado.service.ParticipanteService;
import com.cyad.posgrado.service.PlanService;
import com.cyad.posgrado.service.ProfesorService;
import com.cyad.posgrado.service.ProyectoService;
import com.cyad.posgrado.service.RolService;
import com.cyad.posgrado.service.TipoParticipanteService;
import com.cyad.posgrado.service.TipoProyectoService;
import com.cyad.posgrado.service.TrimestreService;
import com.cyad.producciones.entity.EAutor;
import com.cyad.producciones.entity.EGrupoAutores;
import com.cyad.producciones.entity.EOrdenAutor;
import com.cyad.producciones.entity.EProduccion;
import com.cyad.producciones.entity.ETipoAutor;
import com.cyad.producciones.entity.ETipoClave;
import com.cyad.producciones.entity.ETipoProduccion;
import com.cyad.producciones.model.MAutor;
import com.cyad.producciones.model.MGrupoAutores;
import com.cyad.producciones.model.MOrdenAutor;
import com.cyad.producciones.model.MProduccion;
import com.cyad.producciones.model.MTipoAutor;
import com.cyad.producciones.model.MTipoClave;
import com.cyad.producciones.model.MTipoProduccion;
import com.cyad.producciones.service.AutorService;
import com.cyad.producciones.service.GrupoAutoresService;
import com.cyad.producciones.service.OrdenAutorService;
import com.cyad.producciones.service.ProduccionService;
import com.cyad.producciones.service.TipoAutorService;
import com.cyad.producciones.service.TipoClaveService;
import com.cyad.producciones.service.TipoProduccionService;
/**
 * Esta clase es el controlador principal REST almacena las rutas que se utilizan para atender las peticiones HTTP
 * @author Salvador Solis Atenco
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")// permisos CORS a la ruta por defecto de la apliccion de Angular
@RequestMapping("/v1")
public class ControlRest {
	@Autowired
	@Qualifier("servicio_profesor")
	ProfesorService service_prof;

	@Autowired
	@Qualifier("servicio_departamento")
	DepartamentoService service_depto;

	@Autowired
	@Qualifier("servicio_division")
	DivisionService service_div;

	@Autowired
	@Qualifier("servicio_institucion")
	InstitucionService service_ins;

	@Autowired
	@Qualifier("servicio_area_investigacion")
	AreaInvestigacionService servicio_area_investigacion;

	@Autowired
	@Qualifier("servicio_alumno")
	AlumnoService service_alum;

	@Autowired
	@Qualifier("servicio_direccion")
	DireccionService service_direc;

	@Autowired
	@Qualifier("servicio_correo")
	CorreoService service_correo;

	@Autowired
	@Qualifier("servicio_area_concentracion")
	AreaConcentracionService servicio_area_concentracion;

	@Autowired
	@Qualifier("servicio_datos_academicos")
	DatosAcademicosService service_datos;

	@Autowired
	@Qualifier("servicio_estado_academico")
	EstadoAcademicoService service_estado;

	@Autowired
	@Qualifier("servicio_plan")
	PlanService service_plan;

	@Autowired
	@Qualifier("servicio_nivel")
	NivelService service_nivel;

	@Autowired
	@Qualifier("servicio_proyecto")
	ProyectoService service_proyecto;

	@Autowired
	@Qualifier("servicio_tipo_proyecto")
	TipoProyectoService service_tipo_proyecto;

	@Autowired
	@Qualifier("servicio_grupo_protocolo")
	GrupoProtocoloService service_grupo_protocolo;

	@Autowired
	@Qualifier("servicio_participante")
	ParticipanteService service_participante;

	@Autowired
	@Qualifier("servicio_tipo_participante")
	TipoParticipanteService service_tipo_participante;

	@Autowired
	@Qualifier("servicio_rol")
	RolService service_rol;

	@Autowired
	@Qualifier("servicio_datos_ingreso")
	DatosIngresoService servicio_datos_ingreso;

	@Autowired
	@Qualifier("servicio_adeudos")
	AdeudoService servicio_adeudos;

	@Autowired
	@Qualifier("servicio_aspirante")
	AspiranteService servicio_aspirante;

	@Autowired
	@Qualifier("servicio_adeudo_aspirante")
	AdeudoAspiranteService servicio_adeudo_aspirante;

	@Autowired
	@Qualifier("servicio_estado_aspirante")
	EstadoAspiranteService servicio_estado_aspirante;

	@Autowired
	@Qualifier("servicio_produccion")
	ProduccionService servicio_produccion;

	@Autowired
	@Qualifier("servicio_tipo_produccion")
	TipoProduccionService servicio_tipo_produccion;

	@Autowired
	@Qualifier("servicio_grupo_autores")
	GrupoAutoresService servicio_grupo_autores;

	@Autowired
	@Qualifier("servicio_orden_autor")
	OrdenAutorService servicio_orden_autor;

	@Autowired
	@Qualifier("servicio_autor")
	AutorService servicio_autor;

	@Autowired
	@Qualifier("servicio_tipo_autor")
	TipoAutorService servicio_tipo_autor;

	@Autowired
	@Qualifier("servicio_tipo_clave")
	TipoClaveService servicio_tipo_clave;
	
	@Autowired
	@Qualifier("servicio_trimestres")
	TrimestreService servicio_trimestres;

	// ------Profesor
	// obtener
	@GetMapping("/profesores")
	public List<MProfesor> obtenerProfesores() {
		return service_prof.obtener();
	}

	// obtener
	@GetMapping("/profesor/{id}")
	public MProfesor obtenerProfesores(@PathVariable("id") long id) {
		return service_prof.obtener(id);
	}

	// insertar
	@PostMapping("/profesor")
	public boolean agregarProfesor(@RequestBody @Validated EProfesor prof) {
		return service_prof.crear(prof);
	}

	// actualizar
	@PutMapping("/profesorUpdate")
	public boolean actualizarProfesor(@RequestBody @Validated EProfesor prof) {
		return service_prof.actualizar(prof);
	}

	// borrar
	@DeleteMapping("/profesor")
	public boolean borrarProfesor(@RequestParam("id") long id) {
		return service_prof.borrar(id);
	}

	// ------Departamento

	// obtener
	@GetMapping("/departamentos")
	public List<MDepartamento> obtenerDepartamentos() {
		return service_depto.obtener();
	}

	// obtener
	@GetMapping("/departamento/{id}")
	public MDepartamento obtenerDepartamento(@PathVariable("id") long id) {
		return service_depto.obtener(id);
	}
		
	// insertar
	@PostMapping("/departamento")
	public boolean agregarDepartamento(@RequestBody @Validated EDepartamento depto) {
		return service_depto.crear(depto);
	}

	// actualizar
	@PutMapping("/departamentoUpdate")
	public boolean actualizarDepartamento(@RequestBody @Validated EDepartamento depto) {
		return service_depto.actualizar(depto);
	}

	// borrar
	@DeleteMapping("/departamento")
	public boolean borrarDepartamento(@RequestParam("id") long id) {
		return service_depto.borrar(id);
	}

	// ------Division

	// obtener
	@GetMapping("/divisiones")
	public List<MDivision> obtenerDivisiones() {
		return service_div.obtener();
	}

	// insertar
	@PostMapping("/division")
	public boolean agregarDivision(@RequestBody @Validated EDivision div) {
		return service_div.crear(div);
	}

	// actualizar
	@PutMapping("/divisionUpdate")
	public boolean actualizarDivision(@RequestBody @Validated EDivision div) {
		return service_div.actualizar(div);
	}

	// borrar
	@DeleteMapping("/division")
	public boolean borrarDivision(@RequestParam("id") long id) {
		return service_div.borrar(id);
	}

	// ------Institucion

	// obtener
	@GetMapping("/instituciones")
	public List<MInstitucion> obtenerInstituciones() {
		return service_ins.obtener();
	}

	// obtener
	@GetMapping("/institucion/{id}")
	public MInstitucion obtenerInstituciones(@PathVariable("id") long id) {
		return service_ins.obtener(id);
	}

	// insertar
	@PostMapping("/institucion")
	public boolean agregarInstitucion(@RequestBody @Validated EInstitucion inst) {
		return service_ins.crear(inst);
	}

	// actualizar
	@PutMapping("/institucionUpdate")
	public boolean actualizarDivision(@RequestBody @Validated EInstitucion inst) {
		return service_ins.actualizar(inst);
	}

	// borrar
	@DeleteMapping("/institucion")
	public boolean borrarinstitucion(@RequestParam("id") long id) {
		return service_ins.borrar(id);
	}

	// ------Area Investigacion

	// obtener
	@GetMapping("/areas-investigacion")
	public List<MAreaInvestigacion> obtenerAreasInvestigacion() {
		return servicio_area_investigacion.obtener();
	}

	// obtener
	@GetMapping("/area-investigacion/{id}")
	public MAreaInvestigacion obtenerAreaInvestigacion(@PathVariable("id") long id) {
		return servicio_area_investigacion.obtener(id);
	}

	// insertar
	@PostMapping("/area-investigacion")
	public boolean agregarAreaInvestigacion(@RequestBody @Validated EAreaInvestigacion area) {
		return servicio_area_investigacion.crear(area);
	}

	// actualizar
	@PutMapping("/area-investigacionUpdate")
	public boolean actualizarAreaInvestigacion(@RequestBody @Validated EAreaInvestigacion area) {
		return servicio_area_investigacion.actualizar(area);
	}

	// borrar
	@DeleteMapping("/area-investigacion")
	public boolean borrarAreaInvestigacion(@RequestParam("id") long id) {
		return servicio_area_investigacion.borrar(id);
	}

	// ------Alumno
	// obtener
	@GetMapping("/alumnos")
	public List<MAlumno> obtenerAlumnos() {
		return service_alum.obtener();
	}

	// obtener
	@GetMapping("/alumno/{id}")
	public MAlumno obtenerAlumnos(@PathVariable("id") long id) {
		return service_alum.obtener(id);
	}

	// insertar
	@PostMapping("/alumno")
	public long agregarAlumno(@RequestBody @Validated EAlumno alumn) {
		return service_alum.crear(alumn);
	}

	// actualizar
	@PutMapping("/alumnoUpdate")
	public boolean actualizarAlumno(@RequestBody @Validated EAlumno alumn) {
		return service_alum.actualizar(alumn);
	}

	// borrar
	@DeleteMapping("/alumno")
	public boolean borrarAlumno(@RequestParam("id") long id) {
		return service_alum.borrar(id);
	}

	// ------Direccion
	// obtener
	@GetMapping("/direcciones")
	public List<MDireccion> obtenerDirecciones() {
		return service_direc.obtener();
	}

	// obtener
	@GetMapping("/direccion/{id}")
	public MDireccion obtenerDirecciones(@PathVariable("id") long id) {
		return service_direc.obtener(id);
	}
	
	// obtener
	@GetMapping("/direccion-alumno/{id}")
	public MDireccion obtenerDireccionAlumno(@PathVariable("id") long id) {
		return service_direc.obtenerDireccionAlumno(id);
	}

	// insertar
	@PostMapping("/direccion")
	public boolean agregarDireccion(@RequestBody @Validated EDireccion direc) {
		return service_direc.crear(direc);
	}

	// actualizar
	@PutMapping("/direccionUpdate")
	public boolean actualizarDireccion(@RequestBody @Validated EDireccion direc) {
		return service_direc.actualizar(direc);
	}

	// borrar
	@DeleteMapping("/direccion")
	public boolean borrarDireccion(@RequestParam("id") long id) {
		return service_direc.borrar(id);
	}
	
	// borrar
	@DeleteMapping("/direccion-coincidir")
	public boolean borrarDireccion(@RequestParam("calle") String calle, @RequestParam("numero") int numero, @RequestParam("id") long id) {
		return service_direc.borrar_coincidir(calle, numero, id);
	}

	// ------Correo
	// obtener
	@GetMapping("/correos")
	public List<MCorreo> obtenerCorreos() {
		return service_correo.obtener();
	}

	// obtener
	@GetMapping("/correos/{id}")
	public MCorreo obtenerCorreos(@PathVariable("id") long id) {
		return service_correo.obtener(id);
	}
	
	// obtener
	@GetMapping("/correos-alumno/{id}")
	public List<MCorreo> obtenerCorreosAlumno(@PathVariable("id") long id) {
		return service_correo.obtenerByAlumno(id);
	}

	// insertar
	@PostMapping("/correo")
	public boolean agregarDireccion(@RequestBody @Validated ECorreo correo) {
		return service_correo.crear(correo);
	}

	// actualizar
	@PutMapping("/correoUpdate")
	public boolean actualizarDireccion(@RequestBody @Validated ECorreo correo) {
		return service_correo.actualizar(correo);
	}

	// borrar
	@DeleteMapping("/correo")
	public boolean borrarCorreo(@RequestParam("id") long id) {
		return service_correo.borrar(id);
	}
	
	// borrar
	@DeleteMapping("/correo-coincidir")
	public boolean borrarCorreo(@RequestParam("correo") String correo, @RequestParam("tipo") String tipo, @RequestParam("id") long id) {
		return service_correo.borrar_coincidir(correo, tipo, id);
	}

	// ------Datos Academicos
	// obtener
	@GetMapping("/datos")
	public List<MDatosAcademicos> obtenerDatosAcademicos() {
		return service_datos.obtener();
	}

	// obtener
	@GetMapping("/datos/{id}")
	public MDatosAcademicos obtenerDatosAcademicos(@PathVariable("id") long id) {
		return service_datos.obtener(id);
	}

	// insertar
	@PostMapping("/dato")
	public boolean agregarDatosAcademicos(@RequestBody @Validated EDatosAcademicos datos) {
		return service_datos.crear(datos);
	}

	// actualizar
	@PutMapping("/datoUpdate")
	public boolean actualizarDatosAcademicos(@RequestBody @Validated EDatosAcademicos datos) {
		return service_datos.actualizar(datos);
	}

	// borrar
	@DeleteMapping("/dato")
	public boolean borrarDatosAcademicos(@RequestParam("id") long id) {
		return service_datos.borrar(id);
	}

	// ------Estado Academico
	// obtener
	@GetMapping("/estados")
	public List<MEstadoAcademico> obtenerEstadoAcademico() {
		return service_estado.obtener();
	}

	// obtener
	@GetMapping("/estado/{id}")
	public MEstadoAcademico obtenerEstadoAcademico(@PathVariable("id") long id) {
		return service_estado.obtener(id);
	}

	// insertar
	@PostMapping("/estado")
	public boolean agregarEstadoAcademico(@RequestBody @Validated EEstadoAcademico estado) {
		return service_estado.crear(estado);
	}

	// actualizar
	@PutMapping("/estadoUpdate")
	public boolean actualizarEstadoAcademico(@RequestBody @Validated EEstadoAcademico estado) {
		return service_estado.actualizar(estado);
	}

	// borrar
	@DeleteMapping("/estado")
	public boolean borrarEstadoAcademico(@RequestParam("id") long id) {
		return service_estado.borrar(id);
	}

	// ------Area Concentracion
	// obtener
	@GetMapping("/areas-concentracion")
	public List<MAreaConcentracion> obtenerAreasConcentracion() {
		return servicio_area_concentracion.obtener();
	}

	// obtener
	@GetMapping("/area-concentracion/{id}")
	public MAreaConcentracion obtenerAreaConcentracion(@PathVariable("id") long id) {
		return servicio_area_concentracion.obtener(id);
	}

	// insertar
	@PostMapping("/area-concentracion")
	public boolean agregarAreaConcentracion(@RequestBody @Validated EAreaConcentracion area) {
		return servicio_area_concentracion.crear(area);
	}

	// actualizar
	@PutMapping("/area-concentracionUpdate")
	public boolean actualizarAreaConcentracion(@RequestBody @Validated EAreaConcentracion area) {
		return servicio_area_concentracion.actualizar(area);
	}

	// borrar
	@DeleteMapping("/area-concentracion")
	public boolean borrarAreaConcentracion(@RequestParam("id") long id) {
		return servicio_area_concentracion.borrar(id);
	}

	// ------Plan

	// obtener
	@GetMapping("/planes")
	public List<MPlan> obtenerPlanes() {
		return service_plan.obtener();
	}

	// obtener
	@GetMapping("/plan/{id}")
	public MPlan obtenerPlanes(@PathVariable("id") long id) {
		return service_plan.obtener(id);
	}

	// insertar
	@PostMapping("/plan")
	public boolean agregarPlan(@RequestBody @Validated EPlan plan) {
		return service_plan.crear(plan);
	}

	// actualizar
	@PutMapping("/planUpdate")
	public boolean actualizarPlan(@RequestBody @Validated EPlan plan) {
		return service_plan.actualizar(plan);
	}

	// borrar
	@DeleteMapping("/plan")
	public boolean borrarPlan(@RequestParam("id") long id) {
		return service_plan.borrar(id);
	}

	// ------Nivel

	// obtener
	@GetMapping("/niveles")
	public List<MNivel> obtenerNiveles() {
		return service_nivel.obtener();
	}

	// obtener
	@GetMapping("/nivel/{id}")
	public MNivel obtenerNiveles(@PathVariable("id") long id) {
		return service_nivel.obtener(id);
	}

	// insertar
	@PostMapping("/nivel")
	public boolean agregarNivel(@RequestBody @Validated ENivel nivel) {
		return service_nivel.crear(nivel);
	}

	// actualizar
	@PutMapping("/nivelUpdate")
	public boolean actualizarNivel(@RequestBody @Validated ENivel nivel) {
		return service_nivel.actualizar(nivel);
	}

	// borrar
	@DeleteMapping("/nivel")
	public boolean borrarNivel(@RequestParam("id") long id) {
		return service_nivel.borrar(id);
	}

	// ------Proyecto

	// obtener
	@GetMapping("/proyectos")
	public List<MProyecto> obtenerProyectos() {
		return service_proyecto.obtener();
	}

	// obtener
	@GetMapping("/proyecto/{id}")
	public MProyecto obtenerProyectos(@PathVariable("id") long id) {
		return service_proyecto.obtener(id);
	}

	// insertar
	@PostMapping("/proyecto")
	public boolean agregarProyecto(@RequestBody @Validated EProyecto proyecto) {
		return service_proyecto.crear(proyecto);
	}

	// actualizar
	@PutMapping("/proyectoUpdate")
	public boolean actualizarProyecto(@RequestBody @Validated EProyecto proyecto) {
		return service_proyecto.actualizar(proyecto);
	}

	// borrar
	@DeleteMapping("/proyecto")
	public boolean borrarProyecto(@RequestParam("id") long id) {
		return service_proyecto.borrar(id);
	}

	// ------Tipo Proyecto

	// obtener
	@GetMapping("/tiposProyectos")
	public List<MTipoProyecto> obtenerTipoProyectos() {
		return service_tipo_proyecto.obtener();
	}

	// obtener
	@GetMapping("/tipoProyecto/{id}")
	public MTipoProyecto obtenerTipoProyectos(@PathVariable("id") long id) {
		return service_tipo_proyecto.obtener(id);
	}

	// insertar
	@PostMapping("/tipoProyecto")
	public boolean agregarTipoProyecto(@RequestBody @Validated ETipoProyecto t_proyecto) {
		return service_tipo_proyecto.crear(t_proyecto);
	}

	// actualizar
	@PutMapping("/tipoProyectoUpdate")
	public boolean actualizarTipoProyecto(@RequestBody @Validated ETipoProyecto t_proyecto) {
		return service_tipo_proyecto.actualizar(t_proyecto);
	}

	// borrar
	@DeleteMapping("/tipoProyecto")
	public boolean borrarTipoProyecto(@RequestParam("id") long id) {
		return service_tipo_proyecto.borrar(id);
	}

	// ------Grupo protocolo

	// obtener
	@GetMapping("/gruposProtocolo")
	public List<MGrupoProtocolo> obtenerGruposProtocolo() {
		return service_grupo_protocolo.obtener();
	}

	@GetMapping("/grupoProtocolo/{id}")
	public MGrupoProtocolo obtenerGruposProtocolo(@PathVariable("id") long id) {
		return service_grupo_protocolo.obtener(id);
	}
	
	// insertar
	@PostMapping("/newgrupoProtocolo")
	public MGrupoProtocolo crearGrupoProtocolo() {
		return service_grupo_protocolo.crear();
	}

	// insertar
	@PostMapping("/grupoProtocolo")
	public boolean agregarGrupoProtocolo(@RequestBody @Validated EGrupoProtocolo g_protocolo) {
		return service_grupo_protocolo.crear(g_protocolo);
	}

	// actualizar
	@PutMapping("/grupoProtocoloUpdate")
	public boolean actualizarGrupoProtocolo(@RequestBody @Validated EGrupoProtocolo g_protocolo) {
		return service_grupo_protocolo.actualizar(g_protocolo);
	}

	// borrar
	@DeleteMapping("/grupoProtocolo")
	public boolean borrarGrupoProtocolo(@RequestParam("id") long id) {
		return service_grupo_protocolo.borrar(id);
	}

	// ------Participantes

	// obtener
	@GetMapping("/participantes")
	public List<MParticipante> obtenerParticipantes() {
		return service_participante.obtener();
	}

	// obtener
	@GetMapping("/participante/{id}")
	public MParticipante obtenerParticipantes(@PathVariable("id") long id) {
		return service_participante.obtener(id);
	}

	// insertar
	@PostMapping("/participante")
	public boolean agregarParticipante(@RequestBody @Validated EParticipante participante) {
		return service_participante.crear(participante);
	}

	// actualizar
	@PutMapping("/participanteUpdate")
	public boolean actualizarParticipante(@RequestBody @Validated EParticipante participante) {
		return service_participante.actualizar(participante);
	}

	// borrar
	@DeleteMapping("/participante")
	public boolean borrarParticipante(@RequestParam("id") long id) {
		return service_participante.borrar(id);
	}

	// ------Tipo de Participantes

	// obtener
	@GetMapping("/tiposParticipantes")
	public List<MTipoParticipante> obtenerTipoParticipantes() {
		return service_tipo_participante.obtener();
	}

	// obtener
	@GetMapping("/tiposParticipantes/{id}")
	public MTipoParticipante obtenerTipoParticipantes(@PathVariable("id") long id) {
		return service_tipo_participante.obtener(id);
	}

	// insertar
	@PostMapping("/tipoParticipante")
	public boolean agregarTipoParticipante(@RequestBody @Validated ETipoParticipante tparticipante) {
		return service_tipo_participante.crear(tparticipante);
	}

	// actualizar
	@PutMapping("/tipoParticipanteUpdate")
	public boolean actualizarTipoParticipante(@RequestBody @Validated ETipoParticipante tparticipante) {
		return service_tipo_participante.actualizar(tparticipante);
	}

	// borrar
	@DeleteMapping("/tipoParticipante")
	public boolean borrarTipoParticipante(@RequestParam("id") long id) {
		return service_tipo_participante.borrar(id);
	}

	// ------Rol de Participantes

	// obtener
	@GetMapping("/rolParticipantes")
	public List<MRol> obtenerRolParticipantes() {
		return service_rol.obtener();
	}

	// obtener
	@GetMapping("/rolParticipantes/{id}")
	public MRol obtenerRolParticipantes(@PathVariable("id") long id) {
		return service_rol.obtener(id);
	}

	// insertar
	@PostMapping("/rolParticipante")
	public boolean agregarRolParticipante(@RequestBody @Validated ERol rol) {
		return service_rol.crear(rol);
	}

	// actualizar
	@PutMapping("/rolParticipanteUpdate")
	public boolean actualizarRolParticipante(@RequestBody @Validated ERol rol) {
		return service_rol.actualizar(rol);
	}

	// borrar
	@DeleteMapping("/rolParticipante")
	public boolean borrarRolParticipante(@RequestParam("id") long id) {
		return service_rol.borrar(id);
	}

	// ------Datos de Ingreso

	// obtener
	@GetMapping("/datosIngresos")
	public List<MDatosIngreso> obtenerDatosIngresos() {
		return servicio_datos_ingreso.obtener();
	}

	// obtener
	@GetMapping("/datosIngreso/{id}")
	public MDatosIngreso obtenerDatosIngresos(@PathVariable("id") long id) {
		return servicio_datos_ingreso.obtener(id);
	}

	// insertar
	@PostMapping("/datosIngreso")
	public boolean agregarDatosIngreso(@RequestBody @Validated EDatosIngreso datos) {
		return servicio_datos_ingreso.crear(datos);
	}

	// actualizar
	@PutMapping("/datosIngresoUpdate")
	public boolean actualizarDatosIngreso(@RequestBody @Validated EDatosIngreso datos) {
		return servicio_datos_ingreso.actualizar(datos);
	}

	// borrar
	@DeleteMapping("/datosIngreso")
	public boolean borrarDatosIngreso(@RequestParam("id") long id) {
		return servicio_datos_ingreso.borrar(id);
	}

	// ------ Adeudos

	// obtener
	@GetMapping("/adeudos")
	public List<MAdeudo> obtenerAdeudos() {
		return servicio_adeudos.obtener();
	}

	// insertar
	@PostMapping("/adeudo")
	public boolean agregarAdeudo(@RequestBody @Validated EAdeudo adeudo) {
		return servicio_adeudos.crear(adeudo);
	}

	// actualizar
	@PutMapping("/adeudoUpdate")
	public boolean actualizarAdeudo(@RequestBody @Validated EAdeudo adeudo) {
		return servicio_adeudos.actualizar(adeudo);
	}

	// borrar
	@DeleteMapping("/adeudo/{id}")
	public boolean borrarAdeudo(@PathVariable("id") long id) {
		return servicio_adeudos.borrar(id);
	}

	// ------ Aspirante

	// obtener
	@GetMapping("/aspirantes")
	public List<MAspirante> obtenerAspirantes() {
		return servicio_aspirante.obtener();
	}
	
	@GetMapping("/aspirante/{id}")
	public MAspirante obtenerAspirantes(@PathVariable("id") long id) {
		return servicio_aspirante.obtener(id);
	}

	// insertar
	@PostMapping("/aspirante")
	public boolean agregarAspirante(@RequestBody @Validated EAspirante aspirante) {
		return servicio_aspirante.crear(aspirante);
	}

	// actualizar
	@PutMapping("/aspiranteUpdate")
	public boolean actualizarAspirante(@RequestBody @Validated EAspirante aspirante) {
		return servicio_aspirante.actualizar(aspirante);
	}

	// borrar
	@DeleteMapping("/aspirante")
	public boolean borrarAspirante(@RequestParam("id") long id) {
		return servicio_aspirante.borrar(id);
	}

	// ------ Estado Aspirante

	// obtener
	@GetMapping("/estados-aspirantes")
	public List<MEstadoAspirante> obtenerEstadosAspirantes() {
		return servicio_estado_aspirante.obtener();
	}
	
	// obtener
	@GetMapping("/estado-aspirante/{id}")
	public MEstadoAspirante obtenerEstadoAspirante(@PathVariable("id") long id) {
		return servicio_estado_aspirante.obtener(id);
	}

	// insertar
	@PostMapping("/estado-aspirante")
	public boolean agregarEstadoAspirante(@RequestBody @Validated EEstadoAspirante estado) {
		return servicio_estado_aspirante.crear(estado);
	}

	// actualizar
	@PutMapping("/estado-aspiranteUpdate")
	public boolean actualizarEstadoAspirante(@RequestBody @Validated EEstadoAspirante estado) {
		return servicio_estado_aspirante.actualizar(estado);
	}

	// borrar
	@DeleteMapping("/estado-aspirante")
	public boolean borrarEstadoAspirante(@RequestParam("id") long id) {
		return servicio_estado_aspirante.borrar(id);
	}

	// ------ Adeudo Aspirante

	// obtener
	@GetMapping("/adeudosAspirantes")
	public List<MAdeudoAspirante> obtenerAdeudoAspirantes() {
		return servicio_adeudo_aspirante.obtener();
	}

	// insertar
	@PutMapping("/adeudoAspirante")
	public boolean agregarAdeudoAspirante(@RequestBody @Validated EAdeudoAspirante adeudo_aspirante) {
		return servicio_adeudo_aspirante.crear(adeudo_aspirante);
	}

	// actualizar
	@PostMapping("/adeudoAspiranteUpdate")
	public boolean actualizarAdeudoAspirante(@RequestBody @Validated EAdeudoAspirante adeudo_aspirante) {
		return servicio_adeudo_aspirante.actualizar(adeudo_aspirante);
	}

	// borrar
	@DeleteMapping("/adeudoAspirante/{id}")
	public boolean borrarAdeudoAspirante(@PathVariable("id") long id) {
		return servicio_adeudo_aspirante.borrar(id);
	}

	// ------Producciones
	// obtener
	@GetMapping("/producciones")
	public List<MProduccion> obtenerProducciones() {
		return servicio_produccion.obtener();
	}

	// obtener
	@GetMapping("/produccion/{id}")
	public MProduccion obtenerProducciones(@PathVariable("id") long id) {
		return servicio_produccion.obtener(id);
	}
	
	// obtener
	@GetMapping("/produccion-download/{id}")
	public boolean descargarDocumentoProbatorio(@PathVariable("id") long id) {
		return servicio_produccion.descargar(id);
	}

	// insertar
	@PostMapping("/produccion")
	public MProduccion agregarProduccion(@RequestBody @Validated EProduccion produccion) {
		return servicio_produccion.crear(produccion);
	}

	// insertar
	@PostMapping("/produccion-upload")
	public long agregarDocumentoProbatorio(@RequestParam("id") long id, @RequestParam("file") MultipartFile file) {
		return servicio_produccion.cargarDocumento(id, file);
	}

	// actualizar
	@PutMapping("/produccionUpdate")
	public boolean actualizarProduccion(@RequestBody @Validated EProduccion produccion) {
		return servicio_produccion.actualizar(produccion);
	}

	// borrar
	@DeleteMapping("/produccion")
	public boolean borrarProduccion(@RequestParam("id") long id) {
		return servicio_produccion.borrar(id);
	}

	// ------Tipo Producciones

	// obtener
	@GetMapping("/tipoProducciones")
	public List<MTipoProduccion> obtenerTipoProducciones() {
		return servicio_tipo_produccion.obtener();
	}

	// obtener
	@GetMapping("/tipoProduccion/{id}")
	public MTipoProduccion obtenerTipoProducciones(@PathVariable("id") long id) {
		return servicio_tipo_produccion.obtener(id);
	}

	// insertar
	@PostMapping("/tipoProduccion")
	public boolean agregarTipoProduccion(@RequestBody @Validated ETipoProduccion tipo_produccion) {
		return servicio_tipo_produccion.crear(tipo_produccion);
	}

	// actualizar
	@PutMapping("/tipoProduccionUpdate")
	public boolean actualizarTipoProduccion(@RequestBody @Validated ETipoProduccion tipo_produccion) {
		return servicio_tipo_produccion.actualizar(tipo_produccion);
	}

	// borrar
	@DeleteMapping("/tipoProduccion")
	public boolean borrarTipoProduccion(@RequestParam("id") long id) {
		return servicio_tipo_produccion.borrar(id);
	}

	// ------Listas Autores

	// obtener
	@GetMapping("/allGruposAutores")
	public List<MGrupoAutores> obtenerGrupoAutores() {
		return servicio_grupo_autores.obtener();
	}

	// obtener
	@GetMapping("/allGruposAutores/{id}")
	public MGrupoAutores obtenerGrupoAutores(@PathVariable("id") long id) {
		return servicio_grupo_autores.obtener(id);
	}

	// insertar
	@PostMapping("/grupoAutores")
	public boolean agregarGrupoAutores(@RequestBody @Validated EGrupoAutores autores) {
		return servicio_grupo_autores.crear(autores);
	}

	// actualizar
	@PutMapping("/grupoAutoresUpdate")
	public boolean actualizarGrupoAutores(@RequestBody @Validated EGrupoAutores autores) {
		return servicio_grupo_autores.actualizar(autores);
	}

	// borrar
	@DeleteMapping("/grupoAutores")
	public boolean borrarGrupoAutores(@RequestParam("id") long id) {
		return servicio_grupo_autores.borrar(id);
	}

	// ------Orden Autor

	// obtener
	@GetMapping("/ordenAutores")
	public List<MOrdenAutor> obtenerOrdenAutor() {
		return servicio_orden_autor.obtener();
	}

	// obtener
	@GetMapping("/ordenAutor/{id}")
	public MOrdenAutor obtenerOrdenAutor(@PathVariable("id") long id) {
		return servicio_orden_autor.obtener(id);
	}

	// insertar
	@PostMapping("/ordenAutor")
	public boolean agregarOrdenAutor(@RequestBody @Validated EOrdenAutor orden) {
		return servicio_orden_autor.crear(orden);
	}

	// actualizar
	@PutMapping("/ordenAutorUpdate")
	public boolean actualizarOrdenAutor(@RequestBody @Validated EOrdenAutor orden) {
		return servicio_orden_autor.actualizar(orden);
	}

	// borrar
	@DeleteMapping("/ordenAutor")
	public boolean borrarOrdenAutor(@RequestParam("id") long id) {
		return servicio_orden_autor.borrar(id);
	}

	// ------Autor

	// obtener
	@GetMapping("/autores")
	public List<MAutor> obtenerAllAutores() {
		return servicio_autor.obtener();
	}

	// obtener
	@GetMapping("/autor/{id}")
	public MAutor obtenerDetallesAutor(@PathVariable("id") long id) {
		return servicio_autor.obtener(id);
	}

	// insertar
	@PostMapping("/autor")
	public boolean agregarAutor(@RequestBody @Validated EAutor autor) {
		return servicio_autor.crear(autor);
	}

	// actualizar
	@PutMapping("/autorUpdate")
	public boolean actualizarAutor(@RequestBody @Validated EAutor autor) {
		return servicio_autor.actualizar(autor);
	}

	// borrar
	@DeleteMapping("/autor")
	public boolean borrarAutor(@RequestParam("id") long id) {
		return servicio_autor.borrar(id);
	}

	// ------Tipo Autor

	// obtener
	@GetMapping("/tipoAutores")
	public List<MTipoAutor> obtenerTiposTipoAutor() {
		return servicio_tipo_autor.obtener();
	}

	// obtener
	@GetMapping("/tipoAutores/{id}")
	public MTipoAutor obtenerTiposTipoAutor(@PathVariable("id") long id) {
		return servicio_tipo_autor.obtener(id);
	}

	// insertar
	@PostMapping("/tipoAutor")
	public boolean agregarTipoAutor(@RequestBody @Validated ETipoAutor tipo_autor) {
		return servicio_tipo_autor.crear(tipo_autor);
	}

	// actualizar
	@PutMapping("/tipoAutorUpdate")
	public boolean actualizarTipoAutor(@RequestBody @Validated ETipoAutor tipo_autor) {
		return servicio_tipo_autor.actualizar(tipo_autor);
	}

	// borrar
	@DeleteMapping("/tipoAutor")
	public boolean borrarTipoAutor(@RequestParam("id") long id) {
		return servicio_tipo_autor.borrar(id);
	}

	// ------Tipo Clave Autor

	// obtener
	@GetMapping("/tipoClaveAutores")
	public List<MTipoClave> obtenerTiposClaveAutor() {
		return servicio_tipo_clave.obtener();
	}

	// obtener
	@GetMapping("/tipoClaveAutores/{id}")
	public MTipoClave obtenerTiposClaveAutor(@PathVariable("id") long id) {
		return servicio_tipo_clave.obtener(id);
	}

	// insertar
	@PostMapping("/tipoClaveAutor")
	public boolean agregarTipoClaveAutor(@RequestBody @Validated ETipoClave tipo_clave) {
		return servicio_tipo_clave.crear(tipo_clave);
	}

	// actualizar
	@PutMapping("/tipoClaveAutorUpdate")
	public boolean actualizarTipoClaveAutor(@RequestBody @Validated ETipoClave tipo_clave) {
		return servicio_tipo_clave.actualizar(tipo_clave);
	}

	// borrar
	@DeleteMapping("/tipoClaveAutor")
	public boolean borrarTipoClaveAutor(@RequestParam("id") long id) {
		return servicio_tipo_clave.borrar(id);
	}
	
	// ------Trimestress

	// obtener
	@GetMapping("/trimestres")
	public List<MTrimestre> obtenerTrimestres() {
		return servicio_trimestres.obtener();
	}

	// obtener
	@GetMapping("/trimestre/{id}")
	public MTrimestre obtenerTrimestre(@PathVariable("id") long id) {
		return servicio_trimestres.obtener(id);
	}

	// insertar
	@PostMapping("/trimestre")
	public boolean agregarTrimestre(@RequestBody @Validated ETrimestre trimestre) {
		return servicio_trimestres.crear(trimestre);
	}

	// actualizar
	@PutMapping("/trimestreUpdate")
	public boolean actualizarTrimestre(@RequestBody @Validated ETrimestre trimestre) {
		return servicio_trimestres.actualizar(trimestre);
	}

	// borrar
	@DeleteMapping("/trimestre")
	public boolean borrarTrimestre(@RequestParam("id") long id) {
		return servicio_trimestres.borrar(id);
	}
	
	//datamart ------------------------------------------------------------------------------------------------------------------------
	
	@Autowired
	@Qualifier("data_alumno_service")
	AlumnoServiceDatamart servicio_alumno_data;
	
	// --------------------------------------------alumnos
	// obtener
	@GetMapping("/datamart/alumnos")
	public List<com.cyad.datamart.model.MAlumnoDatamart> obtenerAlumnosDatamart() {
		return servicio_alumno_data.obtener();
	}
	
	// obtener
	@GetMapping("/datamart/alumno/{id}")
	public com.cyad.datamart.model.MAlumnoDatamart obtenerAlumnoDetailDatamart(@PathVariable("id") long id) {
		return servicio_alumno_data.obtener(id);
	}
	
	
}
