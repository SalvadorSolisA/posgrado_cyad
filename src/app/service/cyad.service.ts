import { HttpClient, HttpRequest } from '@angular/common/http';
import { EventEmitter, Injectable, Output } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Alumno } from '../interfaces/alumno';
import { AreaConcentracion } from '../interfaces/area-concentracion';
import { AreaInvestigacion } from '../interfaces/areaInvestiongacion';
import { Aspirante } from '../interfaces/aspirante';
import { Autor } from '../interfaces/autor';
import { Correo } from '../interfaces/correo';
import { DatosAcademicos } from '../interfaces/datos-academicos';
import { DatosIngreso } from '../interfaces/datos-ingreso';
import { Departamento } from '../interfaces/departamento';
import { Direccion } from '../interfaces/direccion';
import { Division } from '../interfaces/division';
import { EstadoAcademico } from '../interfaces/estado-academico';
import { EstadoAspirante } from '../interfaces/estado-aspirante';
import { GrupoAutores } from '../interfaces/grupo-autores';
import { GrupoProtocolo } from '../interfaces/grupo-protocolo';
import { Institucion } from '../interfaces/institucion';
import { Nivel } from '../interfaces/nivel';
import { OrdenAutor } from '../interfaces/orden-autor';
import { Participante } from '../interfaces/participante';
import { PlanEstudios } from '../interfaces/plan-estudios';
import { Produccion } from '../interfaces/produccion';
import { Profesor } from '../interfaces/profesor';
import { Proyecto } from '../interfaces/proyecto';
import { TipoClaveAutor } from '../interfaces/tipo-clave-autor';
import { TipoProduccion } from '../interfaces/tipo-produccion';
import { TipoProyecto } from '../interfaces/tipo-proyecto';
import { Trimestre } from '../interfaces/trimestre';

@Injectable({
  providedIn: 'root'
})
export class CyadService {

  private baseUrl = environment.baseUrl;

  @Output() disparadorData:EventEmitter<any> = new EventEmitter();
  
  constructor(private http : HttpClient) { }

  //REST Alumnos
  public getAlumnos(): Observable<any>{
    return this.http.get(this.baseUrl+'/alumnos');
  }

  public getAlumnoDetail(index: number){
    return this.http.get<Alumno>(this.baseUrl+`/alumno/${index}`);
  }

  public postAlumno(alumn: any){
    return this.http.post<number>(this.baseUrl+'/alumno',alumn);
  }

  public putAlumno(alumn: Alumno){
    return this.http.put<Alumno>(this.baseUrl+`/alumnoUpdate`,alumn);
  }

  public deleteAlumno(id: number){
    return this.http.delete<Alumno>(this.baseUrl+`/alumno/?id=${id}`);
  }

  //REST Datos academicos
  public getAllDatosAcademicos():Observable<any>{
    return this.http.get( this.baseUrl + '/datos');
  }

  public getDatosAcademicos(index : number){
    return this.http.get<any>( this.baseUrl + `/datos/${index}`);
  }

  public postDatosAcademicos(datos: any){
    return this.http.post<DatosAcademicos>(this.baseUrl+'/dato',datos);
  }

  public putDatosAcademicos(datos: any){
    return this.http.put<DatosAcademicos>(this.baseUrl+`/datoUpdate`,datos);
  }

  public deleteDatosAcademicos(id: number){
    return this.http.delete<DatosAcademicos>(this.baseUrl+`/dato/?id=${id}`);
  }

  //REST Datos de ingreso
  public getAllDatosIngreso():Observable<any>{
    return this.http.get( this.baseUrl + '/datosIngresos');
  }

  public getDatosIngreso(index : number){
    return this.http.get<any>( this.baseUrl + `/datosIngreso/${index}`);
  }

  public postDatosIngreso(datos: any){
    return this.http.post<DatosIngreso>(this.baseUrl+'/datosIngreso',datos);
  }

  public putDatosIngreso(datos: any){
    return this.http.put<DatosIngreso>(this.baseUrl+`/datosIngresoUpdate`,datos);
  }

  public deleteDatosIngreso(id: number){
    return this.http.delete<DatosIngreso>(this.baseUrl+`/datosIngreso/?id=${id}`);
  }

