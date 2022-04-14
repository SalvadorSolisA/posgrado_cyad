import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

import { CyadService } from 'src/app/service/cyad.service';
import { AreaConcentracionDetailComponent } from '../area-concentracion-detail/area-concentracion-detail.component';

@Component({
  selector: 'app-area-concentracion-table',
  templateUrl: './area-concentracion-table.component.html',
  styleUrls: ['./area-concentracion-table.component.scss']
})
export class AreaConcentracionTableComponent implements OnInit {

  displayColumns: String[] = ['id','area','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAreasConcentracion();
  }

  getAreasConcentracion(){
    this.cyadService.getAreasConcentracion().subscribe({
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

  editArea(row: any): void {
    this.dialog.open(AreaConcentracionDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAreasConcentracion();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(AreaConcentracionDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAreasConcentracion();
        }
      }
    );
  }

  deleteArea(id:number){
    this.cyadService.deleteAreaConcentracion(id).subscribe({
      next:(res)=>{
        alert("Area Delete Successfully");
      },
      error:(err)=>{
        alert("Error while deleting the area");
      }
    });
  }

}
