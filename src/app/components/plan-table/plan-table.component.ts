import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CyadService } from 'src/app/service/cyad.service';
import { PlanDetailComponent } from '../plan-detail/plan-detail.component';

@Component({
  selector: 'app-plan-table',
  templateUrl: './plan-table.component.html',
  styleUrls: ['./plan-table.component.scss']
})
export class PlanTableComponent implements OnInit {

  title: string = "Planes de estudio";
  displayColumns: String[] = ['id','clave','creditos','duracion','division','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;


  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService: CyadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllPlanes();
  }

  getAllPlanes(){
    this.cyadService.getPlanes().subscribe({
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

  editPlan(row: any): void {
    this.dialog.open(PlanDetailComponent, {
      data: row
    }).afterClosed().subscribe(
      val => {
        if (val === 'update') {
          this.getAllPlanes();
        }
      })

  }

  openDialog(){
    const dialogRef =  this.dialog.open(PlanDetailComponent);

    dialogRef.afterClosed().subscribe(
      val =>{
        if(val === 'save'){
          this.getAllPlanes();
        }
      }
    );
  }

  deletePlan(id:number){
    this.cyadService.deletePlan(id).subscribe({
      next:(res)=>{
        alert("Plan Delete Successfully");
        this.getAllPlanes();
      },
      error:(err)=>{
        alert("Error while deleting the plan");
      }
    });
  }
}
