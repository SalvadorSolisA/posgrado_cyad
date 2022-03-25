import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { EstadoAcademico } from 'src/app/interfaces/estado-academico';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-estado-academico-detail',
  templateUrl: './estado-academico-detail.component.html',
  styleUrls: ['./estado-academico-detail.component.scss']
})
export class EstadoAcademicoDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nuevo estado académico"; 
  actionBtn : string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<EstadoAcademicoDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:EstadoAcademico
  ) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      estado : ['',Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar estado académico";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['estado'].setValue(this.editData.estado);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addEstadoAcademico(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postEstadosAcademico(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Estado add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the estado "+ err);
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateEstadoAcademico();
    }
  }

  updateEstadoAcademico(){
    this.cyadService.putEstadosAcademico(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Estado update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the estado");
      }

    })
  }

}
