import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

// Servicio
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ClienteEmail } from '../modelos/cliente-email.model';

@Injectable({
  providedIn: 'root'
})
export class ClientesEmailsService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/clientes/emails';

  // Variables

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Add
  addClienteEmail(clienteEmail: ClienteEmail): Observable<ClienteEmail> {
    return this.http.post<ClienteEmail>(this.apiURL + '/add', clienteEmail, { headers: this.headers });
  }

  // Update
  updateClienteEmail(clienteEmail: ClienteEmail): Observable<ClienteEmail> {
    return this.http.put<ClienteEmail>(this.apiURL + '/update/', clienteEmail, { headers: this.headers });
  }

  // Delete
  deleteClienteEmail(clienteEmail: ClienteEmail): Observable<ClienteEmail> {
    return this.http.delete<ClienteEmail>(this.apiURL + '/delete/' + clienteEmail.email);
  }
}
