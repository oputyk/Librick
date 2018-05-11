import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Author} from "../../../../shared/models/author.model";
import {BookSelectorDialogService} from "./book-selector-dialog.service";
import {MatCheckboxModule, MatDialogRef, MatTableDataSource} from "@angular/material";
import {isNullOrUndefined} from "util";
import {Book} from "../../../../shared/models/book.model";
import {ChangePasswordDialogComponent} from "../../../../user/change-password-dialog/change-password-dialog.component";

@Component({
  selector: 'app-book-selector-dialog',
  templateUrl: './book-selector-dialog.component.html',
  styleUrls: ['./book-selector-dialog.component.scss'],
  providers: [BookSelectorDialogService]
})
export class BookSelectorDialogComponent implements OnInit {

  @Input() oldBooks: Book[];
  public books: Map<Book, boolean>;
  public bookDataSource: MatTableDataSource<Book>;
  public displayedColumns = ['selection', 'id', 'name', 'releaseDate'];

  constructor(public bookSelectorDialogRef: MatDialogRef<BookSelectorDialogComponent>,
              private service: BookSelectorDialogService) {
    this.books = new Map<Book, boolean>();
  }

  ngOnInit() {
    this.service.getAllBooks().subscribe((books: Book[]) => {
      books.forEach((book: Book) => {
        this.books.set(book, this.service.isThereBook(book, this.oldBooks));
      });
      this.bookDataSource =
        new MatTableDataSource<Book>(Array.from(this.books.keys()));
    });
  }

  returnBooks() {
    this.bookSelectorDialogRef.close(BookSelectorDialogService.getSelectedBooks(this.books));
  }
}
