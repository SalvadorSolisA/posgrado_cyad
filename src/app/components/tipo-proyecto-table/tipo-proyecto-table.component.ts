import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { TipoProyectoDetailComponent } from '../tipo-proyecto-detail/tipo-proyecto-detail.component';

@Component({
  selector: 'app-tipo-proyecto-table',
  templateUrl: './tipo-proyecto-table.component.html',
  styleUrls: ['./tipo-proyecto-table.component.scss']
})
export class TipoProyectoTableComponent implements OnInit {

  title: string = "Tipos de proyectos";
  displayColumns: String[] = ['id','tipo','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllTiposProyecto();
  }

  getAllTiposProyecto(){
    this.cyadService.getTiposProyectos().subscribe({
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

  editTipo(row: any): void {
    this.dialog.open(TipoProyectoDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllTiposProyecto();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(TipoProyectoDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAllTiposProyecto();
        }
      }
    );
  }

  deleteTipo(id:number){
    this.cyadService.deleteTipoProyecto(id).subscribe({
      next:(res)=>{
        alert("tipo Delete Successfully");
        this.getAllTiposProyecto();
      },
      error:(err)=>{
        alert("Error while deleting the tipo");
      }
    });
  }
}
