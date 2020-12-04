import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { Component, OnInit, Input } from '@angular/core';
import { formatDate } from '@angular/common';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

// Servicios
import { OrdenesService } from 'src/app/servicios/ordenes.service';
import { EmpresasService } from 'src/app/servicios/empresas.service';

// Modelos
import { Orden } from 'src/app/modelos/Orden.model';
import { Empresa } from 'src/app/modelos/Empresa.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-orden',
  templateUrl: './add-orden.component.html',
  styleUrls: ['./add-orden.component.css']
})
export class AddOrdenComponent implements OnInit {

  // Variables
  @Input() public vivienda: Vivienda;

  public orden: Orden = new Orden();
  public empresas: Empresa[];
  public ordenForm: FormGroup;
  public fechaActual = formatDate(new Date(), 'yyyy-MM-dd', 'en-EN');
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
      vivienda: new FormControl(this.vivienda),
      empresa: new FormControl('', Validators.required),
      orden: new FormControl('', Validators.required),
      asunto: new FormControl('', Validators.required),
      fecha: new FormControl(this.fechaActual),
      estado: new FormControl(1)
    });
  }

  // Obtener lista de Empresas
  obtenerEmpresas() {
    this._empresas.getEmpresas().subscribe(data => {
      this.empresas = data;
    });
  }

  // Guardar Orden
  guardarOrden() {
    this.orden = Object.assign({}, this.ordenForm.value);

    this._ordenes.addOrden(this.orden).subscribe(data => {
      this.modalService.close();
    },
    (err: any) => {
      this.isFail = true;
      this.errorMsg = err.error.message;
    });
  }

}
