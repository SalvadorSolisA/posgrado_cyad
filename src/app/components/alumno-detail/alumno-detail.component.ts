import { Component, OnInit, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatAccordion } from '@angular/material/expansion';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { Alumno } from 'src/app/interfaces/alumno';
import { AreaConcentracion } from 'src/app/interfaces/area-concentracion';
import { Correo } from 'src/app/interfaces/correo';
import { Direccion } from 'src/app/interfaces/direccion';
import { EstadoAcademico } from 'src/app/interfaces/estado-academico';
import { Nivel } from 'src/app/interfaces/nivel';
import { CyadService } from 'src/app/service/cyad.service';

@Component({
  selector: 'app-alumno-detail',
  templateUrl: './alumno-detail.component.html',
  styleUrls: ['./alumno-detail.component.scss']
})
export class AlumnoDetailComponent implements OnInit {

  /**Datos de presentacion */
  nombre: string = '';
  estado: string = '';
  actionBtn: string = 'Guardar';

  /**Grupo de formulario */
  areaForm!: FormGroup;

  //tabla adeudos
  displayedColumns: String[] = ['id','documento','tipo','activo'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);

  /**Listas */
  listEstados!: EstadoAcademico[];
  listAreaConcentracion !: AreaConcentracion[];
  listNiveles !: Nivel[];

  /**Datos de alumno */
  alumno!: Alumno;
  correosList !: Correo[];
  direccionesList !: Direccion[];

