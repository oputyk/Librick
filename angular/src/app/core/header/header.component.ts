import { Component, OnInit } from '@angular/core';
import {NavigationLinksProviderService} from "../services/navigation-links-provider.service";
import {Link} from "../../shared/models/link.model";
import {HeaderService} from "./header.service";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  providers: [HeaderService]
})
export class HeaderComponent implements OnInit {

  navLinks$: Observable<Link[]>;
  accountLinks$: Observable<Link[]>;

  constructor(private headerService: HeaderService) { }

  ngOnInit() {
    this.navLinks$ = this.headerService.getNavLinks();
    this.accountLinks$ = this.headerService.getAccountLinks();
  }

}
