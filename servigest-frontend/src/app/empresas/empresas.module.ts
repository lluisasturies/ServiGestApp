import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DataTablesModule } from 'angular-datatables';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Componentes
import { EmpresasComponent } from './componentes/empresas.component';
import { AddEmpresaComponent } from './componentes/add-empresa/add-empresa.component';
import { UpdateEmpresaComponent } from './componentes/update-empresa/update-empresa.component';
import { VerEmpresaComponent } from './componentes/ver-empresa/ver-empresa.component';
import { AddEmpresaContactoComponent } from './componentes/add-empresa-contacto/add-empresa-contacto.component';
import { SharedModuleModule } from '../shared-module.module';



@NgModule({
  declarations: [
    EmpresasComponent,
    AddEmpresaComponent,
    UpdateEmpresaComponent,
    VerEmpresaComponent,
    AddEmpresaContactoComponent
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
export class EmpresasModule { }
