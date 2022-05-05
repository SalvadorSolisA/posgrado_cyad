import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TipoClaveAutor } from 'src/app/interfaces/tipo-clave-autor';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-tipo-clave-detail',
  templateUrl: './tipo-clave-detail.component.html',
  styleUrls: ['./tipo-clave-detail.component.scss']
})
export class TipoClaveDetailComponent implements OnInit {

  
  areaForm!: FormGroup;
  title : string = "Nuevo tipo de clave"; 
  actionBtn : string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<TipoClaveDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:TipoClaveAutor
  ) { }
  
  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      tipo : ['',Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se trata de una edición*/
    if(this.editData){
      this.title = "Actualizar área de investigación";
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

  addTipoClave(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postTipoClaveAutor(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Tipo clave add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the tipo clave "+ err);
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateTipoClave();
    }
  }

  updateTipoClave(){
    console.log('data: ',this.areaForm.value);
    this.cyadService.putTipoClaveAutor(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Tipo de clave update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the tipo de clave");
      }

    })
  }


}
