import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { LayoutModule } from '@angular/cdk/layout';
import { MatSelectModule } from '@angular/material/select';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProduccionesDetailComponent } from './components/producciones-detail/producciones-detail.component';
import { HeaderComponent } from './components/header/header.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatDividerModule } from '@angular/material/divider';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';
import { MatChipsModule } from '@angular/material/chips';

import { AutoresDetailComponent } from './components/autores-detail/autores-detail.component';
import { AutorTableComponent } from './components/autor-table/autor-table.component';
import { ExampleComponent } from './components/example/example.component';
import { MenuComponent } from './components/menu/menu.component';
import { AlumnoTableComponent } from './components/alumno-table/alumno-table.component';
import { ProfesorTableComponent } from './components/profesor-table/profesor-table.component';
import { ProfesorDetailComponent } from './components/profesor-detail/profesor-detail.component';
import { AlumnoDetailComponent } from './components/alumno-detail/alumno-detail.component';
import { ProduccionesTableComponent } from './components/producciones-table/producciones-table.component';
import { AreaConcentracionTableComponent } from './components/area-concentracion-table/area-concentracion-table.component';
import { AreaConcentracionDetailComponent } from './components/area-concentracion-detail/area-concentracion-detail.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AreaInvestigacionTableComponent } from './components/area-investigacion-table/area-investigacion-table.component';
import { AreaInvestigacionDetailComponent } from './components/area-investigacion-detail/area-investigacion-detail.component';
import { DepartamentoTableComponent } from './components/departamento-table/departamento-table.component';
import { DepartamentoDetailComponent } from './components/departamento-detail/departamento-detail.component';
import { DivisionTableComponent } from './components/division-table/division-table.component';
import { DivisionDetailComponent } from './components/division-detail/division-detail.component';
import { EstadoAcademicoTableComponent } from './components/estado-academico-table/estado-academico-table.component';
import { EstadoAcademicoDetailComponent } from './components/estado-academico-detail/estado-academico-detail.component';
import { EstadoAspiranteTableComponent } from './components/estado-aspirante-table/estado-aspirante-table.component';
import { EstadoAspiranteDetailComponent } from './components/estado-aspirante-detail/estado-aspirante-detail.component';
import { InstitucionesTableComponent } from './components/instituciones-table/instituciones-table.component';
import { InstitucionesDetailComponent } from './components/instituciones-detail/instituciones-detail.component';
import { LgacTableComponent } from './components/lgac-table/lgac-table.component';
import { LgacDetailComponent } from './components/lgac-detail/lgac-detail.component';
import { NivelTableComponent } from './components/nivel-table/nivel-table.component';
import { NivelDetailComponent } from './components/nivel-detail/nivel-detail.component';
import { PlanDetailComponent } from './components/plan-detail/plan-detail.component';
import { PlanTableComponent } from './components/plan-table/plan-table.component';


@NgModule({
  declarations: [
    AppComponent,
    ProduccionesDetailComponent,
    AutoresDetailComponent,
    AutorTableComponent,
    HeaderComponent,
    ExampleComponent,
    MenuComponent,
    AlumnoTableComponent,
    ProfesorTableComponent,
    ProfesorDetailComponent,
    AlumnoDetailComponent,
    ProduccionesTableComponent,
    AreaConcentracionTableComponent,
    AreaConcentracionDetailComponent,
    AreaInvestigacionTableComponent,
    AreaInvestigacionDetailComponent,
    DepartamentoTableComponent,
    DepartamentoDetailComponent,
    DivisionTableComponent,
    DivisionDetailComponent,
    EstadoAcademicoTableComponent,
    EstadoAcademicoDetailComponent,
    EstadoAspiranteTableComponent,
    EstadoAspiranteDetailComponent,
    InstitucionesTableComponent,
    InstitucionesDetailComponent,
    LgacTableComponent,
    LgacDetailComponent,
    NivelTableComponent,
    NivelDetailComponent,
    PlanDetailComponent,
    PlanTableComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatToolbarModule,
    MatCardModule,
    MatIconModule,
    MatTableModule,
    MatFormFieldModule,
    FlexLayoutModule,
    MatMenuModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatSidenavModule,
    MatListModule,
    LayoutModule,
    MatPaginatorModule,
    MatInputModule,
    MatSelectModule,
    MatExpansionModule,
    MatDatepickerModule,
    MatDialogModule,
    ReactiveFormsModule,
    FormsModule,
    MatChipsModule
  ],
  exports:[
    MatToolbarModule,
    MatCardModule,
    MatIconModule,
    MatTableModule,
    MatFormFieldModule,
    FlexLayoutModule,
    MatMenuModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatSidenavModule,
    MatListModule,
    LayoutModule,
    MatPaginatorModule,
    MatInputModule,
    MatSelectModule,
    MatExpansionModule,
    MatDatepickerModule,
    MatDialogModule,
    ReactiveFormsModule,
    FormsModule,
    MatChipsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
