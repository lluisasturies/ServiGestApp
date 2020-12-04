import { ClienteContacto } from './cliente-contacto.model';

export class Cliente {
    idCliente: number;
    contactos: ClienteContacto[];
    nombre: string;
    apellidos: string;
    dni: string;
}
