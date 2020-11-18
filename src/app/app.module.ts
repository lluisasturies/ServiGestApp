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

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    BrowserModule,
    InicioModule,
    ViviendasModule,
    ClientesModule,
    OrdenesModule,
    EmpresasModule,
    UsuariosModule
  ],
  providers: [
    interceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