  //REST Correos
  public getAllCorreos():Observable<any>{
    return this.http.get( this.baseUrl + '/correos');
  }

  public getCorreosAlumno(index : number){
    return this.http.get<any>( this.baseUrl + `/correos-alumno/${index}`);
  }

  public postCorreo(correo: any){
    return this.http.post<Correo>(this.baseUrl+'/correo',correo);
  }

  public putCorreo(correo: any){
    return this.http.put<Correo>(this.baseUrl+`/correoUpdate`,correo);
  }

  public deleteCorreo(id: number){
    return this.http.delete<Correo>(this.baseUrl+`/correo/?id=${id}`);
  }

  public deleteCorreoCoincidir( correo : string, tipo : string, id : number){
    console.log('data ',correo, tipo)
    return this.http.delete<Correo>(this.baseUrl+`/correo-coincidir?correo=${correo}&tipo=${tipo}&id=${id}`);
  }
  
  //REST Profesor
  public getProfesores():Observable<any>{
    return this.http.get( this.baseUrl + '/profesores');
  }

  public getProfesorDetails(index : number){
    return this.http.get<any>( this.baseUrl + `/profesor/${index}`);
  }

  public postProfesor(profe: any){
    return this.http.post<Profesor>(this.baseUrl+'/profesor',profe);
  }

  public putProfesor(profe: any){
    return this.http.put<Profesor>(this.baseUrl+`/profesorUpdate`,profe);
  }

  public deleteProfesor(id: number){
    return this.http.delete<Profesor>(this.baseUrl+`/profesor/?id=${id}`);
  }

  //REST producciones
  public getProducciones():Observable<any>{
    return this.http.get( this.baseUrl + '/producciones'  )
  }

  public getProduccionDetail(index: number){
    return this.http.get<Produccion>( this.baseUrl + `/produccion/${index}`);
  }

  public postProduccion(prod: any){
    return this.http.post<Produccion>(this.baseUrl+'/produccion',prod);
  }

  public putProduccion(prod: any){
    return this.http.put<Produccion>(this.baseUrl+`/produccionUpdate`,prod);
  }

  public deleteProduccion(id: number){
    return this.http.delete<Produccion>(this.baseUrl+`/produccion/?id=${id}`);
  }

  public upload(produccion : any, file : File, grupo_autores : any[]) {
    //auxiliar
    let product : Produccion;
    //registrando datos de la produccion
    this.http.post<Produccion>(this.baseUrl+'/produccion',produccion).subscribe({
      next:(res)=>{
        product = res;

        // creando formdata
        const formData = new FormData();
        //almacena el archivo como "file"
        formData.append("file", file);
        // haciendo la petición para cargararchivo en bd
        this.http.post<number>(`${this.baseUrl}/produccion-upload?id=${product.id}`,formData).subscribe({
          next:(res)=>{
            //actualizando el id
            for (let i = 0; i < grupo_autores.length; i++) {
              grupo_autores[i].produccion.id = res;
              this.postGruposAutores(grupo_autores[i]).subscribe({
                next:(res)=>{
                  console.log('agregando al grupo de autores',res);
                }
              });//post grupo de autores
            }
          }
        });//post archivo
      }
    });//post produccion
  }

  //REST proyectos
  public getProyectos():Observable<any>{
    return this.http.get( this.baseUrl + '/proyectos'  )
  }

  public getProyectoDetail(index: number){
    return this.http.get<Proyecto>( this.baseUrl + `/proyecto/${index}`);
  }

  public postProyecto(proyect: any){
    return this.http.post<Proyecto>(this.baseUrl+'/proyecto',proyect);
  }

  public putProyecto(proyect: any){
    return this.http.put<Proyecto>(this.baseUrl+`/proyectoUpdate`,proyect);
  }

  public deleteProyecto(id: number){
    return this.http.delete<Proyecto>(this.baseUrl+`/proyecto/?id=${id}`);
  }

  //REST tipos de proyectos
  public getTiposProyectos():Observable<any>{
    return this.http.get( this.baseUrl + '/tiposProyectos'  )
  }

  public getTipoProyectoDetail(index: number){
    return this.http.get<TipoProyecto>( this.baseUrl + `/tipoProyecto/${index}`);
  }

