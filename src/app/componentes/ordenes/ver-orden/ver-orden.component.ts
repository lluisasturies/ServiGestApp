import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

// Servicios
import { OrdenesService } from 'src/app/servicios/ordenes.service';

// Modelos
import { Orden } from 'src/app/modelos/Orden.model';
import { AddOrdenLineaComponent } from '../add-orden-linea/add-orden-linea.component';

@Component({
  selector: 'app-ver-orden',
  templateUrl: './ver-orden.component.html',
  styleUrls: ['./ver-orden.component.css']
})
export class VerOrdenComponent implements OnInit {

  // Variables
  public orden: Orden;

  constructor(
    private _ordenes: OrdenesService,
    private route: ActivatedRoute,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    const idOrden = this.route.snapshot.params.idOrden;

    this.obtenerOrden(idOrden);
  }

  // Obtener la Orden
  obtenerOrden(idOrden: number): void {
    this._ordenes.getOrden(idOrden).subscribe(data => { this.orden = data; });
  }

  // Modal Asociar Orden a Linea
  addOrdenLinea() {
    const modalRef = this.modalService.open(AddOrdenLineaComponent);
    modalRef.componentInstance.orden = this.orden;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

}
