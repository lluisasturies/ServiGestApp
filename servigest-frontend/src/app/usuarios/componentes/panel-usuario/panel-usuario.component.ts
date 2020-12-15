import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/modelos/nuevo-usuario.model';
import { TokenService } from 'src/app/servicios/token.service';
import { UsuariosService } from 'src/app/servicios/usuarios.service';

@Component({
  selector: 'app-panel-usuario',
  templateUrl: './panel-usuario.component.html',
  styleUrls: ['./panel-usuario.component.css']
})
export class PanelUsuarioComponent implements OnInit {

  // Variables
  usuario: Usuario = new Usuario();

  constructor(
    private tokenService: TokenService,
    private usuarioService: UsuariosService
  ) { }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.usuarioService.getUsuario(this.tokenService.getUserName()).subscribe(data => {
        this.usuario = data;
      });
    }
  }

}