  public postTipoProyecto(tipo: TipoProyecto){
    return this.http.post<TipoProyecto>(this.baseUrl+'/tipoProyecto',tipo);
  }

  public putTipoProyecto(tipo: TipoProyecto){
    return this.http.put<TipoProyecto>(this.baseUrl+`/tipoProyectoUpdate`,tipo);
  }

  public deleteTipoProyecto(id: number){
    return this.http.delete<TipoProyecto>(this.baseUrl+`/tipoProyecto/?id=${id}`);
  }

  //REST grupo protocolo
  public getGruposProtocolos():Observable<any>{
    return this.http.get( this.baseUrl + '/gruposProtocolo'  )
  }

  public getGrupoProtocolo(index: number){
    return this.http.get<GrupoProtocolo>( this.baseUrl + `/grupoProtocolo/${index}`);
  }

  public postGrupoProtocoloClave(){
    return this.http.post<GrupoProtocolo>(this.baseUrl+'/newgrupoProtocolo',null);
  }

  public postGrupoProtocolo(grupo: any){
    return this.http.post<GrupoProtocolo>(this.baseUrl+'/grupoProtocolo',grupo);
  }

  public putGrupoProtocolo(grupo: any){
    return this.http.put<GrupoProtocolo>(this.baseUrl+`/grupoProtocoloUpdate`,grupo);
  }

  public deleteGrupoProtocolo(id: number){
    return this.http.delete<GrupoProtocolo>(this.baseUrl+`/grupoProtocolo/?id=${id}`);
  }

  //REST Participantes del grupo de protocolo
  public getParticipantes():Observable<any>{
    return this.http.get( this.baseUrl + '/participantes'  )
  }

  public getParticipante(index: number){
    return this.http.get<Participante>( this.baseUrl + `/participante/${index}`);
  }

  public postParticipante(participante: any){
    return this.http.post<Participante>(this.baseUrl+'/participante',participante);
  }

  public putParticipante(participante: any){
    return this.http.put<Participante>(this.baseUrl+`/participanteUpdate`,participante);
  }

  public deleteParticipante(id: number){
    return this.http.delete<Participante>(this.baseUrl+`/participante/?id=${id}`);
  }

  //REST areas de concentracion
  public getAreasConcentracion(): Observable<any>{
    return this.http.get( this.baseUrl+'/areas-concentracion');
  }

  public getAreaConcentracionDetail(index: number){
    return this.http.get<AreaConcentracion>( this.baseUrl + `/area-concentracion/${index}`);
  }

  public postAreaConcentracion(area: AreaConcentracion){
    return this.http.post<AreaConcentracion>(this.baseUrl+'/area-concentracion',area);
  }

  public putAreaConcentracion(area: AreaConcentracion){
    return this.http.put<AreaConcentracion>(this.baseUrl+`/area-concentracionUpdate`,area);
  }

  public deleteAreaConcentracion(id: number){
    return this.http.delete<AreaConcentracion>(this.baseUrl+`/area-concentracion/?id=${id}`);
  }

  //REST Area de investigacion  
  public getAreasInvestigacion(): Observable<any>{
    return this.http.get<AreaInvestigacion>(this.baseUrl+'/areas-investigacion');
  }

  public getAreaInvestigacionDetail(index: number){
    return this.http.get<AreaInvestigacion>( this.baseUrl + `/area-investigacion/${index}`);
  }

  public postAreaInvestigacion(area: AreaInvestigacion){
    return this.http.post<AreaInvestigacion>(this.baseUrl+'/area-investigacion',area);
  }

  public putAreaInvestigacion(area: AreaInvestigacion){
    return this.http.put<AreaInvestigacion>(this.baseUrl+`/area-investigacionUpdate/`,area);
  }

  public deleteAreaInvestigacion(id: number){
    return this.http.delete<AreaInvestigacion>(this.baseUrl+`/area-investigacion?id=${id}`);
  }

  //REST Departamentos  
  public getDepartamentos(): Observable<any>{
    return this.http.get<Departamento>(this.baseUrl+'/departamentos');
  }

  public getDepartamentoDetail(index: number){
    return this.http.get<Departamento>( this.baseUrl + `/departamento/${index}`);
  }

