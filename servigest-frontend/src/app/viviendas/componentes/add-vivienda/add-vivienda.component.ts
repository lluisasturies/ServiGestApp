import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

// Servicios
import { ViviendasService } from 'src/app/servicios/viviendas.service';
import { ClientesService } from 'src/app/servicios/clientes.service';

// Modelos
import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { Cliente } from 'src/app/modelos/Cliente.model';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-add-vivienda',
  templateUrl: './add-vivienda.component.html',
  styleUrls: ['./add-vivienda.component.css']
})
export class AddViviendaComponent implements OnInit {

  // Variables
  public clientes: Cliente[] = [];
  public vivienda: Vivienda = new Vivienda();
  public viviendaForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _viviendas: ViviendasService,
    private _clientes: ClientesService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    this.obtenerClientes();

    // Creo el FormGroup
    this.viviendaForm = new FormGroup({
      direccion: new FormControl('', Validators.required),
      localidad: new FormControl('', Validators.required),
      provincia: new FormControl('', Validators.required),
      propietario: new FormControl(null),
      inquilino: new FormControl(null)
    });
  }

  // Obtengo los Clientes
  obtenerClientes(): void {
    this._clientes.getClientes().subscribe(data => { this.clientes = data; });
  }

  // Guardar Vivienda
  guardarVivienda() {
    this.vivienda = Object.assign({}, this.viviendaForm.value);

    this._viviendas.addVivienda(this.vivienda).subscribe(data => {
      this.modalService.close();
    });
  }

}
