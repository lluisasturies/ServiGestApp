import { Rol } from './rol.model';

export class Usuario {
  id: number;
  nombre: string;
  nombreUsuario: string;
  email: string;
  roles: Rol[];
  password: string;

  /*
  constructor(nombre: string, nombreUsuario: string, email: string, password: string) {
      this.nombre = nombre;
      this.nombreUsuario = nombreUsuario;
      this.email = email;
      this.password = password;
      this.roles = ['user'];
  }
  */

  rol: Rol = new Rol();

  constructor() {
    this.rol.rolNombre = "ROLE_TECNICO";
    this.roles = [this.rol];
}

}
