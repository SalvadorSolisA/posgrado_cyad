import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Profesor } from 'src/app/interfaces/profesor';
import { TipoProyecto } from 'src/app/interfaces/tipo-proyecto';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-proyecto-register',
  templateUrl: './proyecto-register.component.html',
  styleUrls: ['./proyecto-register.component.scss']
})
export class ProyectoRegisterComponent implements OnInit {

  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;

  /**listas */
  listProfesores !: Profesor[];
  listTiposProyecto !: TipoProyecto[];
  listAlumnos !: any[];

  constructor(private cyadService: CyadService, private formBuilder: FormBuilder, private router : Router) { }

  ngOnInit(): void {
    this.firstFormGroup = this.formBuilder.group({
      alumno : ['', Validators.required], 
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

    this.cyadService.getAlumnos().subscribe({
      next:(res)=>{
        this.listAlumnos = res;
      }
    });
  }

  /**agregar campos de forma dinamica */
  get asesores(){
    return this.secondFormGroup.get('asesores') as FormArray;
  }

  agregarAsesor(){
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

  addProyecto() {
    let proyecto;
    let participante;

    if(this.firstFormGroup.valid && this.secondFormGroup.valid){
      
      this.cyadService.postGrupoProtocoloClave().subscribe({
        next: (res) => {
  
          /**Registrando el proyecto */
          proyecto = {
            alumno: {
              id : this.firstFormGroup.controls['alumno'].value
            },
            titulo: this.firstFormGroup.controls['titulo'].value,
            descripcion: this.firstFormGroup.controls['descripcion'].value,
            fecha_inicio: this.firstFormGroup.controls['fecha_inicio'].value,
            fecha_termino: this.firstFormGroup.controls['fecha_termino'].value,
            lgac: this.firstFormGroup.controls['lgac'].value,
            tipo: {
              id: this.firstFormGroup.controls['tipo'].value,
            },
            grupo_proyecto: {
              id : res.id
            }
          }
  
          this.cyadService.postProyecto(proyecto).subscribe({
            next: (res) => {
              if (res)
                console.log('se creo el proyecto');
            }
          });
  
          /**Registrando participantes */
  
          /**Director */
          participante = {
            profesor : {
              id:this.secondFormGroup.controls['director'].value
            },
            rol : {
              id: 1
            },
            grupo_participante :{
              id : res.id
            }
          }
          this.cyadService.postParticipante(participante).subscribe({
            next: (res) => {
              if (res)
                console.log('se registro director');
            }
          });
  
          /**codirector */
          participante = {
            profesor : {
              id:this.secondFormGroup.controls['codirector'].value
            },
            rol : {
              id: 2
            },
            grupo_participante :{
              id : res.id
            }
          }
          this.cyadService.postParticipante(participante).subscribe({
            next: (res) => {
              if (res)
                console.log('se registro codirector');
            }
          });
  
          /**asesores */
          for (let i=0; i < this.asesores.length; i++){
            const id = this.asesores.at(i).value;
            participante = {
              profesor : {
                id: id.asesor
              },
              rol : {
                id: 3
              },
              grupo_participante :{
                id : res.id
              }
            }
  
            this.cyadService.postParticipante(participante).subscribe({
              next: (res) => {
                if (res)
                  console.log('se registro asesor');
              }
            });
          }//for

          this.router.navigateByUrl('proyectos');

        }//next
      });
    }
    else{
      alert('faltan campos por llenar');
    }
  }
}



  




