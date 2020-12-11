import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

// Servicio
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ClienteTelefono } from '../modelos/cliente-telefono.model';

@Injectable({
  providedIn: 'root'
})
export class ClientesTelefonosService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/clientes/telefonos';

  // Variables

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Add
  addClienteTelefono(clienteTelefono: ClienteTelefono): Observable<ClienteTelefono> {
    return this.http.post<ClienteTelefono>(this.apiURL + '/add', clienteTelefono, { headers: this.headers });
  }

  // Update
  updateClienteTelefono(clienteTelefono: ClienteTelefono): Observable<ClienteTelefono> {
    return this.http.put<ClienteTelefono>(this.apiURL + '/update/', clienteTelefono, { headers: this.headers });
  }

  // Delete
  deleteClienteTelefono(clienteTelefono: ClienteTelefono): Observable<ClienteTelefono> {
    return this.http.delete<ClienteTelefono>(this.apiURL + '/delete/' + clienteTelefono.telefono);
  }
}
