import {Component, Input, OnInit} from '@angular/core';
import {Link} from "../../../shared/models/link.model";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  @Input()
  links: Link[];

  constructor() { }

  ngOnInit() {
  }

}