  public postDepartamento(depto: Departamento){
    return this.http.post<Departamento>(this.baseUrl+'/departamento',depto);
  }

  public putDepartamento(depto: Departamento){
    return this.http.put<Departamento>(this.baseUrl+`/departamentoUpdate/`,depto);
  }

  public deleteDepartamento(id: number){
    return this.http.delete<Departamento>(this.baseUrl+`/departamento?id=${id}`);
  }

  //REST Divisiones  
  public getDivisiones(): Observable<any>{
    return this.http.get<Division>(this.baseUrl+'/divisiones');
  }

  public getDivisionDetail(index: number){
    return this.http.get<Division>( this.baseUrl + `/division/${index}`);
  }

  public postDivision(division: Division){
    return this.http.post<Division>(this.baseUrl+'/division',division);
  }

  public putDivision(division: Division){
    return this.http.put<Division>(this.baseUrl+`/divisionUpdate/`,division);
  }

  public deleteDivision(id: number){
    return this.http.delete<Division>(this.baseUrl+`/division?id=${id}`);
  }

  //REST Estado Academico  
  public getEstadosAcademicos(): Observable<any>{
    return this.http.get<EstadoAcademico>(this.baseUrl+'/estados');
  }

  public getEstadoAcademicoDetail(index: number){
    return this.http.get<EstadoAcademico>( this.baseUrl + `/estado/${index}`);
  }

  public postEstadosAcademico(estado: EstadoAcademico){
    return this.http.post<EstadoAcademico>(this.baseUrl+'/estado',estado);
  }

  public putEstadosAcademico(estado: EstadoAcademico){
    return this.http.put<EstadoAcademico>(this.baseUrl+`/estadoUpdate/`,estado);
  }

  public deleteEstadosAcademico(id: number){
    return this.http.delete<EstadoAcademico>(this.baseUrl+`/estado?id=${id}`);
  }

  //REST Estado Aspirante  
  public getEstadosAspirantes(): Observable<any>{
    return this.http.get<EstadoAspirante>(this.baseUrl+'/estados-aspirantes');
  }

  public getEstadoAspiranteDetail(index: number){
    return this.http.get<EstadoAspirante>( this.baseUrl + `/estado-aspirante/${index}`);
  }

  public postEstadoAspirante(estado: EstadoAspirante){
    return this.http.post<EstadoAspirante>(this.baseUrl+'/estado-aspirante',estado);
  }

  public putEstadoAspirante(estado: EstadoAspirante){
    return this.http.put<EstadoAspirante>(this.baseUrl+`/estado-aspiranteUpdate/`,estado);
  }

  public deleteEstadoAspirante(id: number){
    return this.http.delete<EstadoAspirante>(this.baseUrl+`/estado-aspirante?id=${id}`);
  }

  //REST Insituciones procedencia  
  public getInstituciones(): Observable<any>{
    return this.http.get<Institucion>(this.baseUrl+'/instituciones');
  }

  public getInstitucionDetail(index: number){
    return this.http.get<Institucion>( this.baseUrl + `/institucion/${index}`);
  }

  public postInstitucion(inst: Institucion){
    return this.http.post<Institucion>(this.baseUrl+'/institucion',inst);
  }

  public putInstitucion(inst: Institucion){
    return this.http.put<Institucion>(this.baseUrl+`/institucionUpdate/`,inst);
  }

  public deleteInstitucion(id: number){
    return this.http.delete<Institucion>(this.baseUrl+`/institucion?id=${id}`);
  }

  //REST LGAC  
  public getLGAC(): Observable<any> {
    return this.http.get<Institucion>(this.baseUrl + '/instituciones');
  }

  public getLGACDetail(index: number) {
    return this.http.get<Institucion>(this.baseUrl + `/institucion/${index}`);
  }

  public postLGAC(inst: Institucion) {
    return this.http.post<Institucion>(this.baseUrl + '/institucion', inst);
  }

  public putLGAC(inst: Institucion) {
    return this.http.put<Institucion>(this.baseUrl + `/institucionUpdate/`, inst);
  }

  public deleteLGAC(id: number) {
    return this.http.delete<Institucion>(this.baseUrl + `/institucion?id=${id}`);
  }

