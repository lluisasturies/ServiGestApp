import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Componentes
import { AddViviendaComponent } from './viviendas/componentes/add-vivienda/add-vivienda.component';
import { VerViviendaComponent } from './viviendas/componentes/ver-vivienda/ver-vivienda.component';
import { ViviendasComponent } from './viviendas/componentes/viviendas.component';
import { ClientesComponent } from './clientes/componentes/clientes.component';
import { VerClienteComponent } from './clientes/componentes/ver-cliente/ver-cliente.component';
import { AddClienteComponent } from './clientes/componentes/add-cliente/add-cliente.component';
import { UpdateViviendaComponent } from './viviendas/componentes/update-vivienda/update-vivienda.component';
import { InicioComponent } from './inicio/componentes/inicio.component';
import { LoginComponent } from './componentes/login/login.component';
import { LogoutComponent } from './componentes/logout/logout.component';
import { UsuariosComponent } from './usuarios/componentes/usuarios.component';
import { AddUsuarioComponent } from './usuarios/componentes/add-usuario/add-usuario.component';
import { UpdateUsuarioComponent } from './usuarios/componentes/update-usuario/update-usuario.component';
import { OrdenesComponent } from './ordenes/componentes/ordenes.component';
import { VerOrdenComponent } from './ordenes/componentes/ver-orden/ver-orden.component';
import { UpdateOrdenComponent } from './ordenes/componentes/update-orden/update-orden.component';
import { EmpresasComponent } from './empresas/componentes/empresas.component';
import { AddEmpresaComponent } from './empresas/componentes/add-empresa/add-empresa.component';
import { UpdateEmpresaComponent } from './empresas/componentes/update-empresa/update-empresa.component';

// Servicios
import { GuardService as guard } from './servicios/guard.service';

const routes: Routes = [
  {path: '', component: InicioComponent},
  {path: 'inicio', component: InicioComponent},

  // Viviendas
  { path: 'viviendas', component: ViviendasComponent, canActivate: [guard], data: { expectedRol: ['admin', 'tecnico']} },
  { path: 'viviendas/ver/:idVivienda', component: VerViviendaComponent, canActivate: [guard], data: { expectedRol: ['admin', 'tecnico']} },
  { path: 'viviendas/crear', component: AddViviendaComponent, canActivate: [guard], data: { expectedRol: ['admin', 'tecnico']} },
  { path: 'viviendas/editar/:idVivienda', component: UpdateViviendaComponent, canActivate: [guard], data: { expectedRol: ['admin', 'tecnico']}},

  // Ordenes
  { path: 'ordenes', component: OrdenesComponent, canActivate: [guard], data: { expectedRol: ['admin', 'tecnico']} },
  { path: 'ordenes/ver/:idOrden', component: VerOrdenComponent, canActivate: [guard], data: { expectedRol: ['admin', 'tecnico']} },
  { path: 'ordenes/editar/:idOrden', component: UpdateOrdenComponent, canActivate: [guard], data: { expectedRol: ['admin', 'tecnico']}},

  // Clientes
  { path: 'clientes', component: ClientesComponent, canActivate: [guard], data: { expectedRol: ['admin', 'tecnico']} },
  { path: 'clientes/ver/:idCliente', component: VerClienteComponent, canActivate: [guard], data: { expectedRol: ['admin', 'tecnico']} },
  { path: 'clientes/crear', component: AddClienteComponent, canActivate: [guard], data: { expectedRol: ['admin', 'tecnico']} },

  // Empresas
  { path: 'empresas', component: EmpresasComponent, canActivate: [guard], data: { expectedRol: ['admin']} },
  { path: 'empresas/crear', component: AddEmpresaComponent, canActivate: [guard], data: { expectedRol: ['admin']} },
  { path: 'empresas/editar/idEmpresa', component: UpdateEmpresaComponent, canActivate: [guard], data: { expectedRol: ['admin']} },

  // Usuarios
  { path: 'usuarios', component: UsuariosComponent, canActivate: [guard], data: { expectedRol: ['admin']} },
  { path: 'usuarios/crear', component: AddUsuarioComponent, canActivate: [guard], data: { expectedRol: ['admin']} },
  { path: 'usuarios/editar/:idUsuario', component: UpdateUsuarioComponent, canActivate: [guard], data: { expectedRol: ['admin']} },

  // Login
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: '**', redirectTo: 'inicio', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
