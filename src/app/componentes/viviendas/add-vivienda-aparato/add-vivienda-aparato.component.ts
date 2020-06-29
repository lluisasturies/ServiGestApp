import { Component, OnInit, Input, ViewChild, Output, EventEmitter } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

// Modelos
import { Aparato } from 'src/app/modelos/aparato.model';

// Servicios
import { AparatosService } from './../../../servicios/aparatos.service';
import { ViviendasAparatosService } from 'src/app/servicios/viviendas-aparatos.service';

// Modelos
import { ViviendaAparato } from 'src/app/modelos/vivienda-aparato.model';

@Component({
  selector: 'app-add-vivienda-aparato',
  templateUrl: './add-vivienda-aparato.component.html',
  styleUrls: ['./add-vivienda-aparato.component.css']
})
export class AddViviendaAparatoComponent implements OnInit {

  // Variables
  @Input() public vivienda;
  @Output() passEntry: EventEmitter<any> = new EventEmitter();

  aparatos: Aparato[];
  aparato: Aparato = new Aparato();
  viviendaAparato: ViviendaAparato = new ViviendaAparato();

  constructor(
    private _viviendaAparato: ViviendasAparatosService,
    private _aparatos: AparatosService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    this.obtenerAparatos();
  }

  // Obtengo los Aparatos
  obtenerAparatos() {
    this._aparatos.getAparatos().subscribe(data => { this.aparatos = data; });
  }

  // Asociar un Aparato a una Vivienda
  guardarViviendaAparato() {
    this._viviendaAparato.addAparatoVivienda(this.aparato, this.vivienda).subscribe(data => {
      this.modalService.close(); });
  }

}
