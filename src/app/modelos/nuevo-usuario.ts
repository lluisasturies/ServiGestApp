import { Rol } from './rol.model';

export class Usuario {
  id: number;
  nombre: string;
  nombreUsuario: string;
  email: string;
  roles: Rol[];
  password: string;

  rol: Rol = new Rol();

  constructor() {
    this.rol.rolNombre = "ROLE_TECNICO";
    this.roles = [this.rol];
}

}
