import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-datamart-historial-table',
  templateUrl: './datamart-historial-table.component.html',
  styleUrls: ['./datamart-historial-table.component.scss']
})
export class DatamartHistorialTableComponent {

  displayedColumns: String[] = ['id','estado','promedio','creditos','trimestre'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;
  
  nombreAlumno !: string;
  idAlumnoChild !: number;

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService : CyadService) { }

  getIdSelect(id : number){
    this.cyadService.getAlumnoDetailDatamart(id).subscribe({
      next:(res)=>{
        this.nombreAlumno = res.nombre + ' ' + res.ap_paterno + ' ' + res.ap_materno;
        this.dataSource = new MatTableDataSource(res.trayectoria.datos);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },error:(err)=>{
        console.error(err);
      }
    });
  }
}