  //REST Nivel  
  public getNiveles(): Observable<any> {
    return this.http.get<Nivel>(this.baseUrl + '/niveles');
  }

  public getNivelDetail(index: number) {
    return this.http.get<Nivel>(this.baseUrl + `/nivel/${index}`);
  }

  public postNivel(nivel: Nivel) {
    return this.http.post<Nivel>(this.baseUrl + '/nivel', nivel);
  }

  public putNivel(nivel: Nivel) {
    return this.http.put<Nivel>(this.baseUrl + `/nivelUpdate/`, nivel);
  }

  public deleteNivel(id: number) {
    return this.http.delete<Nivel>(this.baseUrl + `/nivel?id=${id}`);
  }

  //REST Plan Estudios  
  public getPlanes(): Observable<any> {
    return this.http.get<PlanEstudios>(this.baseUrl + '/planes');
  }

  public getPlanDetail(index: number) {
    return this.http.get<PlanEstudios>(this.baseUrl + `/plan/${index}`);
  }

  public postPlan(plan: PlanEstudios) {
    return this.http.post<PlanEstudios>(this.baseUrl + '/plan', plan);
  }

  public putPlan(plan: PlanEstudios) {
    return this.http.put<PlanEstudios>(this.baseUrl + `/planUpdate/`, plan);
  }

  public deletePlan(id: number) {
    return this.http.delete<PlanEstudios>(this.baseUrl + `/plan?id=${id}`);
  }

  //REST Direccion

  public getDireccionAlumno(index : number) {
    return this.http.get<Direccion>(this.baseUrl + `/direccion-alumno/${index}` );
  }

  public postDireccion(direc: any) {
    return this.http.post<Direccion>(this.baseUrl + '/direccion', direc);
  }

  public putDireccion(direc: any) {
    return this.http.put<Direccion>(this.baseUrl + `/direccionUpdate/`, direc);
  }

  public deleteDireccion(id: number) {
    return this.http.delete<Direccion>(this.baseUrl + `/direccion?id=${id}`);
  }

  public deleteDireccionCoincidir(calle : string,numero : number, id: number) {
    return this.http.delete<Direccion>(this.baseUrl + `/direccion-coincidir?calle=${calle}&numero=${numero}&id=${id}`);
  }

  //REST Aspirantes

  public getAspirantes(): Observable<any> {
    return this.http.get<Aspirante>(this.baseUrl + '/aspirantes');
  }

  public getAspiranteDetail(index: number) {
    return this.http.get<Aspirante>(this.baseUrl + `/aspirante/${index}`);
  }

  public postAspirante(aspirante: any) {
    return this.http.post<Aspirante>(this.baseUrl + '/aspirante', aspirante);
  }

  public putAspirante(aspirante: Aspirante) {
    return this.http.put<Aspirante>(this.baseUrl + `/aspiranteUpdate/`, aspirante);
  }

  public deleteAspirante(id: number) {
    return this.http.delete<Aspirante>(this.baseUrl + `/aspirante?id=${id}`);
  }

  //REST Autores

  public getAutores(): Observable<any> {
    return this.http.get<Autor>(this.baseUrl + '/autores');
  }

  public getAutorDetail(index: number) {
    return this.http.get<Autor>(this.baseUrl + `/autor/${index}`);
  }

  public postAutor(autor: any) {
    return this.http.post<Autor>(this.baseUrl + '/autor', autor);
  }

  public putAutor(autor: any) {
    return this.http.put<Autor>(this.baseUrl + `/autorUpdate/`, autor);
  }

  public deleteAutor(id: number) {
    return this.http.delete<Autor>(this.baseUrl + `/autor?id=${id}`);
  }

  //REST grupo Autores

  public getGruposAutores(): Observable<any> {
    return this.http.get<GrupoAutores>(this.baseUrl + '/allGruposAutores');
  }

  public getGruposAutoresDetail(index: number) {
    return this.http.get<GrupoAutores>(this.baseUrl + `/allGruposAutores/${index}`);
  }

  public postGruposAutores(g_autor: any) {
    return this.http.post<GrupoAutores>(this.baseUrl + '/grupoAutores', g_autor);
  }

  public putGruposAutores(g_autor: GrupoAutores) {
    return this.http.put<GrupoAutores>(this.baseUrl + `/grupoAutoresUpdate/`, g_autor);
  }

