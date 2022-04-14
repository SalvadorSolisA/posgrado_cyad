import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Autor } from 'src/app/interfaces/autor';
import { OrdenAutor } from 'src/app/interfaces/orden-autor';
import { TipoProduccion } from 'src/app/interfaces/tipo-produccion';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-produccion-register',
  templateUrl: './produccion-register.component.html',
  styleUrls: ['./produccion-register.component.scss']
})
export class ProduccionRegisterComponent implements OnInit {
  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;

  /**listas */
  listAutores !: Autor[];
  listTipoProducto !: TipoProduccion[];
  listOrden !: OrdenAutor[];

  constructor(private cyadService: CyadService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.firstFormGroup = this.formBuilder.group({
      titulo: ['', Validators.required],
      descripcion: ['', Validators.required],
      tipo : ['', Validators.required],
      lgac: ['', Validators.required],
      fecha_publicacion: ['', Validators.required]
    });
    this.secondFormGroup = this.formBuilder.group({
      autores: this.formBuilder.array([])
    });

    /**cargando listas */
    this.cyadService.getAutores().subscribe({
      next:(res)=>{
        this.listAutores = res;
      }
    });

    this.cyadService.getOrdenAutores().subscribe({
      next:(res)=>{
        this.listOrden = res;
      }
    });

    this.cyadService.getTiposProduccion().subscribe({
      next:(res)=>{
        this.listTipoProducto = res;
      }
    });
  }

  /**agregar campos de forma dinamica */
  get autores(){
    return this.secondFormGroup.get('autores') as FormArray;
  }

  agregarAutor(){
    const autoresFormGroup = this.formBuilder.group({
      autor: '',
      orden: ''
    });
    this.autores.push(autoresFormGroup);
  }

  removerAutor(indice : number){
    this.autores.removeAt(indice);
  }

  refresh(){
    this.autores.controls.splice(0,this.autores.length);
  }

  addProduccion(){
    if (this.firstFormGroup.valid && this.secondFormGroup.valid){
      let produccion ;

      /**creando la estructura */
      produccion = {
        titulo: this.firstFormGroup.controls['titulo'].value,
        descripcion: this.firstFormGroup.controls['descripcion'].value,
        tipo: {
          id: this.firstFormGroup.controls['tipo'].value,
        },
        lgac: this.firstFormGroup.controls['lgac'].value,
        fecha_publicacion: this.firstFormGroup.controls['fecha_publicacion'].value,
        /*autores:{
          id: this.secondFormGroup.controls['autores'].value
        }*/
      }


      /**llamada al servicio */
      this.cyadService.postProduccion(produccion).subscribe({
        next:(res)=>{
          if(res)
            alert('Produccion agregada');
        },
        error:(err)=>{
          alert('Error al crear produccion');
          console.error(err);
        }
      });


    }
  }
}
