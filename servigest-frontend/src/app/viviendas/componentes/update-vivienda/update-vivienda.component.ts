import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

// Servicios
import { ViviendasService } from 'src/app/servicios/viviendas.service';
import { ClientesService } from 'src/app/servicios/clientes.service';

// Modelos
import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { Cliente } from 'src/app/modelos/Cliente.model';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-update-vivienda',
  templateUrl: './update-vivienda.component.html',
  styleUrls: ['./update-vivienda.component.css']
})
export class UpdateViviendaComponent implements OnInit {

  // Variables
  @Input() vivienda: Vivienda;
  
  public clientes: Cliente[];
  public cliente: Cliente = new Cliente();
  public viviendaForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _viviendas: ViviendasService,
    private _clientes: ClientesService,
    private route: ActivatedRoute,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    const idVivienda = this.route.snapshot.params.idVivienda;

    this.obtenerVivienda(idVivienda);
    this.obtenerClientes();

    // Creo el FormGroup
    this.viviendaForm = new FormGroup({
      idVivienda: new FormControl(this.vivienda.idVivienda),
      direccion: new FormControl(this.vivienda.direccion, Validators.required),
      localidad: new FormControl(this.vivienda.localidad, Validators.required),
      provincia: new FormControl(this.vivienda.provincia, Validators.required),
      coordenadas: new FormControl(this.vivienda.coordenadas),
      propietario: new FormControl(null),
      inquilino: new FormControl(null)
    });

    // Coloco los valores
    this._viviendas.getVivienda(idVivienda).subscribe(data => {
      this.viviendaForm.get('idVivienda').setValue(this.vivienda.idVivienda);
      this.viviendaForm.get('direccion').setValue(this.vivienda.direccion);
      this.viviendaForm.get('localidad').setValue(this.vivienda.localidad);
      this.viviendaForm.get('provincia').setValue(this.vivienda.provincia);
    });

    // Coloco el propietario y el inquilino que sea...
    this._clientes.getClientes().subscribe(data => {
      this.viviendaForm.get('propietario').setValue(this.vivienda.propietario);
      this.viviendaForm.get('inquilino').setValue(this.vivienda.inquilino);
    });

  }

  // Comparador del Formulario
  comparaCliente(c1: Cliente, c2: Cliente): boolean
  {
    return c1 && c2 ? c1.idCliente === c2.idCliente : c1 === c2;
  }

  // Obtener la vivienda
  obtenerVivienda(idVivienda: number): void {
    this._viviendas.getVivienda(idVivienda).subscribe(data => { this.vivienda = data; });
  }

  // Obtengo los Clientes
  obtenerClientes(): void {
    this._clientes.getClientes().subscribe(data => { this.clientes = data; });
  }

  // Actualizar la Vivienda
  actualizarVivienda() {
    this.vivienda = Object.assign({}, this.viviendaForm.value);

    this._viviendas.updateVivienda(this.vivienda).subscribe(data => {
      this.modalService.close();
    });
  }

}
