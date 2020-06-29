// Modelos
import { AparatoMarca } from './aparato-marca.model';
import { AparatoTipo } from './aparato-tipo.model';

// Modelo de Aparato
export class Aparato {
  idAparato: number;
  modelo: string;
  marca: AparatoMarca;
  tipo: AparatoTipo;
}
