import { Injectable } from '@angular/core';
import {NavigationLinksProviderService} from "../services/navigation-links-provider.service";
import {Link} from "../../shared/models/link.model";
import {AuthenticationService} from "../services/authentication/authentication.service";
import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Injectable()
export class HeaderService {

  private unauthenticatedAccountLinks: Link[] = [
    new Link("Login", "/login"),
    new Link("Sign Up", "/register-librarian")];

  private authenticatedAccountLinks: Link[] = [
    new Link("Logout", "/logout")];

  private accountLinks$: BehaviorSubject<Link[]> = new BehaviorSubject([]);

  constructor(private navigationLinksProvider: NavigationLinksProviderService,
              private authenticationService: AuthenticationService) {
    this.authenticationService.isAuthenticated().subscribe(
      (isAuthenticated: boolean) => {
        if(isAuthenticated) {
          this.accountLinks$.next(this.authenticatedAccountLinks);
        } else {
          this.accountLinks$.next(this.unauthenticatedAccountLinks);
        }
      });
  }

  getNavLinks(): Observable<Link[]> {
    return this.navigationLinksProvider.getLinks();
  }

  getAccountLinks(): Observable<Link[]> {
    return this.accountLinks$.asObservable();
  }
}
