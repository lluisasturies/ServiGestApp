import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Usuario } from 'src/app/modelos/nuevo-usuario.model';
import { UsuarioPassword } from 'src/app/modelos/usuario-password.model';
import { UsuariosService } from 'src/app/servicios/usuarios.service';

@Component({
  selector: 'app-update-usuario-password',
  templateUrl: './update-usuario-password.component.html',
  styleUrls: ['./update-usuario-password.component.css']
})
export class UpdateUsuarioPasswordComponent implements OnInit {

  // Variables
  @Input() usuario: Usuario;
  public usuarioPassword: UsuarioPassword;

  public usuarioPasswordForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    public _usuarios: UsuariosService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.usuarioPasswordForm = new FormGroup({
      email: new FormControl(this.usuario.email),
      oldPassword: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required)
    });
  }

  // Actualizar la Contraseña
  actualizarPassword() {
    this.usuarioPassword = Object.assign({}, this.usuarioPasswordForm.value);

    this._usuarios.updatePassword(this.usuarioPassword).subscribe(data => {
      this.modalService.close();
    },
    (err: any) => {
      this.isFail = true;
      this.errorMsg = err.error.message;
    });
  }

}
