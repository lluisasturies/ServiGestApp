import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// Modelos
import { LoginUsuario } from 'src/app/modelos/login-usuario.model';
import { JwtModel } from 'src/app/modelos/jwt.model';
import { environment } from 'src/environments/environment';

const cabecera = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiURL = environment.apiURL + '/auth';

  constructor(private httpClient: HttpClient) { }

  public login(usuario: LoginUsuario): Observable<JwtModel> {
    return this.httpClient.post<JwtModel>(this.apiURL + '/login', usuario, cabecera);
  }

}
