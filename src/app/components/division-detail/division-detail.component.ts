import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Division } from 'src/app/interfaces/division';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-division-detail',
  templateUrl: './division-detail.component.html',
  styleUrls: ['./division-detail.component.scss']
})
export class DivisionDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nueva divisiòn"; 
  actionBtn : string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<DivisionDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:Division
  ) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      division : ['',Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar division";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['division'].setValue(this.editData.division);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addDivision(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postDivision(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Division add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the division "+ err);
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateDivision();
    }
  }

  updateDivision(){
    this.cyadService.putDivision(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Division update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the division");
      }

    })
  }

}
