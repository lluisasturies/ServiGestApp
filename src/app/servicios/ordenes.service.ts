import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// Modelo
import { Orden } from 'src/app/modelos/Orden.model'
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrdenesService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/ordenes';

  // Variables
  private ordenes: Observable<Orden[]>;
  private orden: Observable<Orden>;

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Get que devuelve una lista de Ordenes
  getOrdenes(): Observable<Orden[]> {
    this.ordenes = this.http.get<Orden[]>(this.apiURL);

    return this.ordenes;
  }

  // Lista de las Ordenes Abiertas
  getOrdenesAbiertas(): Observable<Orden[]> {
    this.ordenes = this.http.get<Orden[]>(this.apiURL + '/abiertas');

    return this.ordenes;
  }

  // Obtengo UNA Orden en concreto
  getOrden(idOrden: number): Observable<Orden> {
    this.orden = this.http.get<Orden>(this.apiURL + '/' + idOrden);

    return this.orden;
  }

  // Add
  addOrden(orden: Orden): Observable<Orden> {
    return this.http.post<Orden>(this.apiURL + '/add', orden, { headers: this.headers });
  }

  // Update
  updateOrden(orden: Orden): Observable<Orden> {
    return this.http.put<Orden>(this.apiURL + '/update', orden, { headers: this.headers });
  }

  // Update Estado
  updateEstadoOrden(estado: boolean, orden: Orden): Observable<Orden> {
    return this.http.put<Orden>(this.apiURL + '/update/estado' + estado, orden, { headers: this.headers });
  }

  // Delete
  deleteOrden(orden: Orden): Observable<Orden> {
    return this.http.delete<Orden>(this.apiURL + '/delete/' + orden.idOrden);
  }
}
