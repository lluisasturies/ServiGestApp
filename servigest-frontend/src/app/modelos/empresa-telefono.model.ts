import { Cliente } from './cliente.model';
import { Empresa } from './Empresa.model';

export class EmpresaTelefono {
    idTelefono: number;
    telefono: number;
    informacion: string;
    empresa: Empresa;
}
