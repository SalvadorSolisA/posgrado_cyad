import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { TipoClaveDetailComponent } from '../tipo-clave-detail/tipo-clave-detail.component';

@Component({
  selector: 'app-tipo-clave-table',
  templateUrl: './tipo-clave-table.component.html',
  styleUrls: ['./tipo-clave-table.component.scss']
})
export class TipoClaveTableComponent implements OnInit {

  displayColumns: String[] = ['id','tipo','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getClavesAutor();
  }

  //Obtiene todas las claves del servicio
  getClavesAutor(){
    this.cyadService.getTiposClavesAutor().subscribe({
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

  //Filtro de datos en tabla
  applyFilter(event : Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  //actualización envia la data al componente detail
  editClaveAutor(row: any): void {
    this.dialog.open(TipoClaveDetailComponent,{
      data: row
    }).afterClosed().subscribe(
      val=>{
        if (val === 'update') {
          this.getClavesAutor();
        }
      }
    );
  }

  //Abre cuadro de dialogo para ingresar una nueva area de investigacion
  openDialog(){
    this.dialog.open(TipoClaveDetailComponent)
    .afterClosed().subscribe(
      val=>{
        if(val === 'save'){
          this.getClavesAutor();
        }
      }
    );
  }

  //borrado de area de investigacion
  deleteClaveAutor(id: number){
    this.cyadService.deleteTipoClaveAutor(id).subscribe({
      next:(res)=>{
        alert("Clave Autor Delete Successfully");
        this.getClavesAutor();
      },
      error:(err)=>{
        alert("Error while deleting the area investigacion");
      }
    });
  }
}

