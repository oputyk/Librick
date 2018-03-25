import { Injectable } from '@angular/core';
import {UserApiService} from "../../services/api/user-api/user-api.service";
import {Observer} from "rxjs/Observer";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ChangePasswordDialogService {

  constructor(private userApiService: UserApiService) { }

  changePassword(oldPassword: string, newPassword: string): Observable<boolean> {
    return this.userApiService.changePassword(oldPassword, newPassword);
  }
}
