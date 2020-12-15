import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../modelos/nuevo-usuario.model';
import { environment } from 'src/environments/environment';
import { UsuarioPassword } from '../modelos/usuario-password.model';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/usuarios';

  // Variables
  private usuarios: Observable<Usuario[]>;
  private usuario: Observable<Usuario>;

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Get que devuelve una lista de Usuarios
  getUsuarios(): Observable<Usuario[]> {
    this.usuarios = this.http.get<Usuario[]>(this.apiURL);

    return this.usuarios;
  }

  // Obtengo UN Usuario en concreto
  getUsuario(usuario: string): Observable<Usuario> {
    this.usuario = this.http.get<Usuario>(this.apiURL + '/' + usuario);

    return this.usuario;
  }

  // Add
  addUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(this.apiURL + '/add', usuario, { headers: this.headers });
  }

  // Update
  updateUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(this.apiURL + '/update', usuario, { headers: this.headers });
  }

  // Update Password
  updatePassword(usuarioPassword: UsuarioPassword): Observable<UsuarioPassword> {
    return this.http.put<UsuarioPassword>(this.apiURL + '/updatePassword', usuarioPassword, { headers: this.headers });
  }

  // Delete
  deleteUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.delete<Usuario>(this.apiURL + '/delete/' + usuario.id);
  }
}
