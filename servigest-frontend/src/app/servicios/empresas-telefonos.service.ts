import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

// Servicio
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { EmpresaTelefono } from '../modelos/empresa-telefono.model';

@Injectable({
  providedIn: 'root'
})
export class EmpresasTelefonosService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/empresas/telefonos';

  // Variables

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Add
  addEmpresaTelefono(empresaTelefono: EmpresaTelefono): Observable<EmpresaTelefono> {
    return this.http.post<EmpresaTelefono>(this.apiURL + '/add', empresaTelefono, { headers: this.headers });
  }

  // Update
  updateEmpresaTelefono(empresaTelefono: EmpresaTelefono): Observable<EmpresaTelefono> {
    return this.http.put<EmpresaTelefono>(this.apiURL + '/update/', empresaTelefono, { headers: this.headers });
  }

  // Delete
  deleteEmpresaTelefono(empresaTelefono: EmpresaTelefono): Observable<EmpresaTelefono> {
    return this.http.delete<EmpresaTelefono>(this.apiURL + '/delete/' + empresaTelefono.telefono);
  }
}
