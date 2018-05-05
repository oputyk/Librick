import { Injectable } from '@angular/core';
import {Book} from "../../../../shared/models/book.model";
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {elementAttribute} from "@angular/core/src/render3/instructions";

@Injectable()
export class BookApiService {

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`api/book/all`);
  }

  addBook(book: Book): Observable<Book> {
    if(book.id == null) {
      return this.addOrUpdateBook(book);
    } else {
      throw new Error("Id should be null to be created.");
    }
  }

  updateBook(book: Book): Observable<Book> {
    if(book.id != null) {
      return this.addOrUpdateBook(book);
    } else {
      throw new Error("No id (id is null) in the book to be updated.");
    }
  }

  addOrUpdateBook(book: Book): Observable<Book> {
    return this.http.post<Book>(`api/book/book`, book);

  }
}
