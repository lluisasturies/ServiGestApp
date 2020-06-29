import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

// Servicios
import { ViviendasService } from 'src/app/servicios/viviendas.service';
import { ClientesService } from 'src/app/servicios/clientes.service';

// Modelos
import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { Cliente } from 'src/app/modelos/Cliente.model';

@Component({
  selector: 'app-add-vivienda',
  templateUrl: './add-vivienda.component.html',
  styleUrls: ['./add-vivienda.component.css']
})
export class AddViviendaComponent implements OnInit {

  // Variables
  clientes: Cliente[] = [];
  vivienda: Vivienda = new Vivienda();

  constructor(private router: Router, private _viviendas: ViviendasService, private _clientes: ClientesService) { }

  ngOnInit(): void {
    this.obtenerClientes();
  }

  // Obtengo los Clientes
  obtenerClientes(): void {
    this._clientes.getClientes().subscribe(data => { this.clientes = data; });
  }

  // Guardar Vivienda
  guardarVivienda() {
    this._viviendas.addVivienda(this.vivienda).subscribe(data => {
      this.router.navigate(['viviendas']);
    });
  }

}
