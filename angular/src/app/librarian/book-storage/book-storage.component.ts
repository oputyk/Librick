import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {Observable} from "rxjs/Observable";
import {Book} from "../../shared/models/book.model";
import {BookStorageService} from "./book-storage.service";
import {BookDataSource} from "./book-data-source.service";
import {ChangePasswordDialogComponent} from "../../user/change-password-dialog/change-password-dialog.component";
import {EditBookDialogComponent} from "./add-book-dialog/edit-book-dialog.component";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-book-storage',
  templateUrl: './book-storage.component.html',
  styleUrls: ['./book-storage.component.scss'],
  providers: [BookStorageService]
})
export class BookStorageComponent implements OnInit {

  bookDataSource: BookDataSource;
  displayedColumns =
    ['id', 'name', 'releaseDate', 'authors', 'description', 'edit', 'delete'];

  constructor(private service: BookStorageService,
              public addBookDialog: MatDialog) { }

  ngOnInit() {
    this.bookDataSource = this.service.getBookDataSource();
  }

  showAddBookDialog() {
    const dialogRef = this.addBookDialog.open(EditBookDialogComponent);

    dialogRef.afterClosed().subscribe((book: Book) => {
      if(!isNullOrUndefined(book)) {
        this.reloadBookData();
      }
    })
  }

  showEditBookDialog(book: Book) {
    const dialogRef = this.addBookDialog.open(EditBookDialogComponent);
    dialogRef.componentInstance.book = book;

    dialogRef.afterClosed().subscribe((book: Book) => {
      if(!isNullOrUndefined(book)) {
        this.reloadBookData();
      }
    })
  }

  delete(book: Book) {
    this.service.deleteBook(book.id).subscribe((success: boolean) => {
      if(success) {
        this.reloadBookData();
      }
    });
  }

  private reloadBookData() {
    this.bookDataSource.reload();
  }
}
