import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// Modelo
import { Cliente } from 'src/app/modelos/Cliente.model'
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/clientes';

  // Variables
  private clientes: Observable<Cliente[]>;
  private cliente: Observable<Cliente>;

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Get que devuelve una lista de Clientes
  getClientes(): Observable<Cliente[]> {

    // Obtengo todas los clientes y las coloco en un Observable de Cliente
    this.clientes = this.http.get<Cliente[]>(this.apiURL);

    return this.clientes;

  }

  // Obtengo UN Cliente en concreto
  getCliente(idCliente: number): Observable<Cliente> {
    this.cliente = this.http.get<Cliente>(this.apiURL + '/' + idCliente);

    return this.cliente;
  }

  // Add
  addCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.apiURL + '/add', cliente, { headers: this.headers });
  }

  // Update
  updateCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(this.apiURL + '/update', cliente, { headers: this.headers });
  }

  // Delete
  deleteCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.delete<Cliente>(this.apiURL + '/delete/' + cliente.idCliente);
  }
}
