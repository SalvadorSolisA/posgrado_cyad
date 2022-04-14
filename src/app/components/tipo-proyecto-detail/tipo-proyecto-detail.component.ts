import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TipoProyecto } from 'src/app/interfaces/tipo-proyecto';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-tipo-proyecto-detail',
  templateUrl: './tipo-proyecto-detail.component.html',
  styleUrls: ['./tipo-proyecto-detail.component.scss']
})
export class TipoProyectoDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nuevo tipo de proyecto"; 
  actionBtn : string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<TipoProyectoDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:TipoProyecto
  ) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      tipo : ['',Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar tipo de producción";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['tipo'].setValue(this.editData.tipo);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addTipo(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postTipoProyecto(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Tipo add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the tipo "+ err);
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateTipo();
    }
  }

  updateTipo(){
    this.cyadService.putTipoProyecto(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Tipo update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the tipo");
      }

    })
  }

}
