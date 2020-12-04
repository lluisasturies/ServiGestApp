import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { OrdenCitaPendiente } from '../modelos/orden-cita-pendiente.model';
import { OrdenCita } from '../modelos/orden-cita.model';

@Injectable({
  providedIn: 'root'
})
export class OrdenesCitasService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/ordenes/citas';

  // Variables
  private citasPendientes: Observable<OrdenCitaPendiente[]>;

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Lista de las Citas Pendientes
  getCitasPendientes(): Observable<OrdenCitaPendiente[]> {
    this.citasPendientes = this.http.get<OrdenCitaPendiente[]>(this.apiURL + '/pendientes');

    return this.citasPendientes;
  }

  // Add
  addCita(ordenCita: OrdenCita): Observable<OrdenCita> {
    return this.http.post<OrdenCita>(this.apiURL + '/add', ordenCita, { headers: this.headers });
  }

  // Update
  updateCita(ordenCita: OrdenCita): Observable<OrdenCita> {
    return this.http.put<OrdenCita>(this.apiURL + '/update', ordenCita, { headers: this.headers });
  }

  // Delete
  deleteCita(ordenCita: OrdenCita): Observable<OrdenCita> {
    return this.http.delete<OrdenCita>(this.apiURL + '/delete/' + ordenCita.idCita);
  }
}
