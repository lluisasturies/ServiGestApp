import { OrdenCitaPendiente } from './../../modelos/orden-cita-pendiente.model';
import { OrdenCita } from 'src/app/modelos/orden-cita.model';
import { OrdenesService } from 'src/app/servicios/ordenes.service';
import { Component, OnInit } from '@angular/core';

// Servicios
import { TokenService } from 'src/app/servicios/token.service';
import { Orden } from 'src/app/modelos/Orden.model';
import { OrdenesCitasService } from 'src/app/servicios/ordenes-citas.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  public info: any = {};
  public loading: boolean = true;

  public ordenesPendientes: Orden[];
  public citasPendientes: OrdenCitaPendiente[];

  constructor(
    private tokenService: TokenService,
    private _ordenes: OrdenesService,
    private _ordenesCitas: OrdenesCitasService
  ) { }

  ngOnInit() {
    this.info = {
      token: this.tokenService.getToken(),
      nombreUsuario: this.tokenService.getUserName(),
      authorities: this.tokenService.getAuthorities()
    };

    if (this.info.token) {
      this.cargaOrdenesPendientes();
      this.cargaCitasPendientes();
    }
  }

  cargaOrdenesPendientes() {
    this._ordenes.getOrdenesAbiertas().subscribe(data => {
      this.ordenesPendientes = data;
    });
  }

  cargaCitasPendientes() {
    this._ordenesCitas.getCitasPendientes().subscribe(data => {
      this.citasPendientes = data;
      this.loading = false;
    });
  }

}
