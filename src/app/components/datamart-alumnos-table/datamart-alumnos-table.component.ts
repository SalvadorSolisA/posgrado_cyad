import { Component, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-datamart-alumnos-table',
  templateUrl: './datamart-alumnos-table.component.html',
  styleUrls: ['./datamart-alumnos-table.component.scss']
})
export class DatamartAlumnosTableComponent implements OnInit {

  displayColumns: String[] = ['id','nombre','ap_paterno','ap_materno','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  @Output() private idEmitido = new EventEmitter<number>();

  //---datos de alumno
  alumno_nombre !: String;

  constructor(private cyadService :CyadService, private router : Router) { }

  ngOnInit(): void {
    this.getAllAlumnos();
  }

  getAllAlumnos(){
    this.cyadService.getAlumnosDatamart().subscribe({
      next:(res)=>{
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      error:(err)=>{
        console.error(err);
      }
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  getRow(row: any) {
    this.idEmitido.emit(row.id);
  }

  viewUltimoTrimestre(id: number){
    if(id > 0){
      this.cyadService.getAlumnoDetailDatamart(id).subscribe({
        next:(res)=>{
          this.alumno_nombre = res.nombre + res.ap_paterno + res.ap_materno;
        }
      });
    }
  }
}
