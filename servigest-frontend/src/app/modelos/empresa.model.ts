import { EmpresaContacto } from './empresa-contacto.model';

// Modelo de Empresa
export class Empresa {
    idEmpresa: number;
    contactos: EmpresaContacto[];
    nombreComercial: string;
    nombreFiscal: string;
    nif: string;
    direccion: string;
    localidad: string;
    provincia: string;
    email: string;
    prefijoOrdenes: string;
}
