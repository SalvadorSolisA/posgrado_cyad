import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Alumno } from 'src/app/interfaces/alumno';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-alumno-table',
  templateUrl: './alumno-table.component.html',
  styleUrls: ['./alumno-table.component.scss']
})
export class AlumnoTableComponent implements OnInit {
  displayColumns: String[] = ['id','matricula','nombre','ap_paterno','ap_materno','curp'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;

  constructor(private cyadService : CyadService, private router: Router) { }

  ngOnInit(): void {
    this.getAlumnos();
  }

  getAlumnos(){

    let alumnosData;

    this.cyadService.getAlumnos().subscribe(
      res=>{
        res.forEach((alumno: Alumno) => {
          this.resultsLength++;
          alumnosData = {
            id: alumno.id,
            matricula: alumno.matricula,
            nombre: alumno.nombre,
            ap_paterno: alumno.ap_paterno,
            ap_materno: alumno.ap_materno,
            curp: alumno.curp
          };
          this.data.push(alumnosData);
          this.dataSource = new MatTableDataSource<any>(this.data);
          this.dataSource.paginator = this.paginator;
        });
        console.log(res);
      }
    );

  }
    
    applyFilter(event : Event) {
      const filterValue = (event.target as HTMLInputElement).value;
      this.dataSource.filter = filterValue.trim().toLowerCase();
  
      if (this.dataSource.paginator) {
        this.dataSource.paginator.firstPage();
      }
    }

    getRow(row: any){
      this.router.navigateByUrl(`alumnoDetail/${row.id}`);
    }
}
