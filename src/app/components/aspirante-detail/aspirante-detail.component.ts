import { Component, Inject, Input, NgModule, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatAccordion } from '@angular/material/expansion';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { Aspirante } from 'src/app/interfaces/aspirante';
import { EstadoAspirante } from 'src/app/interfaces/estado-aspirante';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-aspirante-detail',
  templateUrl: './aspirante-detail.component.html',
  styleUrls: ['./aspirante-detail.component.scss']
})
export class AspiranteDetailComponent implements OnInit {
  /**Datos de presentacion */
  nombreAspirante: string = '';
  estadoAspirante: string = '';
  actionBtn: string = 'Guardar';

  areaForm!: FormGroup;
  aspirante !: Aspirante;

  /**Listas */
  listEstados!: EstadoAspirante[];

  //tabla adeudos
  displayedColumns: String[] = ['id','documento','tipo','activo'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);

  @ViewChild(MatAccordion)
  accordion: MatAccordion = new MatAccordion;
  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService : CyadService, private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router) 
  {
    this.route.params.subscribe(
      params=>{
        if(params['id'] > 0)
          this.getAspirante(params['id']);
      }      
    );
  }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      ap_paterno: ['', Validators.nullValidator],
      ap_materno: ['', Validators.nullValidator],
      genero: ['', Validators.nullValidator],
      edad: ['', Validators.nullValidator],
      fecha_nacimiento: ['', Validators.nullValidator],
      nacionalidad: ['', Validators.nullValidator],
      curp: ['', Validators.nullValidator],
      rfc: ['', Validators.nullValidator],
      telefono: ['', Validators.nullValidator],
      correo: ['', Validators.nullValidator],
      estado: ['', Validators.required],
      anio_ingreso: ['', Validators.nullValidator],
      trimestre_ingreso: ['', Validators.nullValidator],
    });

    /**Cargando listas */
    this.cyadService.getEstadosAspirantes().subscribe({
      next: (res) => {
        this.listEstados = res;
      },
      error: (err) => {
        console.error('error al cargar lista estados ', err);
      }
    });
  }

  getAspirante(id: number){
    this.cyadService.getAspiranteDetail(id).subscribe({
      next:(res)=>{
        this.aspirante = res;
        this.setData(this.aspirante);
      },
      error:(err)=>{
        console.error('Error al cargar detalles ',err);
      }
    });
  }

  setData(aspirante : Aspirante){
    if (aspirante) {
      this.nombreAspirante = aspirante.nombre;
      this.estadoAspirante = aspirante.estado.estado;
      this.actionBtn = "Actualizar";
      this.areaForm.controls['nombre'].setValue(aspirante.nombre);
      this.areaForm.controls['ap_paterno'].setValue(aspirante.ap_paterno);
      this.areaForm.controls['ap_materno'].setValue(aspirante.ap_materno);
      this.areaForm.controls['genero'].setValue(aspirante.genero);
      this.areaForm.controls['edad'].setValue(aspirante.edad);
      this.areaForm.controls['fecha_nacimiento'].setValue(aspirante.fecha_nacimiento);
      this.areaForm.controls['nacionalidad'].setValue(aspirante.nacionalidad);
      this.areaForm.controls['curp'].setValue(aspirante.curp);
      this.areaForm.controls['rfc'].setValue(aspirante.rfc);
      this.areaForm.controls['telefono'].setValue(aspirante.telefono);
      this.areaForm.controls['correo'].setValue(aspirante.correo);
      this.areaForm.controls['anio_ingreso'].setValue(aspirante.anio_ingreso);
      this.areaForm.controls['trimestre_ingreso'].setValue(aspirante.trimestre_ingreso);
      this.areaForm.controls['estado'].setValue(aspirante.estado.id);
      /**Tabla de adeudos */
      this.dataSource = new MatTableDataSource(aspirante.adeudos);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    }
  }

  addAspirante() {
    if(!this.aspirante){// Add | Update
      if(this.areaForm.valid){
        
        let newAspirante;
        
        newAspirante = {
          nombre :  this.areaForm.controls['nombre'].value,
          ap_paterno : this.areaForm.controls['ap_paterno'].value,
          ap_materno : this.areaForm.controls['ap_materno'].value,
          curp : this.areaForm.controls['curp'].value,
          rfc : this.areaForm.controls['rfc'].value,
          fecha_nacimiento : this.areaForm.controls['fecha_nacimiento'].value,
          edad: this.areaForm.controls['edad'].value,
          genero: this.areaForm.controls['genero'].value,
          telefono: this.areaForm.controls['telefono'].value,
          correo: this.areaForm.controls['correo'].value,
          nacionalidad: this.areaForm.controls['nacionalidad'].value,
          anio_ingreso: this.areaForm.controls['anio_ingreso'].value,
          trimestre_ingreso: this.areaForm.controls['trimestre_ingreso'].value,
          estado:{
            id: Number(this.areaForm.controls['estado'].value)
          } 
        }
        /**llamada al servicio post */ 
        this.cyadService.postAspirante(newAspirante).subscribe({
          next:(res)=>{
            if(res)
              alert('Aspirante agregado: ');
          },
          error:(err)=>{
            alert('Error al agregar aspirante');
          }
        });
        this.router.navigateByUrl('aspirantes');
      }
      else{
        alert('Los campos con * son obligatorios');
      }
    }
    else{
      this.updateAspirante();
    }
  }

  updateAspirante() {
    /**Tomando datos del form */
    this.aspirante.nombre = this.areaForm.controls['nombre'].value;
    this.aspirante.ap_paterno = this.areaForm.controls['ap_paterno'].value;
    this.aspirante.ap_materno = this.areaForm.controls['ap_materno'].value;
    this.aspirante.genero = this.areaForm.controls['genero'].value;
    this.aspirante.edad = this.areaForm.controls['edad'].value;
    this.aspirante.fecha_nacimiento = this.areaForm.controls['fecha_nacimiento'].value;
    this.aspirante.nacionalidad = this.areaForm.controls['nacionalidad'].value;
    this.aspirante.curp = this.areaForm.controls['curp'].value;
    this.aspirante.rfc = this.areaForm.controls['rfc'].value;
    this.aspirante.telefono = this.areaForm.controls['telefono'].value;
    this.aspirante.correo = this.areaForm.controls['correo'].value;
    this.aspirante.anio_ingreso = this.areaForm.controls['anio_ingreso'].value;
    this.aspirante.trimestre_ingreso = this.areaForm.controls['trimestre_ingreso'].value;
    this.aspirante.estado.id = Number(this.areaForm.controls['estado'].value);

    /**llamada al servicio put */
    this.cyadService.putAspirante(this.aspirante).subscribe({
      next: (res) => {
        console.log('Aspirante actualizado ', res);
        /**Redirije a tabla*/
        if(res)
          this.router.navigateByUrl('aspirantes');
      },
      error: (err) => {
        console.error(err);
      }
    });
  }
}
