import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-alumno-table',
  templateUrl: './alumno-table.component.html',
  styleUrls: ['./alumno-table.component.scss']
})
export class AlumnoTableComponent implements OnInit {
  displayColumns: String[] = ['id','matricula','nombre','ap_paterno','ap_materno','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService : CyadService, private router: Router) { }

  ngOnInit(): void {
    this.getAllAlumnos();
  }

  getAllAlumnos(){
    this.cyadService.getAlumnos().subscribe({
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

  addAlumno(){
    this.router.navigateByUrl('alumnoDetail');
  }

  getRow(row: any) {
    this.router.navigateByUrl(`alumnoDetail/${row.id}`);
  }

  deleteAlumno(id: number){
    this.cyadService.deleteAlumno(id).subscribe({
      next:(res)=>{
        if(res)
          alert("alumno Delete Successfully");
        this.getAllAlumnos();
      },
      error:(err)=>{
        alert("Error while deleting the alumno");
        console.error(err);
      }
    });
  }
}
