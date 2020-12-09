import { Cliente } from './cliente.model';
import { TipoContacto } from './tipo-contacto.model';

export class ClienteContacto {
    idContacto: number;
    cliente: Cliente;
    tipo: TipoContacto;
    dato: string;    
}
