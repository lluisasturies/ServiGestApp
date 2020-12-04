import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from 'src/app/modelos/Cliente.model';
import { ClientesService } from 'src/app/servicios/clientes.service';

@Component({
  selector: 'app-update-cliente',
  templateUrl: './update-cliente.component.html',
  styleUrls: ['./update-cliente.component.css']
})
export class UpdateClienteComponent implements OnInit {

  // Variables
  @Input() cliente: Cliente;

  public clienteForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _clientes: ClientesService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.clienteForm = new FormGroup({
      idCliente: new FormControl(this.cliente.idCliente),
      nombre: new FormControl(this.cliente.nombre, Validators.required),
      apellidos: new FormControl(this.cliente.apellidos, Validators.required),
      dni: new FormControl(this.cliente.dni, Validators.required)
    });
  }

  // Actualizar el Cliente
  actualizarCliente() {
    this.cliente = Object.assign({}, this.clienteForm.value);

    this._clientes.updateCliente(this.cliente).subscribe(data => {
      this.modalService.close();
    });
  }

}
