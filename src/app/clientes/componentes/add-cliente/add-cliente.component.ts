import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

// Servicios
import { ViviendasService } from 'src/app/servicios/viviendas.service';
import { ClientesService } from 'src/app/servicios/clientes.service';

// Modelos
import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { Cliente } from 'src/app/modelos/Cliente.model';

@Component({
  selector: 'app-add-cliente',
  templateUrl: './add-cliente.component.html',
  styleUrls: ['./add-cliente.component.css']
})
export class AddClienteComponent implements OnInit {

  // Variables
  cliente: Cliente = new Cliente();

  constructor(private router:Router, private _clientes:ClientesService) { }

  ngOnInit(): void {
  }

  // Guardar Cliente
  guardarCliente() {    
    this._clientes.addCliente(this.cliente).subscribe(data => { 
      this.router.navigate(["clientes"]) 
    });
  }

}