  public deleteGruposAutores(id: number) {
    return this.http.delete<GrupoAutores>(this.baseUrl + `/grupoAutores?id=${id}`);
  }

  //REST Orden autor

  public getOrdenAutores(): Observable<any> {
    return this.http.get<OrdenAutor>(this.baseUrl + '/ordenAutores');
  }

  public getOrdenAutorDetail(index: number) {
    return this.http.get<OrdenAutor>(this.baseUrl + `/ordenAutor/${index}`);
  }

  public postOrdenAutor(orden: any) {
    return this.http.post<OrdenAutor>(this.baseUrl + '/ordenAutor', orden);
  }

  public putOrdenAutor(orden: OrdenAutor) {
    return this.http.put<OrdenAutor>(this.baseUrl + `/ordenAutorUpdate/`, orden);
  }

  public deleteOrdenAutor(id: number) {
    return this.http.delete<OrdenAutor>(this.baseUrl + `/ordenAutor?id=${id}`);
  }

  //REST tipos de clave autor

  public getTiposClavesAutor(): Observable<any> {
    return this.http.get<TipoClaveAutor>(this.baseUrl + '/tipoClaveAutores');
  }

  public getTipoClaveAutor(index: number) {
    return this.http.get<TipoClaveAutor>(this.baseUrl + `/tipoClaveAutores/${index}`);
  }

  public postTipoClaveAutor(tipo: any) {
    return this.http.post<TipoClaveAutor>(this.baseUrl + '/tipoClaveAutor', tipo);
  }

  public putTipoClaveAutor(tipo: TipoClaveAutor) {
    return this.http.put<TipoClaveAutor>(this.baseUrl + `/tipoClaveAutorUpdate/`, tipo);
  }

  public deleteTipoClaveAutor(id: number) {
    return this.http.delete<TipoClaveAutor>(this.baseUrl + `/tipoClaveAutor?id=${id}`);
  }

  //REST trimestres

  public getTrimestres(): Observable<any> {
    return this.http.get<Trimestre>(this.baseUrl + '/trimestres');
  }

  public getTrimestre(index: number) {
    return this.http.get<Trimestre>(this.baseUrl + `/trimestre/${index}`);
  }

  public postTrimestre(trimestre: any) {
    return this.http.post<Trimestre>(this.baseUrl + '/trimestre', trimestre);
  }

  public putTrimestre(trimestre: any) {
    return this.http.put<Trimestre>(this.baseUrl + `/trimestreUpdate/`, trimestre);
  }

  public deleteTrimestre(id: number) {
    return this.http.delete<Trimestre>(this.baseUrl + `/trimestre?id=${id}`);
  }

  //REST tipo produccion

  public getTiposProduccion(): Observable<any> {
    return this.http.get<TipoProduccion>(this.baseUrl + '/tipoProducciones');
  }

  public getTipoProduccion(index: number) {
    return this.http.get<TipoProduccion>(this.baseUrl + `/tipoProduccion/${index}`);
  }

  public postTipoProduccion(tipo: any) {
    return this.http.post<TipoProduccion>(this.baseUrl + '/tipoProduccion', tipo);
  }

  public putTipoProduccion(tipo: Autor) {
    return this.http.put<TipoProduccion>(this.baseUrl + `/tipoProduccionUpdate/`, tipo);
  }

  public deleteTipoProduccion(id: number) {
    return this.http.delete<TipoProduccion>(this.baseUrl + `/tipoProduccion?id=${id}`);
  }

  public upload2( file : File): Observable<any> {
    // creando formdata
    const formData = new FormData();

    //almacena el archivo como "file"
    formData.append("file", file);

    // http post request over api
    // con formData as req
    const req = new HttpRequest('POST',`${this.baseUrl}/produccion`,formData,{
      reportProgress:true,
      responseType: 'json'
    });
    return this.http.request(req);
  }

  ///REST Datamart
  public getAlumnosDatamart(): Observable<any> {
    return this.http.get<any>(this.baseUrl + '/datamart/alumnos');
  }

  public getAlumnoDetailDatamart(index: number) {
    return this.http.get<any>(this.baseUrl + `/datamart/alumno/${index}`);
  }

}
