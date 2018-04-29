import { Injectable } from '@angular/core';
import {Book} from "../../../shared/models/book.model";
import {BookApiService} from "../../../core/services/api/book-api/book-api.service";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AddBookDialogService {

  constructor(private bookApiService: BookApiService) { }

  addOrUpdateBook(book: Book): Observable<Book> {
    return this.bookApiService.addOrUpdateBook(book);
  }
}