  @ViewChild(MatAccordion)
  accordion: MatAccordion = new MatAccordion;
  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private cyadService : CyadService, private formBuilder: FormBuilder, private activatedRouter : ActivatedRoute, private router: Router) {
    this.activatedRouter.params.subscribe(
      params=>{
        if(params['id'] > 0)
          this.getAlumno(params['id']);
      }
    );
   }

  ngOnInit(): void {
    /*Agregando validaciones a los input*/
    this.areaForm = this.formBuilder.group({
      nombre : ['', Validators.required],
      ap_paterno : ['', Validators.nullValidator],
      ap_materno : ['', Validators.nullValidator],
      genero : ['', Validators.nullValidator],
      edad : ['', Validators.nullValidator],
      fecha_nacimiento : ['', Validators.nullValidator],
      nacionalidad : ['', Validators.nullValidator],
      curp : ['', Validators.nullValidator],
      rfc : ['', Validators.nullValidator],
      matricula : ['', Validators.nullValidator],
      orcid : ['', Validators.nullValidator],
      cvu : ['', Validators.nullValidator],
      telefono : ['', Validators.nullValidator],
      correos : this.formBuilder.array([]),
      area_concentracion : ['', Validators.nullValidator],
      estado_academico : ['', Validators.nullValidator],
      clave_plan : ['', Validators.nullValidator],
      nivel : ['', Validators.nullValidator],
      dedicacion : ['', Validators.nullValidator],
      anio_ingreso : ['', Validators.nullValidator],
      creditos_cubiertos : ['', Validators.nullValidator],
      creditos_acumulados : ['', Validators.nullValidator],
      trimestre_ingreso : ['', Validators.nullValidator],
      ultimo_trimestre_inscrito : ['', Validators.nullValidator],
      num_trimestres : ['', Validators.nullValidator],
      promedio : ['', Validators.nullValidator],
      escuela_procedencia : ['', Validators.nullValidator],
      datos_ingreso_promedio : ['', Validators.nullValidator],
      datos_ingreso_nivel : ['', Validators.nullValidator],
    });

    /**Cargando catalogos */
    this.cyadService.getEstadosAcademicos().subscribe({
      next: (res) => {
        this.listEstados = res;
      },
      error: (err) => {
        console.error('error al cargar catalogo estados ', err);
      }
    });

    this.cyadService.getAreasConcentracion().subscribe({
      next:(res)=>{
        this.listAreaConcentracion = res;
      },
      error: (err) => {
        console.error('error al cargar catalogo de areas de concentracion ', err);
      }
    });

    this.cyadService.getNiveles().subscribe({
      next:(res)=>{
        this.listNiveles = res;
      },
      error: (err) => {
        console.error('error al cargar catalogo de niveles ', err);
      }
    });
  }

  /**agregar campos de forma dinamica */
  get correos(){
    return this.areaForm.get('correos') as FormArray;
  }

  agregarCorreo(){
    const correoFormGroup = this.formBuilder.group({
      correo: '',
      tipo:''
    });
    this.correos.push(correoFormGroup);
  }

  removerCorreo(indice : number){
    this.correos.removeAt(indice);
  }

  refresh(){
    this.correos.controls.splice(0,this.correos.length);
  }

  getAlumno(id: number) {
    this.cyadService.getAlumnoDetail(id).subscribe(
      {
        next: (res) => {
          this.alumno = res;
          this.setData(this.alumno);
        },
        error: (err) => {
          console.error(err);
        }
      }
    );
  }

  setData(alumno : Alumno){
    if (alumno) {
      //this.nombreAspirante = aspirante.nombre;
      //this.estadoAspirante = aspirante.estado.estado;
      this.actionBtn = "Actualizar";
      this.correosList = this.alumno.correos;
      this.direccionesList = this.alumno.direcciones;

      this.areaForm.controls['nombre'].setValue(alumno.nombre);
      this.areaForm.controls['ap_paterno'].setValue(alumno.ap_paterno);
      this.areaForm.controls['ap_materno'].setValue(alumno.ap_materno);
      this.areaForm.controls['genero'].setValue(alumno.genero);
      this.areaForm.controls['edad'].setValue(alumno.edad);
      this.areaForm.controls['fecha_nacimiento'].setValue(alumno.fecha_nacimiento);
      this.areaForm.controls['nacionalidad'].setValue(alumno.nacionalidad);
      this.areaForm.controls['curp'].setValue(alumno.curp);
      this.areaForm.controls['rfc'].setValue(alumno.rfc);
      this.areaForm.controls['matricula'].setValue(alumno.matricula);
      this.areaForm.controls['orcid'].setValue(alumno.orcid);
      this.areaForm.controls['cvu'].setValue(alumno.cvu);
      this.areaForm.controls['telefono'].setValue(alumno.telefono);

      if (alumno.datos_academicos != null) {
        this.areaForm.controls['area_concentracion'].setValue(alumno.datos_academicos.areac.id, '');
        this.areaForm.controls['estado_academico'].setValue(alumno.datos_academicos.estado.id);
        this.areaForm.controls['clave_plan'].setValue(alumno.datos_academicos.plan.clave);
        this.areaForm.controls['nivel'].setValue(alumno.datos_academicos.nivel.id);
        this.areaForm.controls['dedicacion'].setValue(alumno.datos_academicos.dedicacion);
        this.areaForm.controls['anio_ingreso'].setValue(alumno.datos_academicos.anioIngreso);
        this.areaForm.controls['creditos_cubiertos'].setValue(alumno.datos_academicos.creditosCubiertos);
        this.areaForm.controls['creditos_acumulados'].setValue(alumno.datos_academicos.creditosAcumulados);
        this.areaForm.controls['trimestre_ingreso'].setValue(alumno.datos_academicos.trimestreIngreso);
        this.areaForm.controls['ultimo_trimestre_inscrito'].setValue(alumno.datos_academicos.ulimoTrimestreRe);
        this.areaForm.controls['num_trimestres'].setValue(alumno.datos_academicos.numTrimestres);
        this.areaForm.controls['promedio'].setValue(alumno.datos_academicos.promedio);
      }
      
      if (alumno.datos_ingreso) {
        this.areaForm.controls['escuela_procedencia'].setValue(alumno.datos_ingreso.escuelaProcedencia);
        this.areaForm.controls['datos_ingreso_promedio'].setValue(alumno.datos_ingreso.promedio);
        this.areaForm.controls['datos_ingreso_nivel'].setValue(alumno.datos_ingreso.nivelStudios);
        /**Tabla de adeudos */
        if (alumno.datos_ingreso.adeudos) {
          this.dataSource = new MatTableDataSource(alumno.datos_ingreso.adeudos);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        }
      }
      
    }
  }

  addAlumno(){
    if(!this.alumno){// Add | Update
      if (this.areaForm.valid) {

        let newAlumno;
        /**recuperando datos del formulario */
        newAlumno = {
          direcciones: this.direccionesList,
          correos: this.correosList,
          nombre: this.areaForm.controls['nombre'].value,
          ap_paterno: this.areaForm.controls['ap_paterno'].value,
          ap_materno: this.areaForm.controls['ap_materno'].value,
          genero: this.areaForm.controls['genero'].value,
          edad: this.areaForm.controls['edad'].value,
          fecha_nacimiento: this.areaForm.controls['fecha_nacimiento'].value,
          nacionalidad: this.areaForm.controls['nacionalidad'].value,
          curp: this.areaForm.controls['curp'].value,
          rfc: this.areaForm.controls['rfc'].value,
          matricula: this.areaForm.controls['matricula'].value,
          orcid: this.areaForm.controls['orcid'].value,
          cvu: this.areaForm.controls['cvu'].value,
          telefono: this.areaForm.controls['telefono'].value,
          datos_ingreso: {
            escuelaProcedencia: this.areaForm.controls['escuela_procedencia'].value,
            promedio: this.areaForm.controls['datos_ingreso_promedio'].value,
            nivelStudios: this.areaForm.controls['datos_ingreso_nivel'].value,
          },
          datos_academicos: {
            dedicacion: this.areaForm.controls['dedicacion'].value,
            anioIngreso: this.areaForm.controls['anio_ingreso'].value,
            creditosCubiertos: this.areaForm.controls['creditos_cubiertos'].value,
            creditosAcumulados: this.areaForm.controls['creditos_acumulados'].value,
            trimestreIngreso: this.areaForm.controls['trimestre_ingreso'].value,
            ulimoTrimestreRe: this.areaForm.controls['ultimo_trimestre_inscrito'].value,
            numTrimestres: this.areaForm.controls['num_trimestres'].value,
            promedio: this.areaForm.controls['promedio'].value,
            areac: {
              id: this.areaForm.controls['area_concentracion'].value
            },
            estado: {
              id: this.areaForm.controls['estado_academico'].value
            },
            plan: {
              id: this.areaForm.controls['clave_plan'].value
            },
            nivel: {
              id: this.areaForm.controls['nivel'].value
            }
          }
        }

        /**llamada al servicio post */ 
        this.cyadService.postAlumno(newAlumno).subscribe({
          next:(res)=>{
            if(res)
              alert('alumno agregado: ');
          },
          error:(err)=>{
            alert('Error al agregar alumno');
          }
        });
        this.router.navigateByUrl('alumnos');
      }
    }
    else{
      this.updateAspirante();
    }
  }

  updateAspirante() {
    
    /**Tomando datos del form */
    this.alumno.direcciones = this.direccionesList;
    this.alumno.correos = this.correosList;
    this.alumno.nombre = this.areaForm.controls['nombre'].value;
    this.alumno.ap_paterno = this.areaForm.controls['ap_paterno'].value;
    this.alumno.ap_materno = this.areaForm.controls['ap_materno'].value;
    this.alumno.genero = this.areaForm.controls['genero'].value;
    this.alumno.edad = this.areaForm.controls['edad'].value;
    this.alumno.fecha_nacimiento = this.areaForm.controls['fecha_nacimiento'].value;
    this.alumno.nacionalidad = this.areaForm.controls['nacionalidad'].value;
    this.alumno.curp = this.areaForm.controls['curp'].value;
    this.alumno.rfc = this.areaForm.controls['rfc'].value;
    this.alumno.matricula = this.areaForm.controls['matricula'].value;
    this.alumno.orcid = this.areaForm.controls['orcid'].value;
    this.alumno.cvu = this.areaForm.controls['cvu'].value;
    this.alumno.telefono = this.areaForm.controls['telefono'].value;
    /**datos de ingreso */
    if (this.alumno.datos_ingreso) {
      this.alumno.datos_ingreso.escuelaProcedencia = this.areaForm.controls['escuela_procedencia'].value;
      this.alumno.datos_ingreso.promedio = this.areaForm.controls['datos_ingreso_promedio'].value;
      this.alumno.datos_ingreso.nivelStudios = this.areaForm.controls['datos_ingreso_nivel'].value;
    }
    /**datos academicos */
    if (this.alumno.datos_academicos) {
      this.alumno.datos_academicos.dedicacion = this.areaForm.controls['dedicacion'].value;
      this.alumno.datos_academicos.anioIngreso = this.areaForm.controls['anio_ingreso'].value;
      this.alumno.datos_academicos.creditosCubiertos = this.areaForm.controls['creditos_cubiertos'].value;
      this.alumno.datos_academicos.creditosAcumulados = this.areaForm.controls['creditos_acumulados'].value;
      this.alumno.datos_academicos.trimestreIngreso = this.areaForm.controls['trimestre_ingreso'].value;
      this.alumno.datos_academicos.ulimoTrimestreRe = this.areaForm.controls['ultimo_trimestre_inscrito'].value;
      this.alumno.datos_academicos.numTrimestres = this.areaForm.controls['num_trimestres'].value;
      this.alumno.datos_academicos.promedio = this.areaForm.controls['promedio'].value;
      this.alumno.datos_academicos.areac.id = this.areaForm.controls['area_concentracion'].value;
      this.alumno.datos_academicos.estado.id = this.areaForm.controls['estado_academico'].value;
      this.alumno.datos_academicos.plan.id = this.areaForm.controls['clave_plan'].value;
      this.alumno.datos_academicos.nivel.id = this.areaForm.controls['nivel'].value;
    }
    /**llamada al servicio */
    this.cyadService.putAlumno(this.alumno).subscribe({
      next:(res)=>{
        if(res)
          alert('Alumno actualizado');
      }
    });
  }

  cancelar(){
    this.router.navigateByUrl('alumnos');
  }

  openAll(){

  }

  closeAll(){

  }
}
