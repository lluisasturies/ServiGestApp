import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AparatoMarca } from '../modelos/aparato-marca.model';

@Injectable({
  providedIn: 'root'
})
export class AparatosMarcasService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/aparatos/marcas';

  // Variables
  private marcas: Observable<AparatoMarca[]>;
  private marca: Observable<AparatoMarca>;

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Get que devuelve las Marcas de Aparatos
  getMarcas(): Observable<AparatoMarca[]> {
    this.marcas = this.http.get<AparatoMarca[]>(this.apiURL);

    return this.marcas;
  }

  // Add
  addAparatoMarca(aparatoMarca: AparatoMarca): Observable<AparatoMarca> {
    return this.http.post<AparatoMarca>(this.apiURL + '/add', aparatoMarca, { headers: this.headers });
  }

  // Update
  updateAparatoMarca(aparatoMarca: AparatoMarca): Observable<AparatoMarca> {
    return this.http.put<AparatoMarca>(this.apiURL + '/update/', aparatoMarca, { headers: this.headers });
  }

  // Delete
  deleteAparatoMarca(aparatoMarca: AparatoMarca): Observable<AparatoMarca> {
    return this.http.delete<AparatoMarca>(this.apiURL + '/delete/' + aparatoMarca.idMarca);
  }
}
