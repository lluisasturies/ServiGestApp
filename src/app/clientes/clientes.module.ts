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
import { ClientesComponent } from '../clientes/componentes/clientes.component';
import { VerClienteComponent } from '../clientes/componentes/ver-cliente/ver-cliente.component';
import { AddClienteComponent } from '../clientes/componentes/add-cliente/add-cliente.component';
import { AddContactoComponent } from './componentes/add-contacto/add-contacto.component';
import { UpdateClienteComponent } from './componentes/update-cliente/update-cliente.component';



@NgModule({
  declarations: [
    ClientesComponent,
    VerClienteComponent,
    AddClienteComponent,
    AddContactoComponent,
    UpdateClienteComponent,
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
export class ClientesModule { }
