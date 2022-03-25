import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { DepartamentoDetailComponent } from '../departamento-detail/departamento-detail.component';

@Component({
  selector: 'app-departamento-table',
  templateUrl: './departamento-table.component.html',
  styleUrls: ['./departamento-table.component.scss']
})
export class DepartamentoTableComponent implements OnInit {

  displayColumns: String[] = ['id','departamento','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getDepartamentos();
  }

  getDepartamentos(){
    this.cyadService.getDepartamentos().subscribe({
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

  editDepartamento(row: any): void {
    this.dialog.open(DepartamentoDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getDepartamentos();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(DepartamentoDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getDepartamentos();
        }
      }
    );
  }

  deleteDepartamento(id:number){
    this.cyadService.deleteDepartamento(id).subscribe({
      next:(res)=>{
        alert("Departamento Delete Successfully");
        this.getDepartamentos();
      },
      error:(err)=>{
        alert("Error while deleting the departamento");
      }
    });
  }
}
