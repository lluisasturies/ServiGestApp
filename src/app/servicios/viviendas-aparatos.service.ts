import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// Modelos
import { ViviendaAparato } from '../modelos/vivienda-aparato.model';
import { Vivienda } from '../modelos/Vivienda.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ViviendasAparatosService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/vivienda/aparato';

  // Variables

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Add
  addAparatoVivienda(viviendaAparato: ViviendaAparato): Observable<ViviendaAparato> {
    return this.http.post<ViviendaAparato>(this.apiURL + '/add', viviendaAparato, { headers: this.headers });
  }

  // Delete
  deleteViviendaAparato(viviendaAparato: ViviendaAparato): Observable<Vivienda> {
    return this.http.delete<Vivienda>(this.apiURL + '/delete/' + viviendaAparato.idAparato);
  }
}
