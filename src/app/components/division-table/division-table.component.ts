import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { DivisionDetailComponent } from '../division-detail/division-detail.component';

@Component({
  selector: 'app-division-table',
  templateUrl: './division-table.component.html',
  styleUrls: ['./division-table.component.scss']
})
export class DivisionTableComponent implements OnInit {
  
  title: string = "Divisiones";
  displayColumns: String[] = ['id','division','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getDivisiones();
  }

  getDivisiones(){
    this.cyadService.getDivisiones().subscribe({
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

  editDivision(row: any): void {
    this.dialog.open(DivisionDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getDivisiones();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(DivisionDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getDivisiones();
        }
      }
    );
  }

  deleteDivision(id:number){
    this.cyadService.deleteDivision(id).subscribe({
      next:(res)=>{
        alert("Division Delete Successfully");
        this.getDivisiones();
      },
      error:(err)=>{
        alert("Error while deleting the division");
      }
    });
  }
}
