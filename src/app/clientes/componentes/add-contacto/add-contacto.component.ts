import { ClienteContacto } from 'src/app/modelos/cliente-contacto.model';
import { Component, OnInit, Input } from '@angular/core';

// Servicios
import { ClientesContactosService } from 'src/app/servicios/clientes-contactos.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from 'src/app/modelos/Cliente.model';

@Component({
  selector: 'app-add-contacto',
  templateUrl: './add-contacto.component.html',
  styleUrls: ['./add-contacto.component.css']
})
export class AddContactoComponent implements OnInit {

  // Variables
  clienteContacto: ClienteContacto = new ClienteContacto();
  @Input() public cliente: Cliente;

  constructor(
    private _clientesContactos: ClientesContactosService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
  }

  guardarClienteContacto() {
    this.clienteContacto.cliente = this.cliente;
    this._clientesContactos.addClienteContacto(this.clienteContacto).subscribe(data => {
      this.modalService.close(); });
  }

}
