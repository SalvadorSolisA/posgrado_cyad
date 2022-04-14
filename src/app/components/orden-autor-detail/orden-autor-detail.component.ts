import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { OrdenAutor } from 'src/app/interfaces/orden-autor';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-orden-autor-detail',
  templateUrl: './orden-autor-detail.component.html',
  styleUrls: ['./orden-autor-detail.component.scss']
})
export class OrdenAutorDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nuevo orden de autor"; 
  actionBtn : string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<OrdenAutorDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:OrdenAutor
  ) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      orden : ['',Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar orden de autor";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['orden'].setValue(this.editData.orden);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addOrden(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postOrdenAutor(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Orden add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the orden "+ err);
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateOrden();
    }
  }

  updateOrden(){
    this.cyadService.putOrdenAutor(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Orden update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the orden");
      }

    })
  }

}
