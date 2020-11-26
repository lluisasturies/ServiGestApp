import { Component, OnInit } from '@angular/core';

// Servicios
import { ClientesService } from 'src/app/servicios/clientes.service';

// Modelos
import { Cliente } from 'src/app/modelos/Cliente.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-add-cliente',
  templateUrl: './add-cliente.component.html',
  styleUrls: ['./add-cliente.component.css']
})
export class AddClienteComponent implements OnInit {

  // Variables
  public cliente: Cliente = new Cliente();
  public clienteForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _clientes:ClientesService,
    public modalService: NgbActiveModal
    ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.clienteForm = new FormGroup({
      nombre: new FormControl('', Validators.required),
      apellidos: new FormControl('', Validators.required),
      dni: new FormControl('', Validators.required)
    });
  }

  // Guardar Cliente
  guardarCliente() {
    this.cliente = Object.assign({}, this.clienteForm.value);

    this._clientes.addCliente(this.cliente).subscribe(data => { 
      this.modalService.close();
    },
    (err: any) => {
      this.isFail = true;
      this.errorMsg = err.error.message;
    });
  }

}
