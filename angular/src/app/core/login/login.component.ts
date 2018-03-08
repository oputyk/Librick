import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../services/api/authentication/authentication.service";
import {LoginService} from "./login.service";
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [LoginService]
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  login() {
    this.loginService.login(this.email, this.password);
  }

}
