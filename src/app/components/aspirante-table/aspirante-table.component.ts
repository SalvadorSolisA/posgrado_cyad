import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-aspirante-table',
  templateUrl: './aspirante-table.component.html',
  styleUrls: ['./aspirante-table.component.scss']
})
export class AspiranteTableComponent implements OnInit {
  
  titulo: string = "Aspirantes";
  displayColumns: String[] = ['id','matricula','nombre','ap_paterno','ap_materno','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength:number = 0;

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService : CyadService, private router: Router) { }

  ngOnInit(): void {
    this.getAllAspirantes();
  }

  getAllAspirantes(){
    this.cyadService.getAspirantes().subscribe({
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
    
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  addAspirante() {
    /**redirije al componente detail */
    this.router.navigateByUrl(`aspiranteDetail`);
  }

  editAspirante(row: any) {
    /**redirije al componente detail */
    this.router.navigateByUrl(`aspiranteDetail/${row.id}`);
  }

  deleteAspirante(id: number){
    this.cyadService.deleteAspirante(id).subscribe({
      next:(res)=>{
        if(res)
          alert("aspirante Delete Successfully");
        this.getAllAspirantes();
      },
      error:(err)=>{
        alert("Error while deleting the aspirante");
        console.error(err);
      }
    });
  }

}