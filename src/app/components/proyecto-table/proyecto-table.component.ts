import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-proyecto-table',
  templateUrl: './proyecto-table.component.html',
  styleUrls: ['./proyecto-table.component.scss']
})
export class ProyectoTableComponent implements OnInit {

  title: string = "Proyectos";
  displayedColumns: String[] = ['id','clave','descripcion','fecha_inicio','fecha_termino','lgac','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  constructor(private cyadService : CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllProfesores();
  }

  getAllProfesores(){
    this.cyadService.getProyectos().subscribe({
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

  }

  editProyecto(row: any){
   /* this.dialog.open(, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllProfesores();
        }
      })*/
  }

  deleteProyecto(id: number){
    this.cyadService.deleteProyecto(id).subscribe({
      next:(res)=>{
        alert("proyecto Delete Successfully");
        this.getAllProfesores();
      },
      error:(err)=>{
        alert("Error while deleting the proyecto");
        console.error(err);
      }
    });
  }

}



