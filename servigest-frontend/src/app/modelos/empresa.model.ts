import { EmpresaContacto } from './empresa-contacto.model';
import { EmpresaEmail } from './empresa-email.model';
import { EmpresaTelefono } from './empresa-telefono.model';

// Modelo de Empresa
export class Empresa {
    idEmpresa: number;
    emails: EmpresaEmail[];
    telefonos: EmpresaTelefono[];
    nombreComercial: string;
    nombreFiscal: string;
    nif: string;
    direccion: string;
    localidad: string;
    provincia: string;
    email: string;
    prefijoOrdenes: string;
}
