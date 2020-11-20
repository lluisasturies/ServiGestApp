import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

// Modelos
import { LoginUsuario } from 'src/app/modelos/login-usuario.model';

// Servicios
import { AuthService } from 'src/app/servicios/auth.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // Variables
  public form: any = {};
  public usuario: LoginUsuario;
  public isLogged = false;
  public isLoginFail = false;
  public roles: string[] = [];
  public errorMsg = '';

  constructor(
    private authService: AuthService,
    private tokenService: TokenService
  ) { }

  ngOnInit() {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
      this.isLoginFail = false;
      this.roles = this.tokenService.getAuthorities();
    }
  }

  onLogin(): void {
    this.usuario = new LoginUsuario(this.form.email, this.form.password);

    this.authService.login(this.usuario).subscribe(data => {
      this.tokenService.setToken(data.token);
      this.tokenService.setUserName(data.email);
      this.tokenService.setAuthorities(data.authorities);

      this.isLogged = true;
      this.isLoginFail = false;
      this.roles = this.tokenService.getAuthorities();
      window.location.reload();
    },
      (err: any) => {
        this.isLogged = false;
        this.isLoginFail = true;
        this.errorMsg = err.error.message;
      }
    );
  }

}
