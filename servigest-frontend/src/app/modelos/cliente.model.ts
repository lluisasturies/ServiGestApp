import { ClienteEmail } from './cliente-email.model';
import { ClienteTelefono } from './cliente-telefono.model';

export class Cliente {
    idCliente: number;
    telefonos: ClienteTelefono[];
    emails: ClienteEmail[];
    nombre: string;
    apellidos: string;
    dni: string;
}
