import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs/Observable';
import {AuthenticationService} from "../services/authentication/authentication.service";

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private authenticationService: AuthenticationService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | boolean {
      this.authenticationService.isAuthenticated().subscribe(
        (isAuthenticated: boolean) => {
          if(!isAuthenticated) {
            this.router.navigate(['login']);
          }
        }
      );

      return this.authenticationService.isAuthenticated();
  }
}
