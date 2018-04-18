import { Injectable } from '@angular/core';
import {Book} from "../../../../shared/models/book.model";
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class BookApiService {

  constructor(private http: HttpClient) { }

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`api/book/all`);
  }

}
