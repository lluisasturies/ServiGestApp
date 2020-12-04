import { SortByPipe } from './pipes/sort-by.pipe';
import { InicioModule } from './inicio/inicio.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// Modulos
import { AppRoutingModule } from './app-routing.module';;
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

// Componentes
import { AppComponent } from './app.component';

// Servicios
import { interceptorProvider } from './servicios/interceptor.service';
import { ViviendasModule } from './viviendas/viviendas.module';
import { ClientesModule } from './clientes/clientes.module';
import { OrdenesModule } from './ordenes/ordenes.module';
import { EmpresasModule } from './empresas/empresas.module';
import { UsuariosModule } from './usuarios/usuarios.module';
import { ConfirmationDialogComponent } from './componentes/confirmation-dialog/confirmation-dialog.component';
import { ConfirmationDialogService } from './servicios/confirmation-dialog.service';
import { AparatosModule } from './aparatos/aparatos.module';
import { SharedModuleModule } from './shared-module.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    BrowserModule,
    SharedModuleModule,
    InicioModule,
    ViviendasModule,
    ClientesModule,
    OrdenesModule,
    EmpresasModule,
    AparatosModule,
    UsuariosModule
  ],
  providers: [
    interceptorProvider,
    ConfirmationDialogService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
