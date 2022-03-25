import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Profesor } from 'src/app/interfaces/profesor';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-profesor-table',
  templateUrl: './profesor-table.component.html',
  styleUrls: ['./profesor-table.component.scss']
})
export class ProfesorTableComponent implements OnInit {

  displayedColumns: String[] = ['id','numero_eco','nombre','apellido_pat','apellido_mat'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  profesores = [];

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;

  constructor(private cyadService : CyadService, private router: Router) { }

  ngOnInit(): void {
    this.getProfesores();
  }

  getProfesores(){

    let profesorData;

    this.cyadService.getProfesores().subscribe(
      res =>{
        res.forEach((prof :Profesor) => {
          profesorData = {
            id : prof.id,
            numero_eco : prof.numero_economico,
            nombre : prof.nombre,
            apellido_pat : prof.ap_paterno,
            apellido_mat : prof.ap_materno
          };
          this.data.push(profesorData);
          this.dataSource = new MatTableDataSource<any>(this.data);
          this.dataSource.paginator = this.paginator;
        });
        //imprime el res en consola
        console.log(res);
      },
      err=>{
        console.error(err);
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
    this.router.navigateByUrl(`profesorDetail/${row.id}`);
  }

}



