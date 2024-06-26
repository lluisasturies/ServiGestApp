import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

// Servicios
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})

export class GuardService implements CanActivate {

  realRol: string;

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const expectedRol = route.data.expectedRol;
    const roles = this.tokenService.getAuthorities();
    this.realRol = 'tecnico';
    roles.forEach(rol => {
      if (rol === 'ROLE_ADMIN') {
        this.realRol = 'admin';
      }
    });
    if (!this.tokenService.getToken() || expectedRol.indexOf(this.realRol) === -1) {
      this.router.navigate(['']);
      return false;
    }
    return true;
  }

  constructor(private tokenService: TokenService, private router: Router) { }
}
