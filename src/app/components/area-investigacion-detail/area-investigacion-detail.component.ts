import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AreaInvestigacion } from 'src/app/interfaces/areaInvestiongacion';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-area-investigacion-detail',
  templateUrl: './area-investigacion-detail.component.html',
  styleUrls: ['./area-investigacion-detail.component.scss']
})
export class AreaInvestigacionDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nueva area de investigación"; 
  actionBtn : string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<AreaInvestigacionDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData:AreaInvestigacion
  ) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      area : ['',Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se tarta de una edición*/
    if(this.editData){
      this.title = "Actualizar área de investigación";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['area'].setValue(this.editData.area_investigacion);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addArea(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postAreaInvestigacion(this.areaForm.value)
        .subscribe({
          next:(res)=>{
            console.log(res);
            alert("Area add successfully");
            this.areaForm.reset();
            this.dialogRef.close('save');
          },
          error:(err)=>{
            alert("Error while adding the area "+ err);
          }
        })
      }
    }
    else{
      this.areaForm.controls['id'].enable();//habilita input
      this.updateArea();
    }
  }

  updateArea(){
    this.cyadService.putAreaInvestigacion(this.areaForm.value)
    .subscribe({
      next:(res)=>{
        console.log(res);
        alert("Area update succesfully");
        this.areaForm.reset();
        this.dialogRef.close('update');
      },
      error:()=>{
        alert("error while update the area");
      }

    })
  }

}
