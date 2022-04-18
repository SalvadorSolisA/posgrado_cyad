import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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

  /**variables de documento */
  loading: boolean = false; // bandera
  file !: File; // variable para almacenar

  /**/
  autores_select !: any[];

  constructor(private cyadService: CyadService, private route: Router, private formBuilder: FormBuilder) { }

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

  agregarAutor() {
    const autoresFormGroup = this.formBuilder.group({
      autor: ['', Validators.required],
      orden: ['', Validators.required]
    });
    this.autores.push(autoresFormGroup);
  }

  removerAutor(indice: number) {
    this.autores.removeAt(indice);
  }

  refresh() {
    this.autores.controls.splice(0, this.autores.length);
  }

  // un archivo seleccionado
  onChange( event : any ) {
    this.file = event.target.files[0];
    this.loading = true;
    console.log('se cargo un archivo '+ this.file);
  }

  addProduccion(){
    if (this.firstFormGroup.valid && this.secondFormGroup.valid && this.loading){
      let produccion ;
      let autor;
      let grupo_autores = new Array(autor);
      
      /**creando la estructura */
      produccion = {
        titulo: this.firstFormGroup.controls['titulo'].value,
        descripcion: this.firstFormGroup.controls['descripcion'].value,
        tipo: {
          id: this.firstFormGroup.controls['tipo'].value,
        },
        lgac: this.firstFormGroup.controls['lgac'].value,
        fecha_publicacion: this.firstFormGroup.controls['fecha_publicacion'].value
      }

      /**asesores */
      for (let i = 0; i < this.autores.length; i++) {
        const item = this.autores.at(i).value;
        autor = {
          orden: {
            id: item.orden
          },
          autor: {
            id: item.autor
          },
          produccion: {
            id: 0
          }
        }
        grupo_autores[i] = autor;
      }
      //lamada al servicio
      this.cyadService.upload(produccion, this.file, grupo_autores);
      /**notificacion */
      alert('La produccion se registro con exito.');
      /**redireccion a la tabla de producciones */
      this.route.navigateByUrl('producciones');
    }
  }
}
