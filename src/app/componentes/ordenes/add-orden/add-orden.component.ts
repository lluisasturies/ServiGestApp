import { Component, OnInit, Input } from '@angular/core';
import { formatDate } from '@angular/common';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

// Servicios
import { OrdenesService } from 'src/app/servicios/ordenes.service';
import { EmpresasService } from 'src/app/servicios/empresas.service';

// Modelos
import { Orden } from 'src/app/modelos/Orden.model';
import { Empresa } from 'src/app/modelos/Empresa.model';

@Component({
  selector: 'app-add-orden',
  templateUrl: './add-orden.component.html',
  styleUrls: ['./add-orden.component.css']
})
export class AddOrdenComponent implements OnInit {

  // Variables
  public orden: Orden = new Orden();
  public empresas: Empresa[];
  @Input() public vivienda;
  public fechaActual = formatDate(new Date(), 'yyyy-MM-dd', 'en-EN');

  constructor(
    private _ordenes: OrdenesService,
    private _empresas: EmpresasService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    this.orden.estado = 1;
    this.obtenerEmpresas();
  }

  // Obtener lista de Empresas
  obtenerEmpresas() {
    this._empresas.getEmpresas().subscribe(data => { this.empresas = data; });
  }

  // Guardar Orden
  guardarOrden() {
    this.orden.vivienda = this.vivienda;
    this.orden.fecha = this.fechaActual;
    this._ordenes.addOrden(this.orden).subscribe(data => {
      this.modalService.close();
    });
  }

}
