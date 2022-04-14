import { STEPPER_GLOBAL_OPTIONS } from '@angular/cdk/stepper';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Profesor } from 'src/app/interfaces/profesor';
import { TipoProyecto } from 'src/app/interfaces/tipo-proyecto';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-proyecto-detail',
  templateUrl: './proyecto-detail.component.html',
  styleUrls: ['./proyecto-detail.component.scss'],
  providers: [
    {
      provide: STEPPER_GLOBAL_OPTIONS,
      useValue: {showError: true},
    },
  ],
})
export class ProyectoDetailComponent implements OnInit {

  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;

  /**listas */
  listProfesores !: Profesor[];
  listTiposProyecto !: TipoProyecto[];

  constructor(private cyadService: CyadService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.firstFormGroup = this.formBuilder.group({
      tipo : ['', Validators.required],
      titulo: ['', Validators.required],
      descripcion: ['', Validators.required],
      fecha_inicio: ['', Validators.required],
      fecha_termino: ['', Validators.required],
      lgac: ['', Validators.required]
    });
    this.secondFormGroup = this.formBuilder.group({
      director: ['', Validators.required],
      codirector: ['', Validators.required],
      asesores: this.formBuilder.array([])
    });

    /**cargando listas */
    this.cyadService.getProfesores().subscribe({
      next:(res)=>{
        this.listProfesores = res;
      }
    });

    this.cyadService.getTiposProyectos().subscribe({
      next:(res)=>{
        this.listTiposProyecto = res;
      }
    });
  }

  /**agregar campos de forma dinamica */
  get asesores(){
    return this.secondFormGroup.get('asesores') as FormArray;
  }

  agregarCorreo(){
    const asesoresFormGroup = this.formBuilder.group({
      asesor: ''
    });
    this.asesores.push(asesoresFormGroup);
  }

  removerAsesor(indice : number){
    this.asesores.removeAt(indice);
  }

  refresh(){
    this.asesores.controls.splice(0,this.asesores.length);
  }

  addProyecto(){
    
  }

}
