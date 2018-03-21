import { Injectable } from '@angular/core';
import {NavigationLinksProviderService} from "../services/navigation-links-provider.service";
import {Link} from "../../shared/models/link.model";
import {AuthenticationService} from "../services/authentication/authentication.service";
import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {User} from "../../shared/models/user.model";

@Injectable()
export class HeaderService {

  private unauthenticatedAccountLinks: Link[];

  private authenticatedAccountLinks: Link[];

  private accountLinks$: BehaviorSubject<Link[]> = new BehaviorSubject([]);

  constructor(private navigationLinksProvider: NavigationLinksProviderService,
              private authenticationService: AuthenticationService) {
    this.initUnauthenticatedAccountLinks();
    this.initAuthenticatedAccountLinks();

    this.authenticationService.isAuthenticated().subscribe(
      (isAuthenticated: boolean) => {
        if(isAuthenticated) {
          this.accountLinks$.next(this.authenticatedAccountLinks);
        } else {
          this.accountLinks$.next(this.unauthenticatedAccountLinks);
        }
      });
  }

  initAuthenticatedAccountLinks() {
    this.authenticatedAccountLinks = [
      new Link(this.authenticationService.getUser().map((user: User) => user.email), ""),
      new Link(Observable.of("Logout"), "/login", () => this.authenticationService.logout())];
  }

  initUnauthenticatedAccountLinks() {
    this.unauthenticatedAccountLinks = [
      new Link(Observable.of("Login"), "/login"),
      new Link(Observable.of("Sign Up"), "/register-librarian")];
  }

  getNavLinks(): Observable<Link[]> {
    return this.navigationLinksProvider.getLinks();
  }

  getAccountLinks(): Observable<Link[]> {
    return this.accountLinks$.asObservable();
  }
}
