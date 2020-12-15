import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Usuario } from 'src/app/modelos/nuevo-usuario.model';
import { ConfirmationDialogService } from 'src/app/servicios/confirmation-dialog.service';
import { TokenService } from 'src/app/servicios/token.service';
import { UsuariosService } from 'src/app/servicios/usuarios.service';
import { UpdateUsuarioPasswordComponent } from '../update-usuario-password/update-usuario-password.component';
import { UpdateUsuarioComponent } from '../update-usuario/update-usuario.component';

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
    private usuarioService: UsuariosService,
    private modalService: NgbModal,
    private confirmationDialogService: ConfirmationDialogService
  ) { }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.usuarioService.getUsuario(this.tokenService.getUserName()).subscribe(data => {
        this.usuario = data;
      });
    }
  }

  // Modal Editar Usuario
  editarUsuario(usuario: Usuario) {
    const modalRef = this.modalService.open(UpdateUsuarioComponent);
    modalRef.componentInstance.usuario = usuario;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

  // Modal Editar Contraseña
  editarPassword(usuario: Usuario) {
    const modalRef = this.modalService.open(UpdateUsuarioPasswordComponent);
    modalRef.componentInstance.usuario = usuario;
    modalRef.result.then((result) => {
      this.ngOnInit();
    });
  }

}
