import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/servicios/token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  public isLogin = false;
  public authority: string;

  constructor(
    private tokenService: TokenService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.logOut();
  }

  logOut(): void {
    this.tokenService.logOut();
    this.isLogin = false;
    this.authority = '';
    this.router.navigate(['']);
  }

}
