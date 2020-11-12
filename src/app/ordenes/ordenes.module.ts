import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from '../app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DataTablesModule } from 'angular-datatables';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Componentes
import { OrdenesComponent } from '../ordenes/componentes/ordenes.component';
import { VerOrdenComponent } from '../ordenes/componentes/ver-orden/ver-orden.component';
import { AddOrdenComponent } from '../ordenes/componentes/add-orden/add-orden.component';
import { UpdateOrdenComponent } from '../ordenes/componentes/update-orden/update-orden.component';
import { AddOrdenLineaComponent } from '../ordenes/componentes/add-orden-linea/add-orden-linea.component';
import { AddOrdenCitaComponent } from './componentes/add-orden-cita/add-orden-cita.component';



@NgModule({
  declarations: [
    OrdenesComponent,
    VerOrdenComponent,
    AddOrdenComponent,
    UpdateOrdenComponent,
    AddOrdenLineaComponent,
    AddOrdenCitaComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    DataTablesModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
  ]
})
export class OrdenesModule { }
