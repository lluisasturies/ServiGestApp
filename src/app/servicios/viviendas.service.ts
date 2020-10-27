import { ClientesService } from 'src/app/servicios/clientes.service';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Vivienda } from 'src/app/modelos/Vivienda.model'
import { Cliente } from 'src/app/modelos/Cliente.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ViviendasService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/viviendas';

  // Variables
  private viviendas: Observable<Vivienda[]>;
  private vivienda: Observable<Vivienda>;

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Get que devuelve una lista de Viviendas
  getViviendas(): Observable<Vivienda[]> {

    // Obtengo todas las zonas y las coloco en un Observable de Zona
    this.viviendas = this.http.get<Vivienda[]>(this.apiURL);

    return this.viviendas;

  }

  // Obtengo UNA Vivienda en concreto
  getVivienda(idVivienda: number): Observable<Vivienda> {
    return this.http.get<Vivienda>(this.apiURL + '/' + idVivienda);
  }

  // Add
  addVivienda(vivienda: Vivienda): Observable<Vivienda> {
    return this.http.post<Vivienda>(this.apiURL + '/add', vivienda, { headers: this.headers });
  }

  // Update
  updateVivienda(vivienda: Vivienda): Observable<Vivienda> {
    return this.http.put<Vivienda>(this.apiURL + '/update', vivienda, { headers: this.headers });
  }

  // Delete
  deleteVivienda(vivienda: Vivienda): Observable<Vivienda> {
    return this.http.delete<Vivienda>(this.apiURL + '/delete/' + vivienda.idVivienda);
  }
}
