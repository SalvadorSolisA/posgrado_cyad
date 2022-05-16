import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Autor } from 'src/app/interfaces/autor';
import { OrdenAutor } from 'src/app/interfaces/orden-autor';
import { TipoProduccion } from 'src/app/interfaces/tipo-produccion';
import { CyadService } from 'src/app/service/cyad.service';


@Component({
  selector: 'app-producciones-detail',
  templateUrl: './producciones-detail.component.html',
  styleUrls: ['./producciones-detail.component.scss']
})
export class ProduccionesDetailComponent implements OnInit {

  produccion_ !: any;
  
  firstFormGroup!: FormGroup;
  secondFormGroup!: FormGroup;
  autoresFormGroup!: FormGroup;

  /**listas */
  listAutores !: Autor[];
  listTiposProducciones !: TipoProduccion[];
  listOrden !: OrdenAutor[];

  constructor(
    private cyadService: CyadService, 
    private formBuilder: FormBuilder,  
    private activatedRouter : ActivatedRoute,
    private router : Router) {
    this.activatedRouter.params.subscribe(
      params=>{
        if(params['id'] > 0)
          this.getProduccion(params['id']);
      }
    )
  }

  ngOnInit(): void {
    this.firstFormGroup = this.formBuilder.group({
      tipo : ['', Validators.required],
      titulo: ['', Validators.required],
      descripcion: ['', Validators.required],
      fecha_publicacion: ['', Validators.required],
      lgac: ['', Validators.required]
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

    this.cyadService.getTiposProduccion().subscribe({
      next:(res)=>{
        this.listTiposProducciones = res;
      }
    });


    this.cyadService.getOrdenAutores().subscribe({
      next:(res)=>{
        this.listOrden = res;
      }
    });
  }//ngOnInit

  /**obtener datos del proyecto */
  getProduccion(id : number){
    this.cyadService.getProduccionDetail(id).subscribe({
      next:(res)=>{
        this.produccion_ = res;
        this.setData(this.produccion_);
      },
      error:(err)=>{
        console.error(err);
      }
    });
  }

  /**enviar datos a los campos del form */
  setData(produccion : any){
      this.firstFormGroup.controls['tipo'].setValue(produccion.tipo.id);
      this.firstFormGroup.controls['titulo'].setValue(produccion.titulo);
      this.firstFormGroup.controls['descripcion'].setValue(produccion.descripcion);
      this.firstFormGroup.controls['fecha_publicacion'].setValue(produccion.fecha_publicacion);
      this.firstFormGroup.controls['lgac'].setValue(produccion.lgac);

      /**grupo autores */
      if(produccion.autores != null)//si existe grupo de protocolo
      for(let autor of produccion.autores){
        this.agregarAutor();
        this.autoresFormGroup.controls['autor'].setValue(autor.autor.id);
        this.autoresFormGroup.controls['orden'].setValue(autor.orden.id);
      }
  }

  /**agregar campos de forma dinamica */
  get autores(){
    return this.secondFormGroup.get('autores') as FormArray;
  }

  agregarAutor(){
    this.autoresFormGroup = this.formBuilder.group({
      autor: ['', Validators.required],
      orden : ['', Validators.required]
    });
    this.autores.push(this.autoresFormGroup);
  }

  removerAutor(indice : number){
    let relacion_grupo;
    relacion_grupo = {
      autor : this.autores.at(indice).value.autor,
      orden : this.autores.at(indice).value.orden
    }

    if(relacion_grupo.autor != '' && relacion_grupo.orden != ''){
      if(this.existAutor(relacion_grupo)){
        this.cyadService.deleteGruposAutores(this.produccion_.autores[indice].id).subscribe({
          next:(res)=>{
            console.log('se elimina autor ',res);
          }
        });
      }
    }
    this.autores.removeAt(indice);
  }

  refresh(){
    this.autores.controls.splice(0,this.autores.length);
  }

  updateProduccion(){
    let produccion;

    produccion = {
      id : this.produccion_.id,
     tipo : {
       id : this.firstFormGroup.controls['tipo'].value
      },
      titulo : this.firstFormGroup.controls['titulo'].value,
      descripcion : this.firstFormGroup.controls['descripcion'].value,
      fecha_publicacion : this.firstFormGroup.controls['fecha_publicacion'].value,
      lgac : this.firstFormGroup.controls['lgac'].value,
    }

    /**llamada al servicio */
    this.cyadService.putProduccion(produccion).subscribe({
      next:(res)=>{
        alert('Produccion actualizada');
        this.router.navigateByUrl('producciones');
      }
    });

    /**grupo de autores*/
    let existAutor : boolean;
    for(let elemnt of this.autores.controls){
      existAutor = this.existAutor(elemnt.value);
      if(!existAutor){
        /**se registra */
        let newAutor;
        newAutor = {
          produccion :{
            id : this.produccion_.id
          },
          orden : {
            id : this.autoresFormGroup.controls['orden'].value
          },
          autor :{
            id : this.autoresFormGroup.controls['autor'].value
          }

        }

        /**llamada a servicio */
        this.cyadService.postGruposAutores(newAutor).subscribe({
          next:(res)=>{
            console.log('autor registrado');
          }
        });
        
      }else{
        /**se actualiza */
        let newAutor;
        let id_grupo_autor : number;

        id_grupo_autor = this.getIdGrupo(elemnt.value);
        newAutor = {
          id: id_grupo_autor,
          produccion :{
            id : this.produccion_.id
          },
          orden : {
            id : elemnt.value.orden
          },
          autor :{
            id : elemnt.value.autor,
          }

        }

        /**llamada a servicio */
        this.cyadService.putGrupoProtocolo(newAutor).subscribe({
          next:(res)=>{
            console.log('autor registrado ',res);
          }
        });
      }
    }// for
    
  }//update

  existAutor(autor : any) : boolean{
    let flag : boolean = false;
    for(let item of this.produccion_.autores){
      if(autor.autor == item.autor.id && autor.orden == item.orden.id){
        flag = true;
        break;
      }
    }
    
    return flag;
  }


  getIdGrupo(autor : any) : number{
    let indice :  number = -1;
    for(let item of this.produccion_.autores){
      if(autor.autor == item.autor.id){
        indice = item.id;
        break;
      }
    }
    return indice;
  }
}
