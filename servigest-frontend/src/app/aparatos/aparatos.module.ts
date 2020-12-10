import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DataTablesModule } from 'angular-datatables';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AparatosMarcasComponent } from './componentes/aparatos-marcas/aparatos-marcas.component';
import { AparatosTiposComponent } from './componentes/aparatos-tipos/aparatos-tipos.component';
import { AddAparatoTipoComponent } from './componentes/aparatos-tipos/add-aparato-tipo/add-aparato-tipo.component';
import { AddAparatoMarcaComponent } from './componentes/aparatos-marcas/add-aparato-marca/add-aparato-marca.component';
import { AparatosComponent } from './componentes/aparatos.component';
import { AddAparatoComponent } from './componentes/add-aparato/add-aparato.component';
import { SharedModuleModule } from '../shared-module.module';



@NgModule({
  declarations: [
    AparatosComponent, 
    AparatosMarcasComponent, 
    AparatosTiposComponent, 
    AddAparatoTipoComponent, 
    AddAparatoMarcaComponent, 
    AddAparatoComponent
  ],
  imports: [
    CommonModule,
    SharedModuleModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    DataTablesModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule
  ]
})
export class AparatosModule { }
