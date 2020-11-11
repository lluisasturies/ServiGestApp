import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DataTablesModule } from 'angular-datatables';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

// Componentes
import { ViviendasComponent } from 'src/app/viviendas/componentes/viviendas.component';
import { VerViviendaComponent } from 'src/app/viviendas/componentes/ver-vivienda/ver-vivienda.component';
import { AddViviendaComponent } from 'src/app/viviendas/componentes/add-vivienda/add-vivienda.component';
import { UpdateViviendaComponent } from 'src/app/viviendas/componentes/update-vivienda/update-vivienda.component';
import { AddViviendaAparatoComponent } from 'src/app/viviendas/componentes/add-vivienda-aparato/add-vivienda-aparato.component';
import { ConfirmationDialogComponent } from '../componentes/confirmation-dialog/confirmation-dialog.component';
import { ConfirmationDialogService } from '../servicios/confirmation-dialog.service';



@NgModule({
  declarations: [
    ViviendasComponent,
    VerViviendaComponent,
    AddViviendaComponent,
    UpdateViviendaComponent,
    AddViviendaAparatoComponent,
    ConfirmationDialogComponent,
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
  ],
  providers: [ ConfirmationDialogService ],
  entryComponents: [ ConfirmationDialogComponent ],
})
export class ViviendasModule { }
