import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Alumno } from '../interfaces/alumno';
import { AreaConcentracion } from '../interfaces/AreaConcentracion';
import { Produccion } from '../interfaces/produccion';

@Injectable({
  providedIn: 'root'
})
export class CyadService {

  baseUrl = "http://localhost:9898/v1"//"https://a203f053-e95a-4622-9ad4-1fb5435d9a5e.mock.pstmn.io";//environment.baseUrl;
  url = environment.baseUrl; 

  constructor(private http : HttpClient) { }

  public getAlumnos(): Observable<any>{
    return this.http.get(this.baseUrl+'/alumnos');
  }

  public getAlumnoDetail(index: number){
    return this.http.get<Alumno>(this.baseUrl+`/alumno/${index}`);
  }
  
  public getProfesores():Observable<any>{
    return this.http.get( this.baseUrl + '/profesores');
  }

  public getProfesorDetails(index : number){
    return this.http.get<any>( this.baseUrl + `/profesor/${index}`);
  }
  
  public getProducciones():Observable<any>{
    return this.http.get( this.baseUrl + '/producciones'  )
  }

  public getProduccionDetail(index: number){
    return this.http.get<Produccion>( this.baseUrl + `/producciones/${index}`);
  }

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
    return this.http.put<AreaConcentracion>(this.baseUrl+`/area-concentracionUpdate/`,area);
  }

  public deleteAreaConcentracion(area: AreaConcentracion){
    return this.http.delete<AreaConcentracion>(this.baseUrl+`/area-concentracion/?id=${area.id}`);
  }
}
