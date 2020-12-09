import { Orden } from 'src/app/modelos/Orden.model';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OrdenesService } from 'src/app/servicios/ordenes.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { EmpresasService } from 'src/app/servicios/empresas.service';
import { Empresa } from 'src/app/modelos/Empresa.model';

@Component({
  selector: 'app-update-orden',
  templateUrl: './update-orden.component.html',
  styleUrls: ['./update-orden.component.css']
})
export class UpdateOrdenComponent implements OnInit {

  // Variables
  @Input() orden: Orden;

  public empresas: Empresa[];
  public ordenForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _ordenes: OrdenesService,
    private _empresas: EmpresasService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    this.obtenerEmpresas();

    // Creo el FormGroup
    this.ordenForm = new FormGroup({
      idOrden: new FormControl(this.orden.idOrden),
      vivienda: new FormControl(this.orden.vivienda),
      empresa: new FormControl(this.orden.empresa, Validators.required),
      orden: new FormControl(this.orden.orden, Validators.required),
      asunto: new FormControl(this.orden.asunto, Validators.required),
      fecha: new FormControl(this.orden.fecha),
      estado: new FormControl(this.orden.estado)
    });
  }

  // Obtener lista de Empresas
  obtenerEmpresas() {
    this._empresas.getEmpresas().subscribe(data => {
      this.empresas = data;
    });
  }

  // Comparador del Formulario
  comparaEmpresa(c1: Empresa, c2: Empresa): boolean
  {
    return c1 && c2 ? c1.idEmpresa === c2.idEmpresa : c1 === c2;
  }

  // Actualizar la Orden
  actualizarOrden() {
    this.orden = Object.assign({}, this.ordenForm.value);

    this._ordenes.updateOrden(this.orden).subscribe(data => {
      this.modalService.close();
    });
  }

}
