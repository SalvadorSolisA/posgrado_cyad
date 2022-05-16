import { STEPPER_GLOBAL_OPTIONS } from '@angular/cdk/stepper';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
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

  proyecto_ !: any;
  
  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;
  asesoresFormGroup!: FormGroup;

  /**listas */
  listProfesores !: Profesor[];
  listTiposProyecto !: TipoProyecto[];

  constructor(
    private cyadService: CyadService, 
    private formBuilder: FormBuilder,  
    private activatedRouter : ActivatedRoute,
    private router : Router) {
    this.activatedRouter.params.subscribe(
      params=>{
        if(params['id'] > 0)
          this.getProyecto(params['id']);
      }
    )
  }

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
  }//ngOnInit

  /**obtener datos del proyecto */
  getProyecto(id : number){
    this.cyadService.getProyectoDetail(id).subscribe({
      next:(res)=>{
        this.proyecto_ = res;
        this.setData(this.proyecto_);
      },
      error:(err)=>{
        console.error(err);
      }
    });
  }

  /**enviar datos a los campos del form */
  setData(proyecto : any){
      this.firstFormGroup.controls['tipo'].setValue(this.proyecto_.tipo.id);
      this.firstFormGroup.controls['titulo'].setValue(proyecto.titulo);
      this.firstFormGroup.controls['descripcion'].setValue(proyecto.descripcion);
      this.firstFormGroup.controls['fecha_inicio'].setValue(proyecto.fecha_inicio);
      this.firstFormGroup.controls['fecha_termino'].setValue(proyecto.fecha_termino);
      this.firstFormGroup.controls['lgac'].setValue(proyecto.lgac);

      /**grupo protocolo */
      let i : number = 0;
      if(proyecto.grupo != null)//si existe grupo de protocolo
      for(let participante of proyecto.grupo.participantes){
        if(participante.rol.id == 1){
          this.secondFormGroup.controls['director'].setValue(participante.profesor.id);
        }
  
        if(participante.rol.id == 2){
          this.secondFormGroup.controls['codirector'].setValue(participante.profesor.id);
        }
  
        if(participante.rol.id == 3){
          this.agregarAsesor();
          this.asesoresFormGroup.controls['asesor'].setValue(participante.profesor.id);
        }
      }
  }

  /**agregar campos de forma dinamica */
  get asesores(){
    return this.secondFormGroup.get('asesores') as FormArray;
  }

  agregarAsesor(){
    this.asesoresFormGroup = this.formBuilder.group({
      asesor: ['', Validators.required]
    });
    this.asesores.push(this.asesoresFormGroup);
  }

  removerAsesor(indice : number){

    console.log('asesor a value ',this.asesores.at(indice).value);

    if(this.asesores.at(indice).value != '' && this.existId(this.asesores.at(indice).value)){
      /**se elimina de bd */

      console.log('asesor a eliminar ',this.proyecto_.grupo.participantes[indice]);
      console.log('asesor id ',this.proyecto_.grupo.participantes[indice].id);

      this.cyadService.deleteParticipante(this.proyecto_.grupo.participantes[indice].id).subscribe({
        next:(res)=>{
          console.log('Se elimina asesor ', res);
        }
      });
    }

    this.asesores.removeAt(indice);

  }

  refresh(){
    this.asesores.controls.splice(0,this.asesores.length);
  }

  setAsesor(asesor : any ){
    this.agregarAsesor();
    this.secondFormGroup.controls['asesor'].setValue(1);
  }

  updateProyecto(){
    /**modelo de proyecto */
    let proyecto_update;

    if (this.proyecto_.grupo == null) {
      /**si no existe grupo de protocolo se crea */
      this.cyadService.postGrupoProtocoloClave().subscribe({
        next: (res) => {

          proyecto_update = {
            id: this.proyecto_.id,
            tipo: {
              id: this.firstFormGroup.controls['tipo'].value
            },
            titulo: this.firstFormGroup.controls['titulo'].value,
            descripcion: this.firstFormGroup.controls['descripcion'].value,
            fecha_inicio: this.firstFormGroup.controls['fecha_inicio'].value,
            fecha_termino: this.firstFormGroup.controls['fecha_termino'].value,
            lgac: this.firstFormGroup.controls['lgac'].value,
            grupo_proyecto: {
              id: res.id
            }
          }

          /**DIRECTOR */
          /**registrar participante */
          let director;
          director = {
            profesor: {
              id: this.secondFormGroup.controls['director'].value
            },
            rol: {
              id: 1
            },
            tipo: {
              id: 1
            },
            grupo_participante: {
              id: res.id
            }
          }
          this.cyadService.postParticipante(director).subscribe({
            next: (res) => {
              alert('Director registrado');
            },
            error: () => {
              alert('Error al registrar director');
            }
          });

          /**CODIRECTOR */
          /**registrar participante */
          let codirector;
          codirector = {
            profesor: {
              id: this.secondFormGroup.controls['codirector'].value
            },
            rol: {
              id: 2
            },
            tipo: {
              id: 1
            },
            grupo_participante: {
              id: res.id
            }
          }
          this.cyadService.postParticipante(codirector).subscribe({
            next: (res) => {
              alert('Codirector registrado');
            },
            error: () => {
              alert('Error al registrar codirector');
            }
          });

          /**ASESORES */
          let asesor;
          for (let i=0; i < this.asesores.length; i++){
            const id = this.asesores.at(i).value;
            asesor = {
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
  
            this.cyadService.postParticipante(asesor).subscribe({
              next: (res) => {
                if (res)
                  console.log('se registro asesor');
              }
            });
          }//for


          /**llamada al servicio */
          this.cyadService.putProyecto(proyecto_update).subscribe({
            next: (res) => {
              alert('Actualizacion de proyecto exitosa');
              this.router.navigateByUrl('proyectos');//redireccion
            },
            error: (err) => {
              alert('Error al actualizar proyecto');
              console.error(err);
            }
          });
        }//next
      });
    }//if
    else{

      proyecto_update = {
        id: this.proyecto_.id,
        tipo: {
          id: this.firstFormGroup.controls['tipo'].value
        },
        titulo: this.firstFormGroup.controls['titulo'].value,
        descripcion: this.firstFormGroup.controls['descripcion'].value,
        fecha_inicio: this.firstFormGroup.controls['fecha_inicio'].value,
        fecha_termino: this.firstFormGroup.controls['fecha_termino'].value,
        lgac: this.firstFormGroup.controls['lgac'].value,
        grupo_proyecto: {
          id: this.proyecto_.grupo.id
        },
        documento : this.proyecto_.documento
      }

      /**DIRECTOR */
          /**registrar participante */
          let indice  = this.existRol(this.proyecto_.grupo.participantes,1);
          let director;

          if(indice >= 0){
            director = {
              id : this.proyecto_.grupo.participantes[indice].id,
              profesor: {
                id: this.secondFormGroup.controls['director'].value
              },
              rol: {
                id: 1
              },
              tipo: {
                id: 1
              },
              grupo_participante: {
                id: this.proyecto_.grupo.id
              }
            }
            this.cyadService.putParticipante(director).subscribe({
              next: (res) => {
                alert('Director actualizado');
              },
              error: () => {
                alert('Error al actualizar director');
              }
            });
          }
          else{//no existe director
            director = {
              profesor: {
                id: this.secondFormGroup.controls['director'].value
              },
              rol: {
                id: 1
              },
              tipo: {
                id: 1
              },
              grupo_participante: {
                id: this.proyecto_.grupo.id
              }
            }
            this.cyadService.postParticipante(director).subscribe({
              next: (res) => {
                console.log('Director actualizado');
              },
              error: (err) => {
                console.error('Error al actualizar director');
              }
            });
          }

          /**CODIRECTOR */
          /**registrar participante */
          indice  = this.existRol(this.proyecto_.grupo.participantes,2);
          let codirector;
          if(indice >= 0){
            codirector = {
              id: indice,
              profesor: {
                id: this.secondFormGroup.controls['codirector'].value
              },
              rol: {
                id: 2
              },
              tipo: {
                id: 1
              },
              grupo_participante: {
                id: this.proyecto_.grupo.id
              }
            }
            this.cyadService.putParticipante(codirector).subscribe({
              next: (res) => {
                console.log('Codirector registrado');
              },
              error: (err) => {
                console.error('Error al registrar codirector');
              }
            });
          }//if
          else{
            codirector = {
              profesor: {
                id: this.secondFormGroup.controls['codirector'].value
              },
              rol: {
                id: 2
              },
              tipo: {
                id: 1
              },
              grupo_participante: {
                id: this.proyecto_.grupo.id
              }
            }
            this.cyadService.putParticipante(codirector).subscribe({
              next: (res) => {
                console.log('Codirector registrado');
              },
              error: (err) => {
                console.error('Error al registrar codirector');
              }
            });
          }

          /**ASESORES */
          let asesor;
          for (let i=0; i < this.asesores.length; i++){
            const id = this.asesores.at(i).value;
            asesor = {
              profesor : {
                id: id.asesor
              },
              rol : {
                id: 3
              },
              grupo_participante :{
                id : this.proyecto_.grupo.id
              },
              tipo: {
                id : 1
              }
            }
  
            this.cyadService.postParticipante(asesor).subscribe({
              next: (res) => {
                if (res)
                  console.log('se registro asesor');
              }
            });
          }//for


          /**llamada al servicio */
          this.cyadService.putProyecto(proyecto_update).subscribe({
            next: (res) => {
              alert('Actualizacion de proyecto exitosa');
              this.router.navigateByUrl('proyectos');//redireccion
            },
            error: (err) => {
              alert('Error al actualizar proyecto');
              console.error(err);
            }
          });
    }

  }//update

  existAsesor(asesor : any) : boolean{
    let flag = false;
    for (let asesor_bd of this.proyecto_.grupo.participantes) {
      if (asesor.value.id == asesor_bd.id) {
        flag = true;
        break;
      }
    }
    return flag;
  }

  //regresa un indice si existe el rol
  existRol(participantes:  any[], rol: number) : number {
    let indice : number = -1;
    for(let participante of participantes){
      if(participante.rol.id == rol){
        indice  = participante.index;
        break;
      }
    }
    return indice;
  }

  existId(id_buscar : number){
    let flag : boolean = false;
    for(let participante of this.proyecto_.grupo.participantes){
      if(participante.id == id_buscar){
        flag = true;
        break;
      }
    }

    return true;
  }


}

