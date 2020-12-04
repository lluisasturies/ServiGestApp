import { Orden } from 'src/app/modelos/Orden.model';
import { formatDate } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { OrdenLinea } from 'src/app/modelos/Orden-linea.model';

// Servicios
import { OrdenesLineasService } from 'src/app/servicios/ordenes-lineas.service';

@Component({
  selector: 'app-add-orden-linea',
  templateUrl: './add-orden-linea.component.html',
  styleUrls: ['./add-orden-linea.component.css']
})
export class AddOrdenLineaComponent implements OnInit {

  // Variables
  @Input() public orden: Orden;

  public ordenLinea: OrdenLinea = new OrdenLinea();
  public ordenLineaForm: FormGroup;
  public fechaActual = formatDate(new Date(), 'yyyy-MM-dd', 'en-EN');

  constructor(
    private _ordenesLineas: OrdenesLineasService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.ordenLineaForm = new FormGroup({
      orden: new FormControl(this.orden),
      fecha: new FormControl(this.fechaActual),
      concepto: new FormControl('', Validators.required)
    });
  }

  guardarOrdenLinea() {
    this.ordenLinea = Object.assign({}, this.ordenLineaForm.value);
    this._ordenesLineas.addOrdenLinea(this.ordenLinea).subscribe(data => {
      this.modalService.close();
    });
  }

}
