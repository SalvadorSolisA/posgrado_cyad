import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, take } from 'rxjs';

import { Autor } from "src/app/interfaces/autor";
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-autores-detail',
  templateUrl: './autores-detail.component.html',
  styleUrls: ['./autores-detail.component.scss']
})
export class AutoresDetailComponent implements OnInit {
  autor$: Observable<Autor> | undefined;

  autor : Autor ={
    id : 0,
    nombre : "",
    ap_paterno : "",
    ap_materno : "",
    nacionalidad : "",
    activo : true
  };

  constructor(private cyadService : CyadService, private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
  }

  getAutor(){


  }

}
