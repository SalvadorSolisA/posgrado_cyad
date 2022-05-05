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
import { PlanEstudios } from 'src/app/interfaces/plan-estudios';
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
  areaForm !: FormGroup;
  correoFormGroup !: FormGroup;
  direccionFormGroup !: FormGroup;

  //tabla adeudos
  displayedColumns: String[] = ['id','documento','tipo','activo'];
  data: any[] = [];
  dataSource = new MatTableDataSource<any>(this.data);

  /**Listas */
  listEstados!: EstadoAcademico[];
  listAreaConcentracion !: AreaConcentracion[];
  listNiveles !: Nivel[];
  listPlanes !: PlanEstudios[];

  /**Datos de alumno */
  alumno !: Alumno;
  correosList !: Correo[];
  new_correo !: Correo;
  direccionesList !: Direccion[];
  new_direccion !: Direccion;

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
      ap_paterno : ['', Validators.required],
      ap_materno : ['', Validators.required],
      genero : ['', Validators.required],
      edad : ['', Validators.required],
      fecha_nacimiento : ['', Validators.nullValidator],
      nacionalidad : ['', Validators.nullValidator],
      curp : ['', Validators.nullValidator],
      rfc : ['', Validators.nullValidator],
      matricula : ['', Validators.required],
      orcid : ['', Validators.nullValidator],
      cvu : ['', Validators.nullValidator],
      telefono : ['', Validators.nullValidator],
      correos : this.formBuilder.array([]),
      direcciones : this.formBuilder.array([]),
      area_concentracion : ['', Validators.required],
      estado_academico : ['', Validators.required],
      clave_plan : ['', Validators.nullValidator],
      nivel : ['', Validators.required],
      dedicacion : ['', Validators.required],
      anio_ingreso : ['', Validators.nullValidator],
      creditos_cubiertos : ['', Validators.required],
      creditos_acumulados : ['', Validators.required],
      trimestre_ingreso : ['', Validators.required],
      ultimo_trimestre_inscrito : ['', Validators.nullValidator],
      num_trimestres : ['', Validators.nullValidator],
      promedio : ['', Validators.required],
      escuela_procedencia : ['', Validators.required],
      datos_ingreso_promedio : ['', Validators.nullValidator],
      datos_ingreso_nivel : ['', Validators.nullValidator],
      
      fecha_ingreso : ['', Validators.required],
      fecha_egreso : ['', Validators.nullValidator],
      fecha_titulacion : ['', Validators.nullValidator],
      fecha_disertacion : ['', Validators.nullValidator]

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

    this.cyadService.getPlanes().subscribe({
      next:(res)=>{
        this.listPlanes = res;
      },
      error: (err) => {
        console.error('error al cargar catalogo de planes de estudio', err);
      }
    });
  }

  /**agregar campos de forma dinamica */
  get correos(){
    return this.areaForm.get('correos') as FormArray;
  }

  agregarCorreo(){
    this.correoFormGroup = this.formBuilder.group({
      correo: ['', Validators.required],
      tipo: ['', Validators.required]
    });
    this.correos.push(this.correoFormGroup);
  }

  removerCorreo(indice : number){
    
    console.log('correo a eliminar ',this.correos.at(indice).value);
    
    /**llamada a servicio */
    this.cyadService.deleteCorreoCoincidir(this.correos.at(indice).value.correo, this.correos.at(indice).value.tipo, this.alumno.id).subscribe({
      next:(res)=>{
        console.log('se elimino un correo', res);
      }
    });
    /** se eliminan input del formulario */
    this.correos.removeAt(indice);
  }

  refresh(){
    this.correos.controls.splice(0,this.correos.length);
  }

  /**agregar campos de forma dinamica */
  get direcciones(){
    return this.areaForm.get('direcciones') as FormArray;
  }

  agregarDireccion(){
    this.direccionFormGroup = this.formBuilder.group({
      calle : ['', Validators.required],
      numero : ['', Validators.required],
      colonia : ['', Validators.required],
      delegacion_municipio : ['', Validators.required],
      cp : ['', Validators.required],
      ciudad : ['', Validators.required]
    });
    this.direcciones.push(this.direccionFormGroup);
  }

  removerDireccion(indice : number){
    console.log('direccion a eliminar ',this.direcciones.at(indice).value);
    
    /**llamada a servicio */
    this.cyadService.deleteDireccionCoincidir(this.direcciones.at(indice).value.calle, this.direcciones.at(indice).value.numero, this.alumno.id).subscribe({
      next:(res)=>{
        console.log('se elimino un correo', res);
      }
    });
    this.direcciones.removeAt(indice);
  }

  refresh2(){
    this.direcciones.controls.splice(0,this.direcciones.length);
  }

  getAlumno(id: number) {
    this.cyadService.getAlumnoDetail(id).subscribe(
      {
        next: (res) => {
          this.alumno = res;
          this.setData(this.alumno);
          this.setCorreos(this.alumno);
          this.setDirecciones(this.alumno);
        },
        error: (err) => {
          console.error(err);
        }
      }
    );
  }

  setCorreos(alumno : Alumno){
    if(alumno.correos){
      alumno.correos.forEach(Correo =>{
        this.agregarCorreo();
        this.correoFormGroup.controls['correo'].setValue(Correo.correo);
        this.correoFormGroup.controls['tipo'].setValue(Correo.tipo);
      });
    }
  }

  setDirecciones(alumno : Alumno){
    if(alumno.direcciones){
      alumno.direcciones.forEach(Direccion =>{
        this.agregarDireccion();
        this.direccionFormGroup.controls['calle'].setValue(Direccion.calle);
        this.direccionFormGroup.controls['numero'].setValue(Direccion.numero);
        this.direccionFormGroup.controls['colonia'].setValue(Direccion.colonia);
        this.direccionFormGroup.controls['delegacion_municipio'].setValue(Direccion.delegacion_municipio);
        this.direccionFormGroup.controls['cp'].setValue(Direccion.cp);
        this.direccionFormGroup.controls['ciudad'].setValue(Direccion.ciudad);
      });
    }
  }

  setData(alumno : Alumno){
    if (alumno) {
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
        if(alumno.datos_academicos.areac != null)
        this.areaForm.controls['area_concentracion'].setValue(alumno.datos_academicos.areac.id, '');
        if(alumno.datos_academicos.estado != null)
        this.areaForm.controls['estado_academico'].setValue(alumno.datos_academicos.estado.id);
        if(alumno.datos_academicos.plan != null)
        this.areaForm.controls['clave_plan'].setValue(alumno.datos_academicos.plan.clave);
        if(alumno.datos_academicos.nivel != null)
        this.areaForm.controls['nivel'].setValue(alumno.datos_academicos.nivel.id);
        this.areaForm.controls['dedicacion'].setValue(alumno.datos_academicos.dedicacion);
        this.areaForm.controls['anio_ingreso'].setValue(alumno.datos_academicos.anioIngreso);
        this.areaForm.controls['creditos_cubiertos'].setValue(alumno.datos_academicos.creditosCubiertos);
        this.areaForm.controls['creditos_acumulados'].setValue(alumno.datos_academicos.creditosAcumulados);
        this.areaForm.controls['trimestre_ingreso'].setValue(alumno.datos_academicos.trimestreIngreso);
        this.areaForm.controls['ultimo_trimestre_inscrito'].setValue(alumno.datos_academicos.ulimoTrimestreRe);
        this.areaForm.controls['num_trimestres'].setValue(alumno.datos_academicos.numTrimestres);
        this.areaForm.controls['promedio'].setValue(alumno.datos_academicos.promedio);
        this.areaForm.controls['fecha_ingreso'].setValue(alumno.datos_academicos.fecha_ingreso);
        this.areaForm.controls['fecha_egreso'].setValue(alumno.datos_academicos.fecha_egreso);
        this.areaForm.controls['fecha_titulacion'].setValue(alumno.datos_academicos.fecha_titulacion);
        this.areaForm.controls['fecha_disertacion'].setValue(alumno.datos_academicos.fecha_disertacion);
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
      if (this.areaForm.valid) {//add
        let newAlumno;
        /**recuperando datos del formulario */

        newAlumno = {
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
          telefono: this.areaForm.controls['telefono'].value
        }

        /**llamada al servicio post */ 
        this.cyadService.postAlumno(newAlumno).subscribe({
          next:(res)=>{
            if(res > 0)
              alert('alumno registrado');
              /**Agregando correos */
              for(let item  of this.correos.controls){
                let correo;
                correo = {
                  correo : this.correoFormGroup.controls['correo'].value,
                  tipo : this.correoFormGroup.controls['tipo'].value,
                  alumno : {
                    id : res
                  }
                }
                this.cyadService.postCorreo(correo).subscribe({
                  next:(res)=>{
                    console.log('nuevo correo ',res);
                  }
                });
              }//for correos

              /**Agregando direcciones */
              for(let item  of this.direcciones.controls){
                let direccion;
                direccion = {
                  calle : this.direccionFormGroup.controls['calle'].value,
                  numero : this.direccionFormGroup.controls['numero'].value,
                  colonia : this.direccionFormGroup.controls['colonia'].value,
                  delegacion_municipio : this.direccionFormGroup.controls['delegacion_municipio'].value,
                  cp : this.direccionFormGroup.controls['cp'].value,
                  ciudad : this.direccionFormGroup.controls['ciudad'].value,
                  alumno : {
                    id : res
                  }
                }
                this.cyadService.postDireccion(direccion).subscribe({
                  next:(res)=>{
                    console.log('nuevo direccion ',res);
                  }
                });
              }//for direcciones

              /**Creacion de registro con datos academicos */
              let datos_academicos;
              datos_academicos = {
                alumno : {
                  id : res
                },/**recuperando datos del formulario */
                dedicacion: this.areaForm.controls['dedicacion'].value,
                anioIngreso: this.areaForm.controls['anio_ingreso'].value,
                creditosCubiertos: this.areaForm.controls['creditos_cubiertos'].value,
                creditosAcumulados: this.areaForm.controls['creditos_acumulados'].value,
                trimestreIngreso: this.areaForm.controls['trimestre_ingreso'].value,
                ulimoTrimestreRe: this.areaForm.controls['ultimo_trimestre_inscrito'].value,
                numTrimestres: this.areaForm.controls['num_trimestres'].value,
                promedio: this.areaForm.controls['promedio'].value,
                fecha_ingreso : this.areaForm.controls['fecha_ingreso'].value,
                fecha_egreso : this.areaForm.controls['fecha_egreso'].value,
                fecha_titulacion : this.areaForm.controls['fecha_titulacion'].value,
                fecha_disertacion : this.areaForm.controls['fecha_disertacion'].value,
                
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
              this.cyadService.postDatosAcademicos(datos_academicos).subscribe({
                next:(res)=>{
                  console.log('Se crean datos academicos');
                }
              });

              /**Creacion de registro de datos de ingreso */
              let datos_ingreso;
              datos_ingreso = {
                alumno : {
                  id : res
                },/**recuperando datos del formulario */
                escuelaProcedencia: this.areaForm.controls['escuela_procedencia'].value,
                promedio: this.areaForm.controls['datos_ingreso_promedio'].value,
                nivelStudios: this.areaForm.controls['datos_ingreso_nivel'].value,
              }
              this.cyadService.postDatosIngreso(datos_ingreso).subscribe({
                next:(res)=>{
                  console.log('Se crean datos de ingreso');
                }
              });
          },
          error:(err)=>{
            alert('Error al agregar alumno');
          }
        });
        this.router.navigateByUrl('alumnos');
      }
    }
    else{//update
      this.updateAlumno();
    }
  }

  updateAlumno() {
    /**Obteniendo correos */
    this.correosList = this.alumno.correos;
    this.updateCorreos();

    /**Obteniendo direcciones */
    this.direccionesList = this.alumno.direcciones;
    this.updateDirecciones();

    /**Tomando datos del form */
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
    let datos_ingreso;
    
    datos_ingreso = {
      id : this.alumno.datos_ingreso.id,
      alumno : {
        id : this.alumno.id
      },/**recuperando datos del formulario */
      escuelaProcedencia: this.areaForm.controls['escuela_procedencia'].value,
      promedio: this.areaForm.controls['datos_ingreso_promedio'].value,
      nivelStudios: this.areaForm.controls['datos_ingreso_nivel'].value,
    }
    /**datos academicos */
    let datos_academicos;
    datos_academicos = {
      id : this.alumno.datos_academicos.id,
      alumno : {
        id : this.alumno.id
      },/**recuperando datos del formulario */
      dedicacion: this.areaForm.controls['dedicacion'].value,
      anioIngreso: this.areaForm.controls['anio_ingreso'].value,
      creditosCubiertos: this.areaForm.controls['creditos_cubiertos'].value,
      creditosAcumulados: this.areaForm.controls['creditos_acumulados'].value,
      trimestreIngreso: this.areaForm.controls['trimestre_ingreso'].value,
      ulimoTrimestreRe: this.areaForm.controls['ultimo_trimestre_inscrito'].value,
      numTrimestres: this.areaForm.controls['num_trimestres'].value,
      promedio: this.areaForm.controls['promedio'].value,
      fecha_ingreso : this.areaForm.controls['fecha_ingreso'].value,
      fecha_egreso : this.areaForm.controls['fecha_egreso'].value,
      fecha_titulacion : this.areaForm.controls['fecha_titulacion'].value,
      fecha_disertacion : this.areaForm.controls['fecha_disertacion'].value,
      
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
    /**llamada al servicio update datos de alumno */
    this.cyadService.putAlumno(this.alumno).subscribe({
      next:(res)=>{
        if(res)
          alert('Alumno actualizado');
      },
      error:(err)=>{
        console.error(err);
      }
    });
    /**llamada al servicio update datos academicos */
    this.cyadService.putDatosAcademicos(datos_academicos).subscribe({
      next:(res)=>{
        console.log('se actualizan datos academicos');
      }
    });
    /**llamada al servicio update datos de ingreso */
    this.cyadService.putDatosIngreso(datos_ingreso).subscribe({
      next:(res)=>{
        console.log('se actualizan datos de ingreso');
      }
    });

    this.router.navigateByUrl('alumnos');
  }

  updateCorreos(){
    for(let correo_formulario of this.correos.controls){
      /**validando si existe en bd*/
      let existe_correo = this.existCorreo(correo_formulario);
      if(!existe_correo){
        let new_correo;
        new_correo = {
          correo : this.correoFormGroup.controls['correo'].value,
          tipo : this.correoFormGroup.controls['tipo'].value,
          alumno:{
            id : this.alumno.id
          }
        }
        /**llamada al servicio */
        this.cyadService.postCorreo(new_correo).subscribe({
          next:(res)=>{
            console.log('se registro nuevo correo ',res);
          }
        });
      }//if
    }//for
  }

  existCorreo(correo_formulario : any): boolean {
    let flag = false;
    for (let correo_bd of this.correosList) {
      if (correo_formulario.value.correo == correo_bd.correo && correo_formulario.value.tipo == correo_bd.tipo) {
        flag = true;
        break;
      }
    }
    return flag;
  }

  updateDirecciones(){
    for(let direccion_formulario of this.direcciones.controls){
      /**validando si existe en bd*/
      let existe_direccion = this.existDireccion(direccion_formulario);
      if(!existe_direccion){
        let new_direccion;
        new_direccion = {
          calle: this.direccionFormGroup.controls['calle'].value,
          numero: this.direccionFormGroup.controls['numero'].value,
          colonia: this.direccionFormGroup.controls['colonia'].value,
          delegacion_municipio: this.direccionFormGroup.controls['delegacion_municipio'].value,
          cp: this.direccionFormGroup.controls['cp'].value,
          ciudad: this.direccionFormGroup.controls['ciudad'].value,
          alumno: {
            id: this.alumno.id
          }
        }
        /**llamada al servicio */
        this.cyadService.postDireccion(new_direccion).subscribe({
          next:(res)=>{
            console.log('se registro nueva direccion ',res);
          }
        });
      }//if
    }//for
  }

  existDireccion(direccion_formulario : any) : boolean{
    let flag = false;
    for (let direccion_bd of this.direccionesList) {
      if (direccion_formulario.value.calle == direccion_bd.calle && direccion_formulario.value.numero == direccion_bd.numero) {
        flag = true;
        break;
      }
    }
    return flag;
  }

  cancelar(){
    this.router.navigateByUrl('alumnos');
  }

  openAll(){

  }

  closeAll(){

  }
}
