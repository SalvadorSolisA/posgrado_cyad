import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { InstitucionesDetailComponent } from '../instituciones-detail/instituciones-detail.component';

@Component({
  selector: 'app-instituciones-table',
  templateUrl: './instituciones-table.component.html',
  styleUrls: ['./instituciones-table.component.scss']
})
export class InstitucionesTableComponent implements OnInit {

  title: string = "Instituciones";
  displayColumns: String[] = ['id','institucion','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllInstituciones();
  }

  getAllInstituciones(){
    this.cyadService.getInstituciones().subscribe({
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

  editInstitucion(row: any): void {
    this.dialog.open(InstitucionesDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllInstituciones();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(InstitucionesDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAllInstituciones();
        }
      }
    );
  }

  deleteInstitucion(id:number){
    this.cyadService.deleteInstitucion(id).subscribe({
      next:(res)=>{
        alert("Institucion Delete Successfully");
        this.getAllInstituciones();
      },
      error:(err)=>{
        alert("Error while deleting the insitucion");
      }
    });
  }
}
