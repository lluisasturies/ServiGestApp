import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

// Servicio
import { EmpresaContacto } from '../modelos/empresa-contacto.model';
import { Observable } from 'rxjs';
import { Empresa } from '../modelos/Empresa.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmpresasContactosService {

  constructor(private http: HttpClient) { }

  // Ruta del JSON
  private apiURL = environment.apiURL + '/empresas/contactos';

  // Variables

  // Utiles
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  // Add
  addEmrpesaContacto(empresaContacto: EmpresaContacto): Observable<EmpresaContacto> {
    return this.http.post<EmpresaContacto>(this.apiURL + '/add', empresaContacto, { headers: this.headers });
  }

  // Update
  updateEmpresaContacto(empresaContacto: EmpresaContacto): Observable<EmpresaContacto> {
    return this.http.put<EmpresaContacto>(this.apiURL + '/update/', empresaContacto, { headers: this.headers });
  }

  // Delete
  deleteEmpresaContacto(empresaContacto: EmpresaContacto): Observable<EmpresaContacto> {
    return this.http.delete<EmpresaContacto>(this.apiURL + '/delete/' + empresaContacto.idContacto);
  }
}
