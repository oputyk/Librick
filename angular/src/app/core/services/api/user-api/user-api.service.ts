import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {User} from "../../../../shared/models/user.model";
import {UserCredentials} from "../../../../shared/models/user-credentials.model";

@Injectable()
export class UserApiService {
  constructor(private http: HttpClient) { }

  getUser(): Observable<User> {
    return this.http.post<User>(`/api/user/secure/current`, null);
  }

  registerLibrarian(userCredentials: UserCredentials): Observable<boolean> {
    return this.http.post<boolean>('/api/user/register-librarian', userCredentials);
  }

  changePassword(oldPassword: string, newPassword: string): Observable<boolean> {
    return this.http.post<boolean>("/api/user/secure/change-password", {oldPassword: oldPassword, newPassword: newPassword});
  }
}
