import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../services/authentication/authentication.service";
import {LoginService} from "./login.service";
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [LoginService]
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  isLoggedIn$: Observable<boolean>;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  login() {
    this.isLoggedIn$ = this.loginService.login(this.email, this.password);
  }

}
