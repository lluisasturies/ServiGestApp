import { ClienteContacto } from 'src/app/modelos/cliente-contacto.model';
import { Component, OnInit, Input } from '@angular/core';

// Servicios
import { ClientesContactosService } from 'src/app/servicios/clientes-contactos.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from 'src/app/modelos/Cliente.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-contacto',
  templateUrl: './add-contacto.component.html',
  styleUrls: ['./add-contacto.component.css']
})
export class AddContactoComponent implements OnInit {

  // Variables
  @Input() public cliente: Cliente;

  public clienteContactoForm: FormGroup;
  public clienteContacto: ClienteContacto = new ClienteContacto();
  public isFail = false;
  public errorMsg = '';

  constructor(
    private _clientesContactos: ClientesContactosService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.clienteContactoForm = new FormGroup({
      cliente: new FormControl(this.cliente),
      tipo: new FormControl('', Validators.required),
      dato: new FormControl('', Validators.required)
    });
  }

  guardarClienteContacto() {
    this.clienteContacto = Object.assign({}, this.clienteContactoForm.value);
    
    this._clientesContactos.addClienteContacto(this.clienteContacto).subscribe(data => {
      this.modalService.close();
    },
    (err: any) => {
      this.isFail = true;
      this.errorMsg = err.error.message;
    });
  }

}
