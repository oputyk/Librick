import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../core/services/api/authentication/authentication.service";
import {Router} from "@angular/router";
import {User} from "../../shared/models/user.model";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  token: string;
  user$: Observable<User>;

  ngOnInit() {
    this.token = this.authenticationService.getToken();
    this.user$ = this.authenticationService.getUser();
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['']);
  }

}
