import { Component, OnInit } from '@angular/core';
import {RegisterLibrarianService} from "./register-librarian.service";
import {Observable} from "rxjs/Observable";
import {UserCredentials} from "../../shared/models/user-credentials.model";

@Component({
  selector: 'app-register-librarian',
  templateUrl: './register-librarian.component.html',
  styleUrls: ['./register-librarian.component.scss'],
  providers: [RegisterLibrarianService]
})
export class RegisterLibrarianComponent implements OnInit {

  userCredentials: UserCredentials = new UserCredentials();
  repeatedPassword: string = "";
  isRegistered$: Observable<boolean>;

  constructor(private registerLibrarianService: RegisterLibrarianService) { }

  ngOnInit() {
  }

  registerLibrarian() {
    if(this.repeatedPassword == this.userCredentials.password) {
      this.isRegistered$ = this.registerLibrarianService.registerLibrarian(this.userCredentials);
    }
  }

}
