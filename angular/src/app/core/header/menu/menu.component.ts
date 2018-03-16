import {Component, Input, OnInit} from '@angular/core';
import {Link} from "../../../shared/models/link.model";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  @Input()
  links$: Observable<Link[]>;

  constructor() { }

  ngOnInit() {
  }

}
