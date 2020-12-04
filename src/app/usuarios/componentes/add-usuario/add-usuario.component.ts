import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

// Servicios
import { UsuariosService } from 'src/app/servicios/usuarios.service';

// Modelos
import { Usuario } from 'src/app/modelos/nuevo-usuario.model';
import { Rol } from 'src/app/modelos/rol.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { RolesService } from 'src/app/servicios/roles.service';

@Component({
  selector: 'app-add-usuario',
  templateUrl: './add-usuario.component.html',
  styleUrls: ['./add-usuario.component.css']
})
export class AddUsuarioComponent implements OnInit {

  // Variables
  usuario: Usuario = new Usuario();
  rol: Rol = new Rol();
  roles: Rol[] = [];
  public usuarioForm: FormGroup;

  isRegister = false;
  isRegisterFail = false;
  errorMsg = '';

  constructor(
    private _usuarios: UsuariosService,
    private _roles: RolesService,
    private router: Router,
    public modalService: NgbActiveModal
  ) { }

  ngOnInit() {
    this.obtenerRoles();
    this.rol.rolNombre = 'ROLE_TECNICO';
    this.usuario.rol = this.rol;

    // Creo el FormGroup
    this.usuarioForm = new FormGroup({
      nombre: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      rol: new FormControl('', Validators.required)
    });
  }

  obtenerRoles(): void {
    this._roles.getRoles().subscribe(data => { this.roles = data; });
  }

  addUsuario() {
    this.usuario = Object.assign({}, this.usuarioForm.value);

    this._usuarios.addUsuario(this.usuario).subscribe(data => {
      this.isRegister = true;
      this.isRegisterFail = false;
      this.router.navigate(['usuarios']);

      this.modalService.close();
    },
      (error: any) => {
        this.errorMsg = error.body;
        this.isRegister = false;
        this.isRegisterFail = true;
      }
    );
  }

}
