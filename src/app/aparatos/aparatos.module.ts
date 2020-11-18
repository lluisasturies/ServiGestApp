import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AparatosComponent } from './componentes/aparatos/aparatos.component';
import { AparatosMarcasComponent } from './componentes/aparatos-marcas/aparatos-marcas.component';
import { AparatosTiposComponent } from './componentes/aparatos-tipos/aparatos-tipos.component';
import { AddAparatoComponent } from './componentes/aparatos-tipos/add-aparato/add-aparato.component';
import { AddAparatoTipoComponent } from './componentes/aparatos-tipos/add-aparato-tipo/add-aparato-tipo.component';
import { AddAparatoMarcaComponent } from './componentes/aparatos-marcas/add-aparato-marca/add-aparato-marca.component';



@NgModule({
  declarations: [AparatosComponent, AparatosMarcasComponent, AparatosTiposComponent, AddAparatoComponent, AddAparatoTipoComponent, AddAparatoMarcaComponent],
  imports: [
    CommonModule
  ]
})
export class AparatosModule { }
