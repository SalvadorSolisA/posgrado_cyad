import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AreaConcentracion } from 'src/app/interfaces/area-concentracion';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-area-concentracion-detail',
  templateUrl: './area-concentracion-detail.component.html',
  styleUrls: ['./area-concentracion-detail.component.scss']
})
export class AreaConcentracionDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title : string = "Nueva area de concentración"; 
  actionBtn : string = "Guardar";
  
  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<AreaConcentracionDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData: AreaConcentracion  
  ) { }

  ngOnInit(): void {
    //control form
    this.areaForm = this.formBuilder.group({
      id : ['',Validators.nullValidator],
      area : ['',Validators.required],
    });

    if(this.editData){
      this.title = "Actualizar área de concentración";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['area'].setValue(this.editData.area);
    }

    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void{
    this.dialogRef.close();
  }

  addArea(){
    if(!this.editData){
      if(this.areaForm.valid){
        this.cyadService.postAreaConcentracion(this.areaForm.value)
        .subscribe({
          next:(res)=>{
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

  updateArea() {
    this.cyadService.putAreaConcentracion(this.areaForm.value)
    .subscribe({
      next:(res)=>{
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
