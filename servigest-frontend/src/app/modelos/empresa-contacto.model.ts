import { Cliente } from './cliente.model';
import { Empresa } from './Empresa.model';
import { TipoContacto } from './tipo-contacto.model';

export class EmpresaContacto {
    idContacto: number;
    empresa: Empresa;
    tipo: TipoContacto;
    dato: string;    
}
