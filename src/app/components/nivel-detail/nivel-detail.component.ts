import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Nivel } from 'src/app/interfaces/nivel';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-nivel-detail',
  templateUrl: './nivel-detail.component.html',
  styleUrls: ['./nivel-detail.component.scss']
})
export class NivelDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nuevo nivel"; 
  actionBtn : string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<NivelDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:Nivel
  ) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      nivel : ['',Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar Institución";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['nivel'].setValue(this.editData.nivel);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addNivel(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postNivel(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Nivel add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the nivel ");
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateNivel();
    }
  }

  updateNivel(){
    this.cyadService.putNivel(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Nivel update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the nivel");
      }

    })
  }

}
