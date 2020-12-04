import { formatDate } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { OrdenCita } from 'src/app/modelos/orden-cita.model';
import { OrdenLinea } from 'src/app/modelos/Orden-linea.model';
import { Orden } from 'src/app/modelos/Orden.model';
import { OrdenesCitasService } from 'src/app/servicios/ordenes-citas.service';
import { OrdenesLineasService } from 'src/app/servicios/ordenes-lineas.service';

@Component({
  selector: 'app-add-orden-cita',
  templateUrl: './add-orden-cita.component.html',
  styleUrls: ['./add-orden-cita.component.css'],
})
export class AddOrdenCitaComponent implements OnInit {

  // Variables
  @Input() public orden: Orden;

  public model: NgbDateStruct;
  public fecha: {year: number, month: number, day: number};
  public hora: {hour: 13, minute: 30};
  public fechaCita;

  public ordenCita: OrdenCita = new OrdenCita();
  public ordenCitaForm: FormGroup;
  public fechaActual = formatDate(new Date(), 'yyyy-MM-dd', 'en-EN');

  constructor(
    private _ordenesCitas: OrdenesCitasService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.ordenCitaForm = new FormGroup({
      fecha: new FormControl('', Validators.required),
      hora: new FormControl('', Validators.required)
    });
  }

  guardarCita() {
    if (this.ordenCitaForm.controls.fecha.value.day < 10) {
      this.ordenCitaForm.controls.fecha.value.day = '0' + this.ordenCitaForm.controls.fecha.value.day;
    }

    if (this.ordenCitaForm.controls.hora.value.hour < 10) {
      this.ordenCitaForm.controls.hora.value.hour = '0' + this.ordenCitaForm.controls.hora.value.hour;
    }

    if (this.ordenCitaForm.controls.hora.value.minute < 10) {
      this.ordenCitaForm.controls.hora.value.minute = '0' + this.ordenCitaForm.controls.hora.value.minute;
    }

    this.fechaCita =
    this.ordenCitaForm.controls.fecha.value.year + '-' +
    this.ordenCitaForm.controls.fecha.value.month + '-' +
    this.ordenCitaForm.controls.fecha.value.day + 'T' +
    this.ordenCitaForm.controls.hora.value.hour + ':' +
    this.ordenCitaForm.controls.hora.value.minute + ':00';

    this.ordenCita.orden = this.orden;
    this.ordenCita.fecha = this.fechaCita;

    this._ordenesCitas.addCita(this.ordenCita).subscribe(data => {
      this.modalService.close();
    });
  }

}
