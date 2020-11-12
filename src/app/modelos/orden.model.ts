import { Vivienda } from 'src/app/modelos/Vivienda.model';
import { Empresa } from 'src/app/modelos/Empresa.model';
import { OrdenLinea } from 'src/app/modelos/Orden-linea.model';
import { OrdenCita } from './orden-cita.model';

export class Orden {
    idOrden: number;
    vivienda: Vivienda;
    empresa: Empresa;
    lineas: OrdenLinea;
    citasPendientes: OrdenCita;
    citas: OrdenCita;
    orden: string;
    asunto: string;
    fecha: string;
    estado: number;
}
