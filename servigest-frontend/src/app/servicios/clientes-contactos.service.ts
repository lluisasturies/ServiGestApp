import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

// Servicio
import { ClienteContacto } from '../modelos/cliente-contacto.model';
import { Observable } from 'rxjs';
import { Cliente } from '../modelos/Cliente.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientesContactosService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/clientes/contactos';

  // Variables

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Add
  addClienteContacto(clienteContacto: ClienteContacto): Observable<ClienteContacto> {
    return this.http.post<ClienteContacto>(this.apiURL + '/add', clienteContacto, { headers: this.headers });
  }

  // Update
  updateClienteContacto(clienteContacto: ClienteContacto): Observable<ClienteContacto> {
    return this.http.put<ClienteContacto>(this.apiURL + '/update/', clienteContacto, { headers: this.headers });
  }

  // Delete
  deleteClienteContacto(clienteContacto: ClienteContacto): Observable<ClienteContacto> {
    return this.http.delete<ClienteContacto>(this.apiURL + '/delete/' + clienteContacto.idContacto);
  }
}
