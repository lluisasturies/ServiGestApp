import { Rol } from './rol.model';

export class Usuario {
  id: number;
  nombre: string;
  email: string;
  rol: Rol;
  password: string;
}
