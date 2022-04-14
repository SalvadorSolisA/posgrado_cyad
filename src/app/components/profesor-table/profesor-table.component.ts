import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CyadService } from 'src/app/service/cyad.service';
import { ProfesorDetailComponent } from '../profesor-detail/profesor-detail.component';

@Component({
  selector: 'app-profesor-table',
  templateUrl: './profesor-table.component.html',
  styleUrls: ['./profesor-table.component.scss']
})
export class ProfesorTableComponent implements OnInit {

  title: string = "Profesores";
  displayedColumns: String[] = ['id','numero_eco','nombre','apellido_pat','apellido_mat','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  constructor(private cyadService : CyadService, private dialog: MatDialog, private router : Router) { }

  ngOnInit(): void {
    this.getAllProfesores();
  }

  getAllProfesores(){
    this.cyadService.getProfesores().subscribe({
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

  applyFilter(event : Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  openDialog(){
    const dialogRef =  this.dialog.open(ProfesorDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAllProfesores();
        }
      }
    );
  }

  editInstitucion(row: any){
    this.dialog.open(ProfesorDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllProfesores();
        }
      })
  }

  deleteInstitucion(id: number){
    this.cyadService.deleteProfesor(id).subscribe({
      next:(res)=>{
        alert("profesor Delete Successfully");
        this.getAllProfesores();
      },
      error:(err)=>{
        alert("Error while deleting the profesor");
        console.error(err);
      }
    });
  }

}



