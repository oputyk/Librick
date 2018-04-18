import { Injectable } from '@angular/core';
import {Link} from "../../shared/models/link.model";
import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {NavigationEnd, Router} from "@angular/router";
import {AuthGuard} from "../guards/auth.guard";

@Injectable()
export class NavigationLinksProviderService {
  private links$: BehaviorSubject<Link[]> = new BehaviorSubject([]);

  private publicLinks: Link[] = [
    new Link(Observable.of("Home"), "/home")];

  private librarianLinks: Link[] = [
    new Link(Observable.of("Dashboard"), "/librarian/dashboard"),
    new Link(Observable.of("Book storage"), "/librarian/book-storage")];

  constructor(private router: Router) {
    this.router.events
      .filter(event => event instanceof NavigationEnd)
      .subscribe(
        (event: NavigationEnd) => {
          if(event.url.includes("/librarian", 0)) {
            this.setLinks(this.librarianLinks);
          } else if(event.url.includes("/user", 0)) {
            // do not anything
          } else {
            this.setLinks(this.publicLinks);
          }
        });
  }

  getLinks(): Observable<Link[]> {
    return this.links$.asObservable();
  }

  setLinks(links: Link[]) {
    this.links$.next(links);
  }
}
