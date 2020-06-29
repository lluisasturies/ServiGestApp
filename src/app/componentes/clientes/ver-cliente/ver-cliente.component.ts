import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

// Servicios
import { ClientesService } from 'src/app/servicios/clientes.service';

// Modelos
import { Cliente } from 'src/app/modelos/Cliente.model';
import { ClienteContacto } from 'src/app/modelos/cliente-contacto.model';
import { AddContactoComponent } from '../add-contacto/add-contacto.component';

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
    private route: ActivatedRoute,
    private modalService: NgbModal
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

}
