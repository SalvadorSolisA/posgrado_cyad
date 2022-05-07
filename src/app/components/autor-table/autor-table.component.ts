import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

import { CyadService } from 'src/app/service/cyad.service';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material/dialog';
import { AutorDetailComponent } from '../autor-detail/autor-detail.component';

@Component({
  selector: 'app-autor-table',
  templateUrl: './autor-table.component.html',
  styleUrls: ['./autor-table.component.scss']
})
export class AutorTableComponent implements OnInit {
  
  title: string = "Autores";
  displayedColumns: String[] = ['id','clave','nombre','ap_paterno','ap_materno','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllAutores();
  }

  getAllAutores(){
    this.cyadService.getAutores().subscribe({
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

  editAutor(row: any): void {
    this.dialog.open(AutorDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllAutores();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(AutorDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAllAutores();
        }
      }
    );
  }

  deleteAutor(id:number){
    this.cyadService.deleteAutor(id).subscribe({
      next:(res)=>{
        alert("Autor Delete Successfully");
        this.getAllAutores();
      },
      error:(err)=>{
        alert("Error while deleting the autor");
      }
    });
  }
}
