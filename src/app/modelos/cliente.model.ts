import { ClienteContacto } from './cliente-contacto.model';

// Modelo de Cliente
export class Cliente {
    idCliente: number;
    contactos: ClienteContacto[];
    nombre: string;
    apellidos: string;
    dni: string;
}
