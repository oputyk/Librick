import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../core/services/api/authentication/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  token: string;

  ngOnInit() {
    this.token = this.authenticationService.getToken();
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['']);
  }

}
