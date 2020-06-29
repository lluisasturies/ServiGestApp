import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

// Servicios
import { ViviendasService } from 'src/app/servicios/viviendas.service';
import { ClientesService } from 'src/app/servicios/clientes.service';

// Modelos
import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { Cliente } from 'src/app/modelos/Cliente.model';

@Component({
  selector: 'app-update-vivienda',
  templateUrl: './update-vivienda.component.html',
  styleUrls: ['./update-vivienda.component.css']
})
export class UpdateViviendaComponent implements OnInit {

  // Variables
  vivienda: Vivienda = new Vivienda();
  clientes: Cliente[];
  cliente: Cliente = new Cliente();

  constructor(
    private _viviendas: ViviendasService,
    private _clientes: ClientesService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const idVivienda = this.route.snapshot.params.idVivienda;

    this.obtenerVivienda(idVivienda);
    this.obtenerClientes();
  }

  // Obtener la vivienda
  obtenerVivienda(idVivienda: number) {
    this._viviendas.getVivienda(idVivienda).subscribe(data => { this.vivienda = data; });
  }

  // Obtengo los Clientes
  obtenerClientes(): void {
    this._clientes.getClientes().subscribe(data => { this.clientes = data; });
  }

  // Actualizar la Vivienda
  actualizarVivienda() {
    this._viviendas.updateVivienda(this.vivienda).subscribe(data => {
      this.router.navigate(['viviendas/ver/' + this.vivienda.idVivienda]);
    });
  }

}
