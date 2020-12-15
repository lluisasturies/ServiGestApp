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
  public horaInicio;
  public horaFin;

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
      horaInicio: new FormControl('', Validators.required),
      horaFin: new FormControl('', Validators.required)
    });
  }

  guardarCita() {
    if (this.ordenCitaForm.controls.fecha.value.day < 10) {
      this.ordenCitaForm.controls.fecha.value.day = '0' + this.ordenCitaForm.controls.fecha.value.day;
    }

    if (this.ordenCitaForm.controls.horaInicio.value.hour < 10) {
      this.ordenCitaForm.controls.horaInicio.value.hour = '0' + this.ordenCitaForm.controls.horaInicio.value.hour;
    }

    if (this.ordenCitaForm.controls.horaInicio.value.minute < 10) {
      this.ordenCitaForm.controls.horaInicio.value.minute = '0' + this.ordenCitaForm.controls.horaInicio.value.minute;
    }

    if (this.ordenCitaForm.controls.horaFin.value.hour < 10) {
      this.ordenCitaForm.controls.horaFin.value.hour = '0' + this.ordenCitaForm.controls.horaFin.value.hour;
    }

    if (this.ordenCitaForm.controls.horaFin.value.minute < 10) {
      this.ordenCitaForm.controls.horaFin.value.minute = '0' + this.ordenCitaForm.controls.horaFin.value.minute;
    }

    this.fechaCita =
    this.ordenCitaForm.controls.fecha.value.year + '-' +
    this.ordenCitaForm.controls.fecha.value.month + '-' +
    this.ordenCitaForm.controls.fecha.value.day;

    this.horaInicio =
    this.ordenCitaForm.controls.horaInicio.value.hour + ':' +
    this.ordenCitaForm.controls.horaInicio.value.minute;

    this.horaFin =
    this.ordenCitaForm.controls.horaFin.value.hour + ':' +
    this.ordenCitaForm.controls.horaFin.value.minute;

    this.ordenCita.orden = this.orden;
    this.ordenCita.fecha = this.fechaCita;
    this.ordenCita.horaInicio = this.horaInicio;
    this.ordenCita.horaFin = this.horaFin;

    this._ordenesCitas.addCita(this.ordenCita).subscribe(data => {
      this.modalService.close();
    });
  }

}
