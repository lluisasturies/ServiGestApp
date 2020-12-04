import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// Modelo
import { Rol } from 'src/app/modelos/Rol.model'
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RolesService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/usuarios/roles';

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Get que devuelve una lista de Roles
  getRoles(): Observable<Rol[]> {

    // Obtengo todas los clientes y las coloco en un Observable de Cliente
    return this.http.get<Rol[]>(this.apiURL);

  }
  
}
