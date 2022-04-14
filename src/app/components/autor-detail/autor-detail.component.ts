import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

import { Autor } from "src/app/interfaces/autor";
import { TipoClaveAutor } from 'src/app/interfaces/tipo-clave-autor';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-autor-detail',
  templateUrl: './autor-detail.component.html',
  styleUrls: ['./autor-detail.component.scss']
})
export class AutorDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nuevo autor"; 
  actionBtn : string = "Guardar";

  listTipoClave !: TipoClaveAutor[];

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<AutorDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:Autor
  ) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      clave : ['',Validators.nullValidator],
      tipo_clave : ['',Validators.nullValidator],
      nombre : ['',Validators.nullValidator],
      ap_paterno : ['',Validators.nullValidator],
      ap_materno : ['',Validators.nullValidator],
      nacionalidad : ['',Validators.nullValidator]
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar autor";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['clave'].setValue(this.editData.clave);
      this.areaForm.controls['tipo_clave'].setValue(this.editData.tipo_clave.id);
      this.areaForm.controls['nombre'].setValue(this.editData.nombre);
      this.areaForm.controls['ap_paterno'].setValue(this.editData.ap_paterno);
      this.areaForm.controls['ap_materno'].setValue(this.editData.ap_materno);
      this.areaForm.controls['nacionalidad'].setValue(this.editData.nacionalidad);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();

    /**cargar catalogos */
    this.cyadService.getTiposClavesAutor().subscribe({
      next:(res)=>{
        this.listTipoClave = res;
      }
    });
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addAutor(){
    if(!this.editData){
      if(this.areaForm.valid){

        /**estructura */
        let autor;

        autor={
          nombre : this.areaForm.controls['nombre'].value,
          ap_paterno : this.areaForm.controls['ap_paterno'].value,
          ap_materno : this.areaForm.controls['ap_materno'].value,
          clave : this.areaForm.controls['clave'].value,
          tipo_clave : {
            id : this.areaForm.controls['tipo_clave'].value 
          },
          nacionalidad : this.areaForm.controls['nacionalidad'].value
        }

        /**llamada al servicio */
        this.cyadService.postAutor(autor)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Autor add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the autor "+ err);
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateAutor();
    }
  }

  updateAutor(){

    /**estructura */
    let autor;

    autor={
      id : this.areaForm.controls['id'].value,
      nombre : this.areaForm.controls['nombre'].value,
      ap_paterno : this.areaForm.controls['ap_paterno'].value,
      ap_materno : this.areaForm.controls['ap_materno'].value,
      clave : this.areaForm.controls['clave'].value,
      tipo_clave : {
        id : this.areaForm.controls['tipo_clave'].value 
      },
      nacionalidad : this.areaForm.controls['nacionalidad'].value
    }

    this.cyadService.putAutor(autor)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Autor update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the autor");
      }

    })
  }

}
