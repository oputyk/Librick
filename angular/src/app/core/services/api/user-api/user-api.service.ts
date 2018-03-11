import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "@app/shared/models/user.model";
import {Observable} from "rxjs/Observable";
import {environment} from "@env/environment";
import {UserCredentials} from "@app/shared/models/user-credentials.model";

@Injectable()
export class UserApiService {
  constructor(private http: HttpClient) { }

  getUser(): Observable<User> {
    return this.http.post<User>(`/api/user/secure/current`, null);
  }

  registerLibrarian(userCredentials: UserCredentials): Observable<boolean> {
    return this.http.post<boolean>('/api/user/register-librarian', userCredentials);
  }
}
