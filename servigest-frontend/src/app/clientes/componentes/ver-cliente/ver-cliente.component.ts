import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

// Servicios
import { ClientesService } from 'src/app/servicios/clientes.service';

// Modelos
import { Cliente } from 'src/app/modelos/Cliente.model';
import { ClienteContacto } from 'src/app/modelos/cliente-contacto.model';
import { AddContactoComponent } from '../add-contacto/add-contacto.component';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';
import { ClientesContactosService } from 'src/app/servicios/clientes-contactos.service';
import { UpdateClienteComponent } from '../update-cliente/update-cliente.component';
import { ClienteTelefono } from 'src/app/modelos/cliente-telefono.model';
import { ClientesTelefonosService } from 'src/app/servicios/clientes-telefonos.service';
import { ClientesEmailsService } from 'src/app/servicios/clientes-emails.service';
import { ClienteEmail } from 'src/app/modelos/cliente-email.model';

@Component({
  selector: 'app-ver-cliente',
  templateUrl: './ver-cliente.component.html',
  styleUrls: ['./ver-cliente.component.css']
})
export class VerClienteComponent implements OnInit {

  // Variables
  cliente: Cliente = new Cliente();
  contactos: ClienteContacto[];

  constructor(
    private _clientes: ClientesService,
    private _clientesTelefonos: ClientesTelefonosService,
    private _clientesEmails: ClientesEmailsService,
    private route: ActivatedRoute,
    private confirmationDialogService: ConfirmationDialogService,
    private modalService: NgbModal,
    private router: Router
  ) { }

  ngOnInit(): void {
    const idCliente = this.route.snapshot.params.idCliente;

    this.obtenerCliente(idCliente);
  }

  // Obtener el Cliente
  obtenerCliente(idCliente: number): void {
    this._clientes.getCliente(idCliente).subscribe(data => { this.cliente = data; });
  }

  addContacto() {
    const modalRef = this.modalService.open(AddContactoComponent);
    modalRef.componentInstance.cliente = this.cliente;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Borrar un Telefono
  borrarTelefono(clienteTelefono: ClienteTelefono) {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar este telefono?')
    .then((confirmed) => {
      if (confirmed) {
        this._clientesTelefonos.deleteClienteTelefono(clienteTelefono).subscribe(data => {
          this.ngOnInit();
        });
      }
    });
  }

  // Borrar un Email
  borrarEmail(clienteEmail: ClienteEmail) {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar este email?')
    .then((confirmed) => {
      if (confirmed) {
        this._clientesEmails.deleteClienteEmail(clienteEmail).subscribe(data => {
          this.ngOnInit();
        });
      }
    });
  }

  //
  editarContacto(clienteContacto: ClienteContacto) {
    
  }

  // Modal Editar Cliente
  editarCliente() {
    const modalRef = this.modalService.open(UpdateClienteComponent);
    modalRef.componentInstance.cliente = this.cliente;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Borrar un Cliente
  borrarCliente() {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar este cliente?')
    .then((confirmed) => {
      if (confirmed) {
        this._clientes.deleteCliente(this.cliente).subscribe(data => {
          this.router.navigate(['clientes']);
        });
      }
    });
  }

}
