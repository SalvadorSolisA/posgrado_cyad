import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { EstadoAcademicoDetailComponent } from '../estado-academico-detail/estado-academico-detail.component';

@Component({
  selector: 'app-estado-academico-table',
  templateUrl: './estado-academico-table.component.html',
  styleUrls: ['./estado-academico-table.component.scss']
})
export class EstadoAcademicoTableComponent implements OnInit {

  title: string = "Estados Academicos";
  displayColumns: String[] = ['id','estado','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllEstadosAcademicos();
  }

  getAllEstadosAcademicos(){
    this.cyadService.getEstadosAcademicos().subscribe({
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

  editEstadoAcademico(row: any): void {
    this.dialog.open(EstadoAcademicoDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllEstadosAcademicos();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(EstadoAcademicoDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAllEstadosAcademicos();
        }
      }
    );
  }

  deleteEstadoAcademico(id:number){
    this.cyadService.deleteEstadosAcademico(id).subscribe({
      next:(res)=>{
        alert("Estado Delete Successfully");
        this.getAllEstadosAcademicos();
      },
      error:(err)=>{
        alert("Error while deleting the estado");
      }
    });
  }
}
