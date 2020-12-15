import { UsuariosService } from 'src/app/servicios/usuarios.service';
import { Usuario } from 'src/app/modelos/nuevo-usuario.model';
import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Rol } from 'src/app/modelos/rol.model';
import { RolesService } from 'src/app/servicios/roles.service';

@Component({
  selector: 'app-update-usuario',
  templateUrl: './update-usuario.component.html',
  styleUrls: ['./update-usuario.component.css']
})
export class UpdateUsuarioComponent implements OnInit {

  // Variables
  @Input() usuario: Usuario;

  public roles: Rol[] = [];

  public usuarioForm: FormGroup;
  public isFail = false;
  public errorMsg = '';

  constructor(
    public _usuarios: UsuariosService,
    private _roles: RolesService,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit(): void {
    this.obtenerRoles();
    
    // Creo el FormGroup
    this.usuarioForm = new FormGroup({
      id: new FormControl(this.usuario.id),
      nombre: new FormControl(this.usuario.nombre, Validators.required),
      email: new FormControl(this.usuario.email, Validators.required),
      rol: new FormControl(this.usuario.rol)
    });
  }

  // Comparador del Formulario
  comparaRol(c1: Rol, c2: Rol): boolean
  {
    return c1 && c2 ? c1.rolNombre === c2.rolNombre : c1 === c2;
  }

  obtenerRoles(): void {
    this._roles.getRoles().subscribe(data => { this.roles = data; });
  }

  // Actualizar el Usuario
  actualizarUsuario() {
    this.usuario = Object.assign({}, this.usuarioForm.value);

    this._usuarios.updateUsuario(this.usuario).subscribe(data => {
      this.modalService.close();
    },
    (err: any) => {
      this.isFail = true;
      this.errorMsg = err.error.message;
    });
  }

}
