import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

// Servicio
import { ClienteContacto } from '../modelos/cliente-contacto.model';
import { Observable } from 'rxjs';
import { Cliente } from '../modelos/Cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ClientesContactosService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = 'http://localhost:8080/api/clientes/contactos';

  // Variables

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Add
  addClienteContacto(clienteContacto: ClienteContacto): Observable<ClienteContacto> {
    return this.http.post<ClienteContacto>(this.apiURL + '/add', clienteContacto, { headers: this.headers });
  }

  // Update
  updateClienteContacto(cliente: Cliente, contacto: ClienteContacto): Observable<ClienteContacto> {
    return this.http.put<ClienteContacto>(this.apiURL + '/update/' + contacto.idContacto, cliente, { headers: this.headers });
  }

  // Delete
  deleteClienteContacto(clienteContacto: ClienteContacto): Observable<ClienteContacto> {
    return this.http.delete<ClienteContacto>(this.apiURL + '/delete/' + clienteContacto.idContacto);
  }
}
