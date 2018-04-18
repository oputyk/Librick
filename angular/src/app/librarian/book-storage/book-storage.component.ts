import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Book} from "../../shared/models/book.model";
import {BookStorageService} from "./book-storage.service";

@Component({
  selector: 'app-book-storage',
  templateUrl: './book-storage.component.html',
  styleUrls: ['./book-storage.component.scss'],
  providers: [BookStorageService]
})
export class BookStorageComponent implements OnInit {

  books$: Observable<Book[]>;

  constructor(private service: BookStorageService) { }

  ngOnInit() {
    this.books$ = this.service.getBooks();
  }

}
