import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Trimestre } from 'src/app/interfaces/trimestre';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-trimestres-detail',
  templateUrl: './trimestres-detail.component.html',
  styleUrls: ['./trimestres-detail.component.scss']
})
export class TrimestresDetailComponent implements OnInit {

  areaForm!: FormGroup;
  title: string = "Nuevo trimestre";
  actionBtn: string = "Guardar";

  constructor(
    private cyadService: CyadService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<TrimestresDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public editData: Trimestre) { }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      id: ['', Validators.nullValidator],
      fecha_inicio: ['', Validators.required],
      fecha_fin: ['', Validators.required],
      trimestre: ['', Validators.required]
    });

    /*Al iniciar el cuadro de dialogo
    si se trata de una edición*/
    if (this.editData) {
      this.title = "Actualizar datos de trimestre";
      this.actionBtn = "Actualizar";
      this.areaForm.controls['id'].setValue(this.editData.id);
      this.areaForm.controls['fecha_inicio'].setValue(this.editData.fecha_inicio);
      this.areaForm.controls['fecha_fin'].setValue(this.editData.fecha_fin);
      this.areaForm.controls['trimestre'].setValue(this.editData.trimestre);
    }

    /*El id es un campo gestionado por el servicio*/
    this.areaForm.controls['id'].disable();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  addTrimestre() {
    if (!this.editData) {
      if (this.areaForm.valid) {
        this.cyadService.postTrimestre(this.areaForm.value)
          .subscribe({
            next: (res) => {
              console.log(res);
              alert("Trimestre add successfully");
              this.areaForm.reset();
              this.dialogRef.close('save');
            },
            error: (err) => {
              alert("Error while adding the trimestre " + err);
            }
          })
      }
    }
    else {
      this.areaForm.controls['id'].enable();//habilita input
      this.updateTrimestre();
    }
  }

  updateTrimestre() {
    console.log('data: ', this.areaForm.value);
    this.cyadService.putTrimestre(this.areaForm.value)
      .subscribe({
        next: (res) => {
          console.log(res);
          alert("Trimestre update succesfully");
          this.areaForm.reset();
          this.dialogRef.close('update');
        },
        error: () => {
          alert("error while update the trimestre");
        }

      })
  }

}
