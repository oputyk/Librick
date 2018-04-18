import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Book} from "../../shared/models/book.model";
import {BookApiService} from "../../core/services/api/book-api/book-api.service";

@Injectable()
export class BookStorageService {

  constructor(private bookApiService: BookApiService) { }

  getBooks(): Observable<Book[]> {
    return this.bookApiService.getBooks();
  }

}
