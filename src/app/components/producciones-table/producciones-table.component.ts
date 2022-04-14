import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CyadService } from 'src/app/service/cyad.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-producciones-table',
  templateUrl: './producciones-table.component.html',
  styleUrls: ['./producciones-table.component.scss']
})
export class ProduccionesTableComponent implements OnInit {

  title: string = "Producciones";
  displayedColumns: String[] = ['id','clave_producto','titulo','fecha_publicacion','lgac','tipo','activo','action'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  resultsLength: number = 0;

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  constructor(private cyadService: CyadService, private router : Router) { }

  ngOnInit(): void {
    this.getAllProducciones();
  }

  getAllProducciones() {
    this.cyadService.getProducciones().subscribe({
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

  getRow(row: any) {
    this.router.navigateByUrl(`produccionDetail/${row.id}`);
  }

  registerProduccion(){
    this.router.navigateByUrl('produccion-register');
  }

  editProduccion(row: any){
    this.router.navigateByUrl(`produccionDetail/${row.id}`);
  }

  deleteProduccion(id: number){
    this.cyadService.deleteProduccion(id).subscribe({
      next:(res)=>{
        alert("produccion Delete Successfully");
        this.getAllProducciones();
      },
      error:(err)=>{
        alert("Error while deleting the produccion");
        console.error(err);
      }
    });
  }

}


