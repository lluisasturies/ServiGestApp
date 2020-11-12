import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InicioComponent } from './componentes/inicio.component';
import { LoginComponent } from '../componentes/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from '../app-routing.module';



@NgModule({
  declarations: [
    InicioComponent,
    LoginComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule,
  ],
  exports: [
    LoginComponent,
    LoginComponent
  ]
})
export class InicioModule { }
