import { ViviendaAparato } from './vivienda-aparato.model';
import { Cliente } from 'src/app/modelos/Cliente.model'
import { Orden } from './Orden.model';

export class Vivienda {
    idVivienda: number;
    propietario: Cliente;
    inquilino: Cliente;
    aparatos: ViviendaAparato[];
    ordenes: Orden[];
    direccion: string;
    localidad: string;
    provincia: string;
}
