import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { take } from 'rxjs';
import { Autor } from 'src/app/interfaces/autor';

import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-autor-table',
  templateUrl: './autor-table.component.html',
  styleUrls: ['./autor-table.component.scss']
})
export class AutorTableComponent implements OnInit {

  displayColumns: String[] = ['id','nombre','apellido'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);
  autores = [];

  constructor(private cyadService : CyadService, private router: Router) { }

  ngOnInit(): void {
    this.getAutores();
  }

  getAutores(){

  }

}
