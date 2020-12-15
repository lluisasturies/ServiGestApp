import { Rol } from './rol.model';

export class UsuarioUpdate {
  id: number;
  nombre: string;
  email: string;
  oldEmail: string;
  rol: Rol;
  password: string;
}
