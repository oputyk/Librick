import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {Observable} from "rxjs/Observable";
import {Book} from "../../shared/models/book.model";
import {BookStorageService} from "./book-storage.service";
import {BookDataSource} from "./book-data-source.service";
import {ChangePasswordDialogComponent} from "../../user/change-password-dialog/change-password-dialog.component";
import {AddBookDialogComponent} from "./add-book-dialog/add-book-dialog.component";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-book-storage',
  templateUrl: './book-storage.component.html',
  styleUrls: ['./book-storage.component.scss'],
  providers: [BookStorageService]
})
export class BookStorageComponent implements OnInit {

  bookDataSource: BookDataSource;
  displayedColumns = ['id', 'name', 'releaseDate', 'authors', 'description'];

  constructor(private service: BookStorageService, public dialog: MatDialog) { }

  ngOnInit() {
    this.reloadBookData();
  }

  showAddBookDialog() {
    const dialogRef = this.dialog.open(AddBookDialogComponent);

    dialogRef.afterClosed().subscribe((book: Book) => {
      if(!isNullOrUndefined(book)) {
        this.reloadBookData();
      }
    })
  }

  private reloadBookData() {
    this.bookDataSource = this.service.getBookDataSource();
  }
}
