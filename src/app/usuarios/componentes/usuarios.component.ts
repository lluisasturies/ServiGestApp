import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/modelos/nuevo-usuario.model';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';
import { UsuariosService } from 'src/app/servicios/usuarios.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  // Variables
  dtOptions: DataTables.Settings = {};
  usuarios: Usuario[];

  constructor(
    private _usuarios:UsuariosService,
    private confirmationDialogService: ConfirmationDialogService
  ) { }

  ngOnInit(): void {
    this.opcionesDt();
    this.obtenerUsuarios();
  }

  // Opciones del DataTable
  opcionesDt(): void {
    this.dtOptions = {
      pageLength: 25, // Registros por pagina
      language: { url: '//cdn.datatables.net/plug-ins/1.10.11/i18n/Spanish.json' } // Español
    };
  }

  // Obtener todos los Usuarios
  obtenerUsuarios(): void {
    this._usuarios.getUsuarios().subscribe(data => { this.usuarios = data });
  }

  // Borrar un Usuario
  borrarUsuario(usuario: Usuario) {


    this.confirmationDialogService.confirm('Confirmar', '¿Estás seguro de que quieres borrar este usuario?')
    .then((confirmed) => {
      if (confirmed) {
        this._usuarios.deleteUsuario(usuario).subscribe(data => {
          this.usuarios = this.usuarios.filter(v => v !== usuario);
        });
      }
    });
  }

}
