import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Profesor } from 'src/app/interfaces/profesor';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-profesor-detail',
  templateUrl: './profesor-detail.component.html',
  styleUrls: ['./profesor-detail.component.scss']
})
export class ProfesorDetailComponent implements OnInit {

  prof!: Profesor;

  //Inyectando el servicio cyad
  constructor(private cyadService : CyadService, private activatedRoute : ActivatedRoute) {
    //Obteniendo la variable id del Path
    this.activatedRoute.params.subscribe(
      params =>{
        this.getProfesor(params['id']);
      }
    )
  }

  ngOnInit(): void {
  }

  getProfesor(id : number){
    this.cyadService.getProfesorDetails(id).subscribe(
      res=>{
        this.prof = res;
      },
      err=>{
        console.error(err);
      }
    );
  }


}
