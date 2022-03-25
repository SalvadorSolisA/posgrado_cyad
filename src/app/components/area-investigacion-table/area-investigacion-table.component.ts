import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { AreaInvestigacionDetailComponent } from '../area-investigacion-detail/area-investigacion-detail.component';

@Component({
  selector: 'app-area-investigacion-table',
  templateUrl: './area-investigacion-table.component.html',
  styleUrls: ['./area-investigacion-table.component.scss']
})
export class AreaInvestigacionTableComponent implements OnInit {

  displayColumns: String[] = ['id','area_investigacion','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAreasInvestigacion();
  }

  //Obtiene todas las areas de investigacion del servicio
  getAreasInvestigacion(){
    this.cyadService.getAreasInvestigacion().subscribe({
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
  editArea(row: any): void {
    this.dialog.open(AreaInvestigacionDetailComponent,{
      data: row
    }).afterClosed().subscribe(
      val=>{
        if (val === 'update') {
          this.getAreasInvestigacion();
        }
      }
    );
  }

  //Abre cuadro de dialogo para ingresar una nueva area de investigacion
  openDialog(){
    this.dialog.open(AreaInvestigacionDetailComponent)
    .afterClosed().subscribe(
      val=>{
        if(val === 'save'){
          this.getAreasInvestigacion();
        }
      }
    );
  }

  //borrado de area de investigacion
  deleteArea(id: number){
    this.cyadService.deleteAreaInvestigacion(id).subscribe({
      next:(res)=>{
        alert("Area Investigacion Delete Successfully");
        this.getAreasInvestigacion();
      },
      error:(err)=>{
        alert("Error while deleting the area investigacion");
      }
    });
  }

  
}
