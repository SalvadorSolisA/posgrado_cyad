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
  {path:'area-concentracion/:id',component: AreaConcentracionDetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
