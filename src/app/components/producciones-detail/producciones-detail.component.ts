import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produccion } from 'src/app/interfaces/produccion';
import { CyadService } from 'src/app/service/cyad.service';


@Component({
  selector: 'app-producciones-detail',
  templateUrl: './producciones-detail.component.html',
  styleUrls: ['./producciones-detail.component.scss']
})
export class ProduccionesDetailComponent implements OnInit {

  produccion!: Produccion;

  constructor(private cyadService: CyadService, private activatedRouter: ActivatedRoute) {
    this.activatedRouter.params.subscribe(
      params=>{
        this.getProduccion(params['id']);
      }
    );
  }

  ngOnInit(): void {
  }

  getProduccion(id: number){
    this.cyadService.getProduccionDetail(id).subscribe(
      res=>{
        this.produccion = res;
        console.log(res);
      },
      err=>{
        console.error(err);
      }
    );
  }

}
