import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { CyadService } from 'src/app/service/cyad.service';
import { DatamartHistorialTableComponent } from '../datamart-historial-table/datamart-historial-table.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent{

  @ViewChild(DatamartHistorialTableComponent) historial: any;

  id !: number;
  nombre !: string;
  escuela_procedencia !: string;
  trimestre_ingreso !: string
  trimestre_egreso !: string
  fecha_examen_disertacion !: string
  proyecto !: string
  participantes !: any[]; 

  constructor(private cyadService : CyadService) {}

  getIdSelect(id : number){
    this.historial.getIdSelect(id);//llamada al metodo en coponente de historial
    this.cyadService.getAlumnoDetailDatamart(id).subscribe({
      next:(res)=>{
        this.nombre = res.nombre + ' ' + res.ap_paterno + ' ' + res.ap_materno;
        this.escuela_procedencia = res.escuela_procedencia;
        this.trimestre_ingreso = res.trimestre_ingreso;
        this.trimestre_egreso = res.trimestre_egreso;
        this.fecha_examen_disertacion = res.fecha_examen_disertacion;
        this.proyecto = res.proyecto.titulo;
        this.participantes = res.proyecto.grupo.participantes;
      }
    });
  }

}
