import { Injectable } from '@angular/core';
import {User} from "../../shared/models/user.model";
import {AuthenticationService} from "../services/api/authentication/authentication.service";
import {Router} from "@angular/router";
import {log} from "util";
import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Injectable()
export class LoginService {

  private loggedIn$ = new Subject<boolean>();

  constructor(private authenticationService: AuthenticationService,
              private router: Router) { }

  login(email: string, password: string): Observable<boolean> {
    this.authenticationService.logout();

    this.authenticationService.login(email, password).subscribe(
      (authenticated: boolean) => {
        this.loggedIn$.next(authenticated);

        if(authenticated) {
          this.router.navigate(['librarian']);
        }
      },
      (error) => {
        console.log(error);
        throw error;
      });

    return this.loggedIn$.asObservable();
  }
}
