import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Author} from "../../../../shared/models/author.model";
import {AuthorApiService} from "../../../../core/services/api/author-api/author-api.service";
import {isNullOrUndefined} from "util";
import {BookApiService} from "../../../../core/services/api/book-api/book-api.service";
import {Book} from "../../../../shared/models/book.model";

@Injectable()
export class BookSelectorDialogService {

  constructor(private bookApiService: BookApiService) { }

  getAllBooks(): Observable<Book[]> {
    return this.bookApiService.getAllBooks();
  }

  isThereBook(book: Book, oldBooks: Book[]): boolean {
    let isThere: boolean = false;

    if(!isNullOrUndefined(oldBooks)) {
      oldBooks.forEach(((oldBook: Book) => {
        if (oldBook.id == book.id) {
          isThere = true;
        }
      }));
    }

    return isThere;
  }

  static getSelectedBooks(books: Map<Book, boolean>): Book[] {
    let selectedBooks: Book[] = [];

    books.forEach((selected: boolean, book: Book) => {
      if(selected) {
        selectedBooks.push(book);
      }
    });

    return selectedBooks;
  }
}
