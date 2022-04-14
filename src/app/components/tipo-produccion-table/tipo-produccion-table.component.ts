import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { TipoProduccionDetailComponent } from '../tipo-produccion-detail/tipo-produccion-detail.component';

@Component({
  selector: 'app-tipo-produccion-table',
  templateUrl: './tipo-produccion-table.component.html',
  styleUrls: ['./tipo-produccion-table.component.scss']
})
export class TipoProduccionTableComponent implements OnInit {

  title: string = "Tipos de producciones";
  displayColumns: String[] = ['id','tipo','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllTiposProduccion();
  }

  getAllTiposProduccion(){
    this.cyadService.getTiposProduccion().subscribe({
      next:(res)=>{
        console.log(res);
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
    this.dialog.open(TipoProduccionDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllTiposProduccion();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(TipoProduccionDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAllTiposProduccion();
        }
      }
    );
  }

  deleteTipo(id:number){
    this.cyadService.deleteTipoProduccion(id).subscribe({
      next:(res)=>{
        alert("tipo Delete Successfully");
        this.getAllTiposProduccion();
      },
      error:(err)=>{
        alert("Error while deleting the tipo");
      }
    });
  }
}
