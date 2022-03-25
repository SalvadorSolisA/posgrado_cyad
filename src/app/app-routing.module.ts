import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlumnoTableComponent } from "./components/alumno-table/alumno-table.component";
import { ProfesorTableComponent } from "./components/profesor-table/profesor-table.component";
import { ProduccionesDetailComponent } from "./components/producciones-detail/producciones-detail.component";
import { AlumnoDetailComponent } from './components/alumno-detail/alumno-detail.component';
import { ProfesorDetailComponent } from './components/profesor-detail/profesor-detail.component';
import { ProduccionesTableComponent } from './components/producciones-table/producciones-table.component';
import { AreaConcentracionTableComponent } from './components/area-concentracion-table/area-concentracion-table.component';
import { AreaConcentracionDetailComponent } from './components/area-concentracion-detail/area-concentracion-detail.component';
import { AreaInvestigacionTableComponent } from './components/area-investigacion-table/area-investigacion-table.component';
import { DepartamentoTableComponent } from './components/departamento-table/departamento-table.component';
import { DivisionTableComponent } from './components/division-table/division-table.component';
import { EstadoAcademicoTableComponent } from './components/estado-academico-table/estado-academico-table.component';
import { EstadoAspiranteTableComponent } from './components/estado-aspirante-table/estado-aspirante-table.component';
import { InstitucionesTableComponent } from './components/instituciones-table/instituciones-table.component';
import { NivelTableComponent } from './components/nivel-table/nivel-table.component';
import { PlanTableComponent } from './components/plan-table/plan-table.component';

const routes: Routes = [
  {
    path:'home',
    redirectTo: 'home',
    pathMatch: 'full',
  },
  {path:'alumnos',component:AlumnoTableComponent},
  {path:'alumnoDetail/:id',component:AlumnoDetailComponent},
  {path:'profesores',component: ProfesorTableComponent},
  {path:'profesorDetail/:id',component: ProfesorDetailComponent},
  {path:'producciones',component: ProduccionesTableComponent},
  {path:'produccionDetail/:id',component: ProduccionesDetailComponent},
  {path:'areas-concentracion',component: AreaConcentracionTableComponent},
  {path:'areas-investigacion',component: AreaInvestigacionTableComponent},
  {path:'departamentos',component: DepartamentoTableComponent},
  {path:'divisiones',component: DivisionTableComponent},
  {path:'estados-academicos',component: EstadoAcademicoTableComponent},
  {path:'estados-aspirantes',component: EstadoAspiranteTableComponent},
  {path:'instituciones',component: InstitucionesTableComponent},
  {path:'niveles',component: NivelTableComponent},
  {path:'planes',component: PlanTableComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
