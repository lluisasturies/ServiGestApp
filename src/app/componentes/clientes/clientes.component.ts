import { Component, OnInit } from '@angular/core';

// Servicios
import { ClientesService } from 'src/app/servicios/clientes.service';

// Modelos
import { Cliente } from 'src/app/modelos/Cliente.model';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  // Variables
  dtOptions: DataTables.Settings = {};
  clientes: Cliente[];

  constructor(private _clientes:ClientesService) { }

  ngOnInit(): void {
    this.opcionesDt();
    this.obtenerClientes();
  }

  // Opciones del DataTable
  opcionesDt(): void {
    this.dtOptions = {
      pageLength: 25, // Registros por pagina
      language: { url: '//cdn.datatables.net/plug-ins/1.10.11/i18n/Spanish.json' } // Español
    };
  }

  // Obtener todos los Clientes
  obtenerClientes(): void {
    this._clientes.getClientes().subscribe(data => { this.clientes = data });
  }

  // Borrar un Cliente
  borrarCliente(cliente: Cliente) {
    this._clientes.deleteCliente(cliente).subscribe(data => { this.clientes = this.clientes.filter(v => v !== cliente); });
  }

}
