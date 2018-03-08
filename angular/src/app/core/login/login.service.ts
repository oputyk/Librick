import { Injectable } from '@angular/core';
import {User} from "../../shared/models/user.model";
import {AuthenticationService} from "../services/api/authentication/authentication.service";
import {Router} from "@angular/router";
import {log} from "util";

@Injectable()
export class LoginService {

  constructor(private authenticationService: AuthenticationService,
              private router: Router) { }

  login(email: string, password: string) {
    this.authenticationService.logout();

    this.authenticationService.login(email, password).subscribe(

      (authenticated: boolean) => {
        if(authenticated) {
          this.router.navigate(['librarian']);
        }
      },

      (err) => {
        if(err === "Unauthorized") {
          this.router.navigate(['login']);
        }
      });
  }

}
