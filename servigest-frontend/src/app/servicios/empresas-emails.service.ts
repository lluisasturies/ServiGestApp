import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

// Servicio
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ClienteEmail } from '../modelos/cliente-email.model';
import { EmpresaEmail } from '../modelos/empresa-email.model';

@Injectable({
  providedIn: 'root'
})
export class EmpresasEmailsService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/empresas/emails';

  // Variables

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Add
  addEmpresaEmail(empresaEmail: EmpresaEmail): Observable<EmpresaEmail> {
    return this.http.post<EmpresaEmail>(this.apiURL + '/add', empresaEmail, { headers: this.headers });
  }

  // Update
  updateEmpresaEmail(empresaEmail: EmpresaEmail): Observable<EmpresaEmail> {
    return this.http.put<EmpresaEmail>(this.apiURL + '/update/', empresaEmail, { headers: this.headers });
  }

  // Delete
  deleteEmpresaEmail(empresaEmail: EmpresaEmail): Observable<EmpresaEmail> {
    return this.http.delete<EmpresaEmail>(this.apiURL + '/delete/' + empresaEmail.idEmail);
  }
}
