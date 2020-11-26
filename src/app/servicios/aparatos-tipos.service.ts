import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AparatoTipo } from '../modelos/aparato-tipo.model';

@Injectable({
  providedIn: 'root'
})
export class AparatosTiposService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/aparatos/tipos';

  // Variables
  private tipos: Observable<AparatoTipo[]>;
  private tipo: Observable<AparatoTipo>;

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Get que devuelve los Tipos de Aparatos
  getTipos(): Observable<AparatoTipo[]> {
    this.tipos = this.http.get<AparatoTipo[]>(this.apiURL);

    return this.tipos;
  }

  // Add
  addAparatoTipo(aparatoTipo: AparatoTipo): Observable<AparatoTipo> {
    return this.http.post<AparatoTipo>(this.apiURL + '/add', aparatoTipo, { headers: this.headers });
  }

  // Update
  updateAparatoTipo(aparatoTipo: AparatoTipo): Observable<AparatoTipo> {
    return this.http.put<AparatoTipo>(this.apiURL + '/update/', aparatoTipo, { headers: this.headers });
  }

  // Delete
  deleteAparatoTipo(aparatoTipo: AparatoTipo): Observable<AparatoTipo> {
    return this.http.delete<AparatoTipo>(this.apiURL + '/delete/' + aparatoTipo.idTipo);
  }
}