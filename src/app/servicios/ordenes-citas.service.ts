import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { OrdenCita } from '../modelos/orden-cita.model';

@Injectable({
  providedIn: 'root'
})
export class OrdenesCitasService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/ordenes/citas';

  // Variables
  private citas: Observable<OrdenCita[]>;

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Lista de las Citas Pendientes
  getCitasPendientes(): Observable<OrdenCita[]> {
    this.citas = this.http.get<OrdenCita[]>(this.apiURL + '/pendientes');

    return this.citas;
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
