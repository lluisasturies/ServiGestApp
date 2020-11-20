import { UsuariosService } from 'src/app/servicios/usuarios.service';
import { Usuario } from 'src/app/modelos/nuevo-usuario.model';
import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-usuario',
  templateUrl: './update-usuario.component.html',
  styleUrls: ['./update-usuario.component.css']
})
export class UpdateUsuarioComponent implements OnInit {

  // Variables
  @Input() usuario: Usuario;

  public usuarioForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    public _usuarios: UsuariosService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    // Creo el FormGroup
    this.usuarioForm = new FormGroup({
      id: new FormControl(this.usuario.id),
      nombre: new FormControl(this.usuario.nombre, Validators.required),
      email: new FormControl(this.usuario.email, Validators.required),
      password: new FormControl(this.usuario.password),
      rol: new FormControl(this.usuario.rol)
    });
  }

  // Actualizar el Usuario
  actualizarUsuario() {
    this.usuario = Object.assign({}, this.usuarioForm.value);

    this._usuarios.updateUsuario(this.usuario).subscribe(data => {
      this.modalService.close();
    });
  }

}
