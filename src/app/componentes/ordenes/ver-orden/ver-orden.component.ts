import { Component, OnInit } from '@angular/core';

// Servicios
import { OrdenesService } from './../../../servicios/ordenes.service';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

// Modelos
import { Orden } from 'src/app/modelos/Orden.model';

@Component({
  selector: 'app-ver-orden',
  templateUrl: './ver-orden.component.html',
  styleUrls: ['./ver-orden.component.css']
})
export class VerOrdenComponent implements OnInit {

  // Variables
  orden: Orden;

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

}
