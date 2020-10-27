// Modelos
import { Aparato } from './aparato.model';
import { Vivienda } from './Vivienda.model';

// Modelo de ViviendaAparato
export class ViviendaAparato {
  id: number;
  vivienda: Vivienda;
  aparato: Aparato;
}
