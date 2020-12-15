import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from './servicios/token.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public isLogin = false;
  public roles: string[];
  public authority: string;
  public isMenuCollapsed = true;
  public nombreUsuario;

  constructor(
    private tokenService: TokenService, 
    private router: Router) { }

  ngOnInit() {
    if (this.tokenService.getToken()) {
      this.nombreUsuario = this.tokenService.getUserName();
      this.isLogin = true;
      this.roles = [];
      this.roles = this.tokenService.getAuthorities();
      this.roles.every(rol => {
        if (rol === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        }
        this.authority = 'tecnico';
        return true;
      });
    }
  }

  logOut(): void {
    this.tokenService.logOut();
    this.isLogin = false;
    this.authority = '';
    this.router.navigate(['/logout']);
  }
}
