import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Componentes
import { AddViviendaComponent } from './componentes/viviendas/add-vivienda/add-vivienda.component';
import { VerViviendaComponent } from './componentes/viviendas/ver-vivienda/ver-vivienda.component';
import { ViviendasComponent } from './componentes/viviendas/viviendas.component';
import { ClientesComponent } from './componentes/clientes/clientes.component';
import { VerClienteComponent } from './componentes/clientes/ver-cliente/ver-cliente.component';
import { AddClienteComponent } from './componentes/clientes/add-cliente/add-cliente.component';
import { UpdateViviendaComponent } from './componentes/viviendas/update-vivienda/update-vivienda.component';
import { InicioComponent } from './componentes/inicio/inicio.component';
import { LoginComponent } from './componentes/login/login.component';
import { LogoutComponent } from './componentes/logout/logout.component';
import { UsuariosComponent } from './componentes/usuarios/usuarios.component';
import { AddUsuarioComponent } from './componentes/usuarios/add-usuario/add-usuario.component';
import { UpdateUsuarioComponent } from './componentes/usuarios/update-usuario/update-usuario.component';
import { OrdenesComponent } from './componentes/ordenes/ordenes.component';
import { VerOrdenComponent } from './componentes/ordenes/ver-orden/ver-orden.component';
import { UpdateOrdenComponent } from './componentes/ordenes/update-orden/update-orden.component';
import { EmpresasComponent } from './componentes/empresas/empresas.component';
import { AddEmpresaComponent } from './componentes/empresas/add-empresa/add-empresa.component';
import { UpdateEmpresaComponent } from './componentes/empresas/update-empresa/update-empresa.component';

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
