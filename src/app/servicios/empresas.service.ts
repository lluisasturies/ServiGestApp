import { Injectable } from '@angular/core';
import { Empresa } from '../modelos/Empresa.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/empresas';

  // Variables
  private empresas: Observable<Empresa[]>;
  private empresa: Observable<Empresa>;

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Get que devuelve una lista de Empresas
  getEmpresas(): Observable<Empresa[]> {
    this.empresas = this.http.get<Empresa[]>(this.apiURL);

    return this.empresas;
  }

  // Obtengo UNA Empresa en concreto
  getEmpresa(idOrden: number): Observable<Empresa> {
    this.empresa = this.http.get<Empresa>(this.apiURL + '/' + idOrden);

    return this.empresa;
  }

  // Add
  addEmpresa(empresa: Empresa): Observable<Empresa> {
    return this.http.post<Empresa>(this.apiURL + '/add', empresa, { headers: this.headers });
  }

  // Update
  updateEmpresa(empresa: Empresa): Observable<Empresa> {
    return this.http.put<Empresa>(this.apiURL + '/update', empresa, { headers: this.headers });
  }

  // Delete
  deleteEmpresa(empresa: Empresa): Observable<Empresa> {
    return this.http.delete<Empresa>(this.apiURL + '/delete/' + empresa.idEmpresa);
  }
}
