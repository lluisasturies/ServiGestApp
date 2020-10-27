import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Modelo
import { Aparato } from '../modelos/aparato.model';
import { ViviendaAparato } from '../modelos/vivienda-aparato.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AparatosService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/aparatos';

  // Variables
  private aparatos: Observable<Aparato[]>;
  private aparato: Observable<Aparato>;
  private viviendaAparatos: Observable<ViviendaAparato[]>;

  // Get que devuelve una lista de Aparatos
  getAparatos(): Observable<Aparato[]> {
    this.aparatos = this.http.get<Aparato[]>(this.apiURL);

    return this.aparatos;
  }

  // Obtengo UN Aparato en concreto
  getOrden(idOrden: number): Observable<Aparato> {
    this.aparato = this.http.get<Aparato>(this.apiURL + '/' + idOrden);

    return this.aparato;
  }

}
