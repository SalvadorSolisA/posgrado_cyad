import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Departamento } from 'src/app/interfaces/departamento';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-departamento-detail',
  templateUrl: './departamento-detail.component.html',
  styleUrls: ['./departamento-detail.component.scss']
})
export class DepartamentoDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nuevo departamento"; 
  actionBtn : string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<DepartamentoDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:Departamento
  ) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      departamento : ['',Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar departamento";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['departamento'].setValue(this.editData.departamento);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addDepartamento(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postDepartamento(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Departamento add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the departamento "+ err);
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateDepartamento();
    }
  }

  updateDepartamento(){
    this.cyadService.putDepartamento(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Departamento update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the departamento");
      }

    })
  }

}
