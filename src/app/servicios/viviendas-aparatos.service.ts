import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// Modelos
import { ViviendaAparato } from '../modelos/vivienda-aparato.model';
import { Aparato } from '../modelos/aparato.model';
import { Vivienda } from '../modelos/Vivienda.model';

@Injectable({
  providedIn: 'root'
})
export class ViviendasAparatosService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = 'http://localhost:8080/api/aparatos/vivienda';

  // Variables

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Add
  addAparatoVivienda(aparato: Aparato, vivienda: Vivienda): Observable<ViviendaAparato> {
    return this.http.post<ViviendaAparato>(this.apiURL + '/' + vivienda.idVivienda + '/add', aparato, { headers: this.headers });
  }

  // Delete
  deleteViviendaAparato(viviendaAparato: ViviendaAparato): Observable<Vivienda> {
    return this.http.delete<Vivienda>(this.apiURL + '/delete/' + viviendaAparato.id);
  }
}
