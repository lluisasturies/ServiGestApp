import { Component, OnInit, Input, ViewChild, Output, EventEmitter } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, Validators } from '@angular/forms';

// Modelos
import { Aparato } from 'src/app/modelos/aparato.model';

// Servicios
import { AparatosService } from './../../../servicios/aparatos.service';
import { ViviendasAparatosService } from 'src/app/servicios/viviendas-aparatos.service';

// Modelos
import { ViviendaAparato } from 'src/app/modelos/vivienda-aparato.model';
import { Vivienda } from 'src/app/modelos/Vivienda.model';

@Component({
  selector: 'app-add-vivienda-aparato',
  templateUrl: './add-vivienda-aparato.component.html',
  styleUrls: ['./add-vivienda-aparato.component.css']
})
export class AddViviendaAparatoComponent implements OnInit {

  // Variables
  @Input() vivienda: Vivienda;
  @Output() passEntry: EventEmitter<any> = new EventEmitter();

  public aparatos: Aparato[];
  public aparato: Aparato = new Aparato();
  public viviendaAparato: ViviendaAparato = new ViviendaAparato();
  public aparatoViviendaForm: FormGroup;

  constructor(
    private _viviendaAparato: ViviendasAparatosService,
    private _aparatos: AparatosService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    this.obtenerAparatos();

    // Creo el FormGroup
    this.aparatoViviendaForm = new FormGroup({
      vivienda: new FormControl(this.vivienda, Validators.required),
      aparato: new FormControl('', Validators.required)
    });

  }

  // Obtengo los Aparatos
  obtenerAparatos() {
    this._aparatos.getAparatos().subscribe(data => { this.aparatos = data; });
  }

  // Asociar un Aparato a una Vivienda
  guardarViviendaAparato() {
    this.viviendaAparato = Object.assign({}, this.aparatoViviendaForm.value);
    this._viviendaAparato.addAparatoVivienda(this.viviendaAparato).subscribe(data => {
      this.modalService.close(); });
  }

}
