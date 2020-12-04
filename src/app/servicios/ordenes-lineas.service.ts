import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { OrdenLinea } from '../modelos/Orden-linea.model';

@Injectable({
  providedIn: 'root'
})
export class OrdenesLineasService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/ordenes/lineas';

  // Variables

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Add
  addOrdenLinea(ordenLinea: OrdenLinea): Observable<OrdenLinea> {
    return this.http.post<OrdenLinea>(this.apiURL + '/add', ordenLinea, { headers: this.headers });
  }

  // Update
  updateOrdenLinea(ordenLinea: OrdenLinea): Observable<OrdenLinea> {
    return this.http.put<OrdenLinea>(this.apiURL + '/update', ordenLinea, { headers: this.headers });
  }

  // Delete
  deleteOrdenLinea(ordenLinea: OrdenLinea): Observable<OrdenLinea> {
    return this.http.delete<OrdenLinea>(this.apiURL + '/delete/' + ordenLinea.idLinea);
  }
}
