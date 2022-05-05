import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { TrimestresDetailComponent } from '../trimestres-detail/trimestres-detail.component';

@Component({
  selector: 'app-trimestres-table',
  templateUrl: './trimestres-table.component.html',
  styleUrls: ['./trimestres-table.component.scss']
})
export class TrimestresTableComponent implements OnInit {

  displayColumns: String[] = ['id','fecha_inicio','fecha_fin','trimestre','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllTrimestres();
  }

  //Obtiene todas las claves del servicio
  getAllTrimestres(){
    this.cyadService.getTrimestres().subscribe({
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
  editTrimestre(row: any): void {
    this.dialog.open(TrimestresDetailComponent,{
      data: row
    }).afterClosed().subscribe(
      val=>{
        if (val === 'update') {
          this.getAllTrimestres();
        }
      }
    );
  }

  //Abre cuadro de dialogo para ingresar una nueva area de investigacion
  openDialog(){
    this.dialog.open(TrimestresDetailComponent)
    .afterClosed().subscribe(
      val=>{
        if(val === 'save'){
          this.getAllTrimestres();
        }
      }
    );
  }

  //borrado de area de investigacion
  deleteTrimestre(id: number){
    this.cyadService.deleteTipoClaveAutor(id).subscribe({
      next:(res)=>{
        alert("Trimestre Delete Successfully");
        this.getAllTrimestres();
      },
      error:(err)=>{
        alert("Error while deleting the trimestre");
      }
    });
  }
}
