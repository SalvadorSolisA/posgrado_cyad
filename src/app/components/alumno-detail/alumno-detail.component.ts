import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Alumno } from 'src/app/interfaces/alumno';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-alumno-detail',
  templateUrl: './alumno-detail.component.html',
  styleUrls: ['./alumno-detail.component.scss']
})
export class AlumnoDetailComponent implements OnInit {

  alumno!: Alumno;

  constructor(private cyadService : CyadService, private activatedRouter : ActivatedRoute) {
    this.activatedRouter.params.subscribe(
      params=>{
        this.getAlumno(params['id']);
      }
    )
   }

  ngOnInit(): void {
  }

  getAlumno(id: number){
    this.cyadService.getAlumnoDetail(id).subscribe(
      res=>{
        this.alumno = res;
      },
      err=>{
        console.error(err);
      }
    );
  }

}
