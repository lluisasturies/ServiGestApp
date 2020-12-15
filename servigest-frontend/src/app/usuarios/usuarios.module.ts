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
import { UsuariosComponent } from '../usuarios/componentes/usuarios.component';
import { AddUsuarioComponent } from '../usuarios/componentes/add-usuario/add-usuario.component';
import { UpdateUsuarioComponent } from '../usuarios/componentes/update-usuario/update-usuario.component';
import { UpdateUsuarioPasswordComponent } from './componentes/update-usuario-password/update-usuario-password.component';
import { PanelUsuarioComponent } from './componentes/panel-usuario/panel-usuario.component';



@NgModule({
  declarations: [
    UsuariosComponent,
    AddUsuarioComponent,
    UpdateUsuarioComponent,
    UpdateUsuarioPasswordComponent,
    PanelUsuarioComponent
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
    BrowserAnimationsModule
  ]
})
export class UsuariosModule { }
