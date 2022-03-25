import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { CyadService } from 'src/app/service/cyad.service';
import { Produccion } from "src/app/interfaces/produccion";
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-producciones-table',
  templateUrl: './producciones-table.component.html',
  styleUrls: ['./producciones-table.component.scss']
})
export class ProduccionesTableComponent implements OnInit {

  displayedColumns: String[] = ['id','clave_producto','titulo','fecha_publicacion','lgac'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);

  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  
  constructor(private cyadService: CyadService, private router : Router) { }

  ngOnInit(): void {
    this.getProducciones();
  }

  getProducciones() {
    let produccionData;

    this.cyadService.getProducciones().subscribe(
      res => {
        res.forEach((produccion: Produccion) => {
          produccionData = {
            id: produccion.id,
            clave_producto: produccion.clave_producto,
            titulo: produccion.titulo,
            fecha_publicacion: produccion.fecha_publicacion,
            lgac: produccion.lgac
          };
          this.data.push(produccionData);
          this.dataSource = new MatTableDataSource<any>(this.data);
        });
        console.log(res);
      },
      err => {
        console.error(err);
      }
    );
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

}


