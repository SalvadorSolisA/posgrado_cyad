import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { EstadoAspiranteDetailComponent } from '../estado-aspirante-detail/estado-aspirante-detail.component';

@Component({
  selector: 'app-estado-aspirante-table',
  templateUrl: './estado-aspirante-table.component.html',
  styleUrls: ['./estado-aspirante-table.component.scss']
})
export class EstadoAspiranteTableComponent implements OnInit {

  title: string = "Estados Aspirantes";
  displayColumns: String[] = ['id','estado','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllEstadosAspirantes();
  }

  getAllEstadosAspirantes(){
    this.cyadService.getEstadosAspirantes().subscribe({
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

  editEstadoAspirante(row: any): void {
    this.dialog.open(EstadoAspiranteDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllEstadosAspirantes();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(EstadoAspiranteDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAllEstadosAspirantes();
        }
      }
    );
  }

  deleteEstadoAspirante(id:number){
    this.cyadService.deleteEstadoAspirante(id).subscribe({
      next:(res)=>{
        alert("Estado Delete Successfully");
        this.getAllEstadosAspirantes();
      },
      error:(err)=>{
        alert("Error while deleting the estado");
      }
    });
  }
}
