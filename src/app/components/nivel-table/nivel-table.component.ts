import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { NivelDetailComponent } from '../nivel-detail/nivel-detail.component';

@Component({
  selector: 'app-nivel-table',
  templateUrl: './nivel-table.component.html',
  styleUrls: ['./nivel-table.component.scss']
})
export class NivelTableComponent implements OnInit {

  title: string = "Niveles";
  displayColumns: String[] = ['id','nivel','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllNiveles();
  }

  getAllNiveles(){
    this.cyadService.getNiveles().subscribe({
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

  editNivel(row: any): void {
    this.dialog.open(NivelDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllNiveles();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(NivelDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAllNiveles();
        }
      }
    );
  }

  deleteNivel(id:number){
    this.cyadService.deleteNivel(id).subscribe({
      next:(res)=>{
        alert("Nivel Delete Successfully");
        this.getAllNiveles();
      },
      error:(err)=>{
        alert("Error while deleting the nivel");
      }
    });
  }
}
