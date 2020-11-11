import { Component, OnInit } from '@angular/core';

// Servicios
import { ViviendasService } from './../../servicios/viviendas.service';

// Modelos
import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';

@Component({
  selector: 'app-viviendas',
  templateUrl: './viviendas.component.html',
  styleUrls: ['./viviendas.component.css']
})
export class ViviendasComponent implements OnInit {

  // Variables
  dtOptions: DataTables.Settings = {};
  viviendas: Vivienda[];

  constructor(
    private _viviendas: ViviendasService,
    private confirmationDialogService: ConfirmationDialogService
  ) { }

  ngOnInit(): void {
    this.opcionesDt();
    this.obtenerViviendas();
  }

  // Opciones del DataTable
  opcionesDt(): void {
    this.dtOptions = {
      pageLength: 25, // Registros por pagina
      language: { url: '//cdn.datatables.net/plug-ins/1.10.11/i18n/Spanish.json' } // Español
    };
  }

  // Obtengo las Viviendas
  obtenerViviendas(): void {
    this._viviendas.getViviendas().subscribe(data => {
      this.viviendas = data;
    });
  }

  // Borrar una Vivienda
  borrarVivienda(vivienda: Vivienda) {
    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar esta vivienda?')
    .then((confirmed) => {
      if (confirmed) {
        this._viviendas.deleteVivienda(vivienda).subscribe(data => {
          this.viviendas = this.viviendas.filter(v => v !== vivienda);
        });
      }
    });
  }

}
