import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

// Servicios
import { UsuariosService } from 'src/app/servicios/usuarios.service';

// Modelos
import { Usuario } from 'src/app/modelos/nuevo-usuario.model';
import { Rol } from 'src/app/modelos/rol.model';

@Component({
  selector: 'app-add-usuario',
  templateUrl: './add-usuario.component.html',
  styleUrls: ['./add-usuario.component.css']
})
export class AddUsuarioComponent implements OnInit {

  // Variables
  usuario: Usuario = new Usuario();
  rol: Rol = new Rol();

  isRegister = false;
  isRegisterFail = false;
  errorMsg = '';

  constructor(
    private _usuarios: UsuariosService,
    private router: Router
  ) { }

  ngOnInit() {
    this.rol.rolNombre = 'ROLE_TECNICO';
    this.usuario.roles = [this.rol];
  }

  onRegister() {
    this._usuarios.addUsuario(this.usuario).subscribe(data => {
      this.isRegister = true;
      this.isRegisterFail = false;
      this.router.navigate(['usuarios']);
    },
      (error: any) => {
        this.errorMsg = error.body;
        this.isRegister = false;
        this.isRegisterFail = true;
      }
    );
  }

}
