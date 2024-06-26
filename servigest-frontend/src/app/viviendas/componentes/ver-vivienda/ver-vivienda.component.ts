import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

// Servicios
import { ViviendasService } from './../../../servicios/viviendas.service';
import { ViviendasAparatosService } from './../../../servicios/viviendas-aparatos.service';

// Modelos
import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { Orden } from 'src/app/modelos/Orden.model';
import { ViviendaAparato } from 'src/app/modelos/vivienda-aparato.model';
import { AddViviendaAparatoComponent } from 'src/app/viviendas/componentes/add-vivienda-aparato/add-vivienda-aparato.component';
import { AddOrdenComponent } from 'src/app/ordenes/componentes/add-orden/add-orden.component';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';
import { UpdateViviendaComponent } from '../update-vivienda/update-vivienda.component';

@Component({
  selector: 'app-ver-vivienda',
  templateUrl: './ver-vivienda.component.html',
  styleUrls: ['./ver-vivienda.component.css']
})
export class VerViviendaComponent implements OnInit {

  // Variables
  public vivienda: Vivienda = new Vivienda();
  public ordenes: Orden[];
  public aparatos: ViviendaAparato[];

  constructor(
    private _viviendas: ViviendasService,
    private _viviendasAparatos: ViviendasAparatosService,
    private confirmationDialogService: ConfirmationDialogService,
    private route: ActivatedRoute,
    private modalService: NgbModal,
    private router: Router
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
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar este aparato?')
    .then((confirmed) => {
      if (confirmed) {
        this._viviendasAparatos.deleteViviendaAparato(viviendaAparato).subscribe(data => {
          this.ngOnInit();
        });
      }
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

  // Modal Editar Vivienda
  editarVivienda() {
    const modalRef = this.modalService.open(UpdateViviendaComponent);
    modalRef.componentInstance.vivienda = this.vivienda;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Borrar una Vivienda
  borrarVivienda() {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar esta vivienda?')
    .then((confirmed) => {
      if (confirmed) {
        this._viviendas.deleteVivienda(this.vivienda).subscribe(data => {
          this.router.navigate(['viviendas']);
        });
      }
    });
  }

}
