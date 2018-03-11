import { Injectable } from '@angular/core';
import {UserApiService} from "../services/api/user-api/user-api.service";
import {UserCredentials} from "../../shared/models/user-credentials.model";
import {Observable} from "rxjs/Observable";
import {Router} from "@angular/router";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Subject} from "rxjs/Subject";

@Injectable()
export class RegisterLibrarianService {

  private isRegistered$: Subject<boolean> = new Subject();

  constructor(private userApiService: UserApiService, private router: Router) { }
  registerLibrarian(userCredentials: UserCredentials): Observable<boolean> {
    this.userApiService.registerLibrarian(userCredentials).subscribe(
      (registered: boolean) => {
        this.isRegistered$.next(registered);

        if(registered) {
          this.router.navigate(['login']);
        }
      });

    return this.isRegistered$.asObservable();
  }

}
