import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { Empresa } from 'src/app/modelos/Empresa.model';

// Modelo de Orden
export class Orden {
    idOrden: number;
    vivienda: Vivienda;
    empresa: Empresa;
    orden: string;
    asunto: string;
    fecha: string;
    estado: number;
}
