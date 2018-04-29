import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Observable} from "rxjs/Observable";
import {Book} from "../../shared/models/book.model";
import {BookStorageService} from "./book-storage.service";
import {BookDataSource} from "./book-data-source.service";

@Component({
  selector: 'app-book-storage',
  templateUrl: './book-storage.component.html',
  styleUrls: ['./book-storage.component.scss'],
  providers: [BookStorageService]
})
export class BookStorageComponent implements OnInit {

  bookDataSource: BookDataSource;
  displayedColumns = ['id', 'name', 'releaseDate', 'authors', 'description'];

  constructor(private service: BookStorageService) { }

  ngOnInit() {
    this.bookDataSource = this.service.getBookDataSource();
  }

  addBook() {

  }

}
