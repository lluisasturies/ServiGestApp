import { Cliente } from './cliente.model';
import { Empresa } from './Empresa.model';

export class EmpresaEmail {
    idEmail: number;
    email: string;
    informacion: string;
    empresa: Empresa;
}
