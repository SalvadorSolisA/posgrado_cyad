import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Profesor } from 'src/app/interfaces/profesor';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-profesor-detail',
  templateUrl: './profesor-detail.component.html',
  styleUrls: ['./profesor-detail.component.scss']
})
export class ProfesorDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nueva institución"; 
  actionBtn : string = "Guardar";

  //Inyectando el servicio cyad
  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<ProfesorDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:Profesor
    ) {  }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      cvu : ['',Validators.required],
      numero_economico : ['',Validators.required],
      nombre : ['',Validators.required],
      ap_paterno : ['',Validators.required],
      ap_materno : ['',Validators.nullValidator],
      institucion : ['',Validators.required],
      division : ['',Validators.required],
      departamento : ['',Validators.required],
      area_investigacion : ['',Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar datos";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['cvu'].setValue(this.editData.cvu);
      this.areaForm.controls['numero_economico'].setValue(this.editData.numero_economico);
      this.areaForm.controls['nombre'].setValue(this.editData.nombre);
      this.areaForm.controls['ap_paterno'].setValue(this.editData.ap_paterno);
      this.areaForm.controls['ap_materno'].setValue(this.editData.ap_materno);
      this.areaForm.controls['institucion'].setValue(this.editData.institucion.institucion);
      this.areaForm.controls['division'].setValue(this.editData.division.division);
      this.areaForm.controls['departamento'].setValue(this.editData.departamento.departamento);
      this.areaForm.controls['area_investigacion'].setValue(this.editData.area_investigacion.area_investigacion);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addProfesor(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postProfesor(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Profesor add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the profesor ");
            console.error(err);
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateProfesor();
    }
  }

  updateProfesor(){
    this.cyadService.putProfesor(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Profesor update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the profesor");
      }

    })
  }

}
