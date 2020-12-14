import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AparatoMarca } from 'src/app/modelos/aparato-marca.model';
import { AparatoTipo } from 'src/app/modelos/aparato-tipo.model';

import { Aparato } from 'src/app/modelos/aparato.model';
import { AparatosMarcasService } from 'src/app/servicios/aparatos-marcas.service';
import { AparatosTiposService } from 'src/app/servicios/aparatos-tipos.service';

import { AparatosService } from 'src/app/servicios/aparatos.service';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';
import { AddAparatoComponent } from './add-aparato/add-aparato.component';
import { AddAparatoMarcaComponent } from './aparatos-marcas/add-aparato-marca/add-aparato-marca.component';
import { AddAparatoTipoComponent } from './aparatos-tipos/add-aparato-tipo/add-aparato-tipo.component';


@Component({
  selector: 'app-aparatos',
  templateUrl: './aparatos.component.html',
  styleUrls: ['./aparatos.component.css']
})
export class AparatosComponent implements OnInit {

  // Variables
  public dtOptions: DataTables.Settings = {};
  public aparatos: Aparato[];
  public marcas: AparatoMarca[];
  public tipos: AparatoTipo[];

  constructor(
    private _aparatos: AparatosService,
    private _tipos: AparatosTiposService,
    private _marcas: AparatosMarcasService,
    private modalService: NgbModal,
    private confirmationDialogService: ConfirmationDialogService
  ) { }

  ngOnInit(): void {
    this.opcionesDt();
    this.obtenerTipos();
    this.obtenerMarcas();
    this.obtenerAparatos();    
  }

  // Opciones del DataTable
  opcionesDt(): void {
    this.dtOptions = {
      pageLength: 25, // Registros por pagina
      language: { url: '//cdn.datatables.net/plug-ins/1.10.11/i18n/Spanish.json' } // Español
    };
  }

  // Obtener todos los Tipos
  obtenerTipos(): void {
    this._tipos.getTipos().subscribe(data => {
      this.tipos = data;
    });
  }

  // Obtener todas las Marcas
  obtenerMarcas(): void {
    this._marcas.getMarcas().subscribe(data => {
      this.marcas = data;
    });
  }

  // Obtener todos los Aparatos
  obtenerAparatos(): void {
    this._aparatos.getAparatos().subscribe(data => {
      this.aparatos = data;
    });
  }

  nuevoAparato() {
    const modalRef = this.modalService.open(AddAparatoComponent);
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  nuevaMarca() {
    const modalRef = this.modalService.open(AddAparatoMarcaComponent);
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  nuevoTipo() {
    const modalRef = this.modalService.open(AddAparatoTipoComponent);
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

}
