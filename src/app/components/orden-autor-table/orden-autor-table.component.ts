import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { OrdenAutorDetailComponent } from '../orden-autor-detail/orden-autor-detail.component';

@Component({
  selector: 'app-orden-autor-table',
  templateUrl: './orden-autor-table.component.html',
  styleUrls: ['./orden-autor-table.component.scss']
})
export class OrdenAutorTableComponent implements OnInit {
  
  title: string = "Orden de autores";
  displayColumns: String[] = ['id','orden','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllOrdenAutores();
  }

  getAllOrdenAutores(){
    this.cyadService.getOrdenAutores().subscribe({
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

  editOrden(row: any): void {
    this.dialog.open(OrdenAutorDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllOrdenAutores();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(OrdenAutorDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAllOrdenAutores();
        }
      }
    );
  }

  deleteOrden(id:number){
    this.cyadService.deleteOrdenAutor(id).subscribe({
      next:(res)=>{
        alert("orden Delete Successfully");
        this.getAllOrdenAutores();
      },
      error:(err)=>{
        alert("Error while deleting the orden");
      }
    });
  }
}
