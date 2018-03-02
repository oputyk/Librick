import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "@app/shared/model/user.model";
import {Observable} from "rxjs/Observable";
import {environment} from "@env/environment";

@Injectable()
export class UserApiService {
  constructor(private http: HttpClient) { }

  getUser(user: User): Observable<User> {
    return this.http.get<User>(`/api/user/secure/`, {withCredentials: true});
  }
}
