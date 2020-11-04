import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

// Modulos
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { DataTablesModule } from 'angular-datatables';
import { ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Componentes
import { AppComponent } from './app.component';
import { LoginComponent } from './componentes/login/login.component';
import { InicioComponent } from './componentes/inicio/inicio.component';
import { LogoutComponent } from './componentes/logout/logout.component';
import { AddUsuarioComponent } from './componentes/usuarios/add-usuario/add-usuario.component';
import { UpdateUsuarioComponent } from './componentes/usuarios/update-usuario/update-usuario.component';
import { UsuariosComponent } from './componentes/usuarios/usuarios.component';
import { AddContactoComponent } from './clientes/componentes/add-contacto/add-contacto.component';

// Servicios
import { interceptorProvider } from './servicios/interceptor.service';
import { EmpresasComponent } from './componentes/empresas/empresas.component';
import { AddEmpresaComponent } from './componentes/empresas/add-empresa/add-empresa.component';
import { UpdateEmpresaComponent } from './componentes/empresas/update-empresa/update-empresa.component';
import { ViviendasModule } from './viviendas/viviendas.module';
import { ClientesModule } from './clientes/clientes.module';
import { OrdenesModule } from './ordenes/ordenes.module';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    InicioComponent,
    LogoutComponent,
    AddUsuarioComponent,
    UpdateUsuarioComponent,
    UsuariosComponent,
    AddContactoComponent,
    EmpresasComponent,
    AddEmpresaComponent,
    UpdateEmpresaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    DataTablesModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
    ViviendasModule,
    ClientesModule,
    OrdenesModule
  ],
  providers: [
    interceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
