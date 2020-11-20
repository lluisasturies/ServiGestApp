import { OrdenesService } from 'src/app/servicios/ordenes.service';
import { Orden } from 'src/app/modelos/Orden.model';
import { Component, OnInit } from '@angular/core';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UpdateOrdenComponent } from './update-orden/update-orden.component';

@Component({
  selector: 'app-ordenes',
  templateUrl: './ordenes.component.html',
  styleUrls: ['./ordenes.component.css']
})
export class OrdenesComponent implements OnInit {

  // Variables
  public dtOptions: DataTables.Settings = {};
  public ordenes: Orden[];

  constructor(
    private _ordenes: OrdenesService,
    private modalService: NgbModal,
    private confirmationDialogService: ConfirmationDialogService
  ) { }

  ngOnInit(): void {
    this.opcionesDt();
    this.obtenerOrdenes();
  }

  // Opciones del DataTable
  opcionesDt(): void {
    this.dtOptions = {
      pageLength: 25, // Registros por pagina
      language: { url: '//cdn.datatables.net/plug-ins/1.10.11/i18n/Spanish.json' } // Español
    };
  }

  // Obtengo las Ordenes
  obtenerOrdenes(): void {
    this._ordenes.getOrdenes().subscribe(data => {
      this.ordenes = data;
    });
  }

  // Cambia el estado de la Orden
  cambiarEstadoOrden(idOrden): void {
    this._ordenes.updateEstadoOrden(idOrden).subscribe(data => {
      this.ngOnInit();
    });
  }

  // Borrar una Orden
  borrarOrden(orden: Orden) {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar esta orden?')
    .then((confirmed) => {
      if (confirmed) {
        this._ordenes.deleteOrden(orden).subscribe(data => {
          this.ordenes = this.ordenes.filter(v => v !== orden);
        });
      }
    });
  }

  // Modal Editar Orden
  editarOrden(orden: Orden) {
    const modalRef = this.modalService.open(UpdateOrdenComponent);
    modalRef.componentInstance.orden = orden;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

}
