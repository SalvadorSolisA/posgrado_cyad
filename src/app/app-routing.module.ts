import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlumnoTableComponent } from "./components/alumno-table/alumno-table.component";
import { ProfesorTableComponent } from "./components/profesor-table/profesor-table.component";
import { ProduccionesDetailComponent } from "./components/producciones-detail/producciones-detail.component";
import { AlumnoDetailComponent } from './components/alumno-detail/alumno-detail.component';
import { ProfesorDetailComponent } from './components/profesor-detail/profesor-detail.component';
import { ProduccionesTableComponent } from './components/producciones-table/producciones-table.component';
import { AreaConcentracionTableComponent } from './components/area-concentracion-table/area-concentracion-table.component';
import { AreaInvestigacionTableComponent } from './components/area-investigacion-table/area-investigacion-table.component';
import { DepartamentoTableComponent } from './components/departamento-table/departamento-table.component';
import { DivisionTableComponent } from './components/division-table/division-table.component';
import { EstadoAcademicoTableComponent } from './components/estado-academico-table/estado-academico-table.component';
import { EstadoAspiranteTableComponent } from './components/estado-aspirante-table/estado-aspirante-table.component';
import { InstitucionesTableComponent } from './components/instituciones-table/instituciones-table.component';
import { NivelTableComponent } from './components/nivel-table/nivel-table.component';
import { PlanTableComponent } from './components/plan-table/plan-table.component';
import { ProyectoTableComponent } from './components/proyecto-table/proyecto-table.component';
import { AspiranteTableComponent } from './components/aspirante-table/aspirante-table.component';
import { AspiranteDetailComponent } from './components/aspirante-detail/aspirante-detail.component';
import { ProyectoDetailComponent } from './components/proyecto-detail/proyecto-detail.component';
import { ProduccionRegisterComponent } from './components/produccion-register/produccion-register.component';
import { OrdenAutorTableComponent } from './components/orden-autor-table/orden-autor-table.component';
import { TipoProduccionTableComponent } from './components/tipo-produccion-table/tipo-produccion-table.component';
import { AutorTableComponent } from './components/autor-table/autor-table.component';
import { TipoProyectoTableComponent } from './components/tipo-proyecto-table/tipo-proyecto-table.component';
import { ProyectoRegisterComponent } from './components/proyecto-register/proyecto-register.component';
import { HomeComponent } from './components/home/home.component';
import { TipoClaveTableComponent } from './components/tipo-clave-table/tipo-clave-table.component';
import { TrimestresTableComponent } from './components/trimestres-table/trimestres-table.component';


const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'alumnos',component:AlumnoTableComponent},
  {path:'alumnoDetail/:id',component:AlumnoDetailComponent},
  {path:'alumnoDetail',component:AlumnoDetailComponent},
  {path:'aspirantes',component:AspiranteTableComponent},
  {path:'aspiranteDetail/:id',component:AspiranteDetailComponent},
  {path:'aspiranteDetail',component:AspiranteDetailComponent},
  {path:'profesores',component: ProfesorTableComponent},
  {path:'profesorDetail',component: ProfesorDetailComponent},
  {path:'profesorDetail/:id',component: ProfesorDetailComponent},
  {path:'autores',component: AutorTableComponent},
  {path:'producciones',component: ProduccionesTableComponent},
  {path:'produccion-register',component: ProduccionRegisterComponent},
  {path:'produccionDetail/:id',component: ProduccionesDetailComponent},
  {path:'proyectos',component: ProyectoTableComponent},
  {path:'proyecto-register',component: ProyectoRegisterComponent},
  {path:'proyectoDetail/:id',component: ProyectoDetailComponent},
  {path:'areas-concentracion',component: AreaConcentracionTableComponent},
  {path:'areas-investigacion',component: AreaInvestigacionTableComponent},
  {path:'departamentos',component: DepartamentoTableComponent},
  {path:'divisiones',component: DivisionTableComponent},
  {path:'estados-academicos',component: EstadoAcademicoTableComponent},
  {path:'estados-aspirantes',component: EstadoAspiranteTableComponent},
  {path:'instituciones',component: InstitucionesTableComponent},
  {path:'niveles',component: NivelTableComponent},
  {path:'planes',component: PlanTableComponent},
  {path:'orden-autores',component: OrdenAutorTableComponent},
  {path:'tipo-produccion',component: TipoProduccionTableComponent},
  {path:'tipo-proyecto',component: TipoProyectoTableComponent},
  {path:'tipo-claves',component: TipoClaveTableComponent},
  {path:'trimestres',component: TrimestresTableComponent},
  {path: '',pathMatch:'full',redirectTo:'home'},
  {path: '**',pathMatch:'full',redirectTo:'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
