import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PlanEstudios } from 'src/app/interfaces/plan-estudios';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-plan-detail',
  templateUrl: './plan-detail.component.html',
  styleUrls: ['./plan-detail.component.scss']
})
export class PlanDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nuevo plan de estudios"; 
  actionBtn : string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<PlanDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:PlanEstudios
  ) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      clave : ['',Validators.required],
      creditos : ['',Validators.required],
      duracion : ['',Validators.required],
      division : ['',Validators.required],
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar plan de estudios";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['clave'].setValue(this.editData.clave);
      this.areaForm.controls['creditos'].setValue(this.editData.creditos);
      this.areaForm.controls['duracion'].setValue(this.editData.duracion);
      this.areaForm.controls['division'].setValue(this.editData.division);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addPlan(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postPlan(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Plan add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the plan ");
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updatePlan();
    }
  }

  updatePlan(){
    this.cyadService.putPlan(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Plan update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the plan");
      }

    })
  }

}
