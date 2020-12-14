import { StringMap } from '@angular/compiler/src/compiler_facade_interface';
import { Orden } from './Orden.model';

export class OrdenCitaPendiente {
    idCita: number;
    idOrden: number;
    idVivienda: number;
    orden: string;
    prefijoEmpresa: string;
    direccion: string;
    fecha: string;
    horaInicio: string;
    horaFin: string;
}
