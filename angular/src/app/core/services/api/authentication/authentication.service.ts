import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "@app/shared/model/user.model";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AuthenticationService {
  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<User> {
    let headers: Headers = new Headers();
    headers.append("Authorization", "Basic " + btoa(email + ":" + password));
    headers.append("Content-Type", "application/x-www-form-urlencoded");

    return this.http.post<User>(`/api/user/secure/`, {headers: headers});
  }

  logout(): Observable<any> {
    return this.http.get<any>(`/logout`, {withCredentials: true});
  }
}
