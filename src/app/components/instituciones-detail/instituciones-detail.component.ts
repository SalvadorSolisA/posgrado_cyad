import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Institucion } from 'src/app/interfaces/institucion';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-instituciones-detail',
  templateUrl: './instituciones-detail.component.html',
  styleUrls: ['./instituciones-detail.component.scss']
})
export class InstitucionesDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nueva institución"; 
  actionBtn : string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<InstitucionesDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:Institucion
  ) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      institucion : ['',Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar Institución";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['institucion'].setValue(this.editData.institucion);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addInstitucion(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postInstitucion(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Institucion add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the estado ");
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateInstitucion();
    }
  }

  updateInstitucion(){
    this.cyadService.putInstitucion(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Institucion update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the institucion");
      }

    })
  }

}
