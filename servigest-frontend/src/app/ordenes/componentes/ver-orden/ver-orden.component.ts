import { OrdenesCitasService } from 'src/app/servicios/ordenes-citas.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbAlertConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';

// Servicios
import { OrdenesService } from 'src/app/servicios/ordenes.service';

// Modelos
import { Orden } from 'src/app/modelos/Orden.model';
import { AddOrdenLineaComponent } from '../add-orden-linea/add-orden-linea.component';
import { AddOrdenCitaComponent } from '../add-orden-cita/add-orden-cita.component';
import { formatDate } from '@angular/common';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';
import { OrdenesLineasService } from 'src/app/servicios/ordenes-lineas.service';
import { OrdenLinea } from 'src/app/modelos/Orden-linea.model';
import { OrdenCita } from 'src/app/modelos/orden-cita.model';
import { UpdateOrdenComponent } from '../update-orden/update-orden.component';

@Component({
  selector: 'app-ver-orden',
  templateUrl: './ver-orden.component.html',
  styleUrls: ['./ver-orden.component.css']
})
export class VerOrdenComponent implements OnInit {

  // Variables
  public orden: Orden = new Orden();
  public fechaActual = formatDate(new Date(), 'yyyy-MM-dd', 'en-EN');

  constructor(
    private _ordenes: OrdenesService,
    private _ordenesLineas: OrdenesLineasService,
    private _ordenesCitas: OrdenesCitasService,
    private route: ActivatedRoute,
    private confirmationDialogService: ConfirmationDialogService,
    private modalService: NgbModal,
    private router: Router
  ) { }

  ngOnInit(): void {
    const idOrden = this.route.snapshot.params.idOrden;

    this.obtenerOrden(idOrden);
  }

  // Obtener la Orden
  obtenerOrden(idOrden: number): void {
    this._ordenes.getOrden(idOrden).subscribe(data => {
      this.orden = data;
    });
  }

  // Modal Asociar Orden a Linea
  addOrdenLinea(): void {
    const modalRef = this.modalService.open(AddOrdenLineaComponent);
    modalRef.componentInstance.orden = this.orden;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Modal añadir nueva cita
  addOrdenCita(): void {
    const modalRef = this.modalService.open(AddOrdenCitaComponent);
    modalRef.componentInstance.orden = this.orden;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Cambia el estado de la Orden
  cambiarEstadoOrden(): void {
    this._ordenes.updateEstadoOrden(this.orden.idOrden).subscribe(data => {
      this.ngOnInit();
    });
  }

  // Borrar un Linea de una Orden
  borrarOrdenLinea(ordenLinea: OrdenLinea) {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar esta linea?')
    .then((confirmed) => {
      if (confirmed) {
        this._ordenesLineas.deleteOrdenLinea(ordenLinea).subscribe(data => {
          this.ngOnInit();
        });
      }
    });
  }

  // Borrar una Cita
  borrarCita(ordenCita: OrdenCita) {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres anular esta cita?')
    .then((confirmed) => {
      if (confirmed) {
        this._ordenesCitas.deleteCita(ordenCita).subscribe(data => {
          this.ngOnInit();
        });
      }
    });
  }

  // Modal Editar Orden
  editarOrden() {
    const modalRef = this.modalService.open(UpdateOrdenComponent);
    modalRef.componentInstance.orden = this.orden;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Borrar una Orden
  borrarOrden() {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar esta orden?')
    .then((confirmed) => {
      if (confirmed) {
        this._ordenes.deleteOrden(this.orden).subscribe(data => {
          this.router.navigate(['viviendas/ver/' + this.orden.vivienda.idVivienda]);
        });
      }
    });
  }

}
