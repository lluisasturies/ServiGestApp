import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

// Servicios
import { ViviendasService } from './../../../servicios/viviendas.service';
import { ViviendasAparatosService } from './../../../servicios/viviendas-aparatos.service';

// Modelos
import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { Orden } from 'src/app/modelos/Orden.model';
import { ViviendaAparato } from 'src/app/modelos/vivienda-aparato.model';
import { AddViviendaAparatoComponent } from '../add-vivienda-aparato/add-vivienda-aparato.component';
import { AddOrdenComponent } from '../../ordenes/add-orden/add-orden.component';

@Component({
  selector: 'app-ver-vivienda',
  templateUrl: './ver-vivienda.component.html',
  styleUrls: ['./ver-vivienda.component.css']
})
export class VerViviendaComponent implements OnInit {

  // Variables
  vivienda: Vivienda = new Vivienda();
  ordenes: Orden[];
  aparatos: ViviendaAparato[];

  constructor(
    private _viviendas: ViviendasService,
    private _viviendasAparatos: ViviendasAparatosService,
    private route: ActivatedRoute,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    const idVivienda = this.route.snapshot.params.idVivienda;

    this.obtenerVivienda(idVivienda);
  }

  // Obtener la vivienda
  obtenerVivienda(idVivienda: number): void {
    this._viviendas.getVivienda(idVivienda).subscribe(data => {
      this.vivienda = data;
    });
  }

  // Borrar un Aparato de la Vivienda
  borrarViviendaAparato(viviendaAparato: ViviendaAparato) {
    this._viviendasAparatos.deleteViviendaAparato(viviendaAparato).subscribe(data => {
      this.aparatos = this.aparatos.filter(v => v !== viviendaAparato);
    });
  }

  // Modal Nueva Orden
  nuevaOrden() {
    const modalRef = this.modalService.open(AddOrdenComponent);
    modalRef.componentInstance.vivienda = this.vivienda;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Modal Asociar Aparato a Vivienda
  addViviendaAparato() {
    const modalRef = this.modalService.open(AddViviendaAparatoComponent);
    modalRef.componentInstance.vivienda = this.vivienda;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

}
