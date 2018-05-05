import {Component, Input, OnInit} from '@angular/core';
import {DateAdapter, MatDialog, MatDialogRef} from "@angular/material";
import {ChangePasswordDialogService} from "../../../user/change-password-dialog/change-password-dialog.service";
import {ChangePasswordDialogComponent} from "../../../user/change-password-dialog/change-password-dialog.component";
import {AddBookDialogService} from "./add-book-dialog.service";
import {Book} from "../../../shared/models/book.model";
import {isNullOrUndefined} from "util";
import {MomentDateAdapter} from "@angular/material-moment-adapter";
import {Author} from "../../../shared/models/author.model";
import {AuthorSelectorDialogComponent} from "./author-selector-dialog/author-selector-dialog.component";

@Component({
  selector: 'app-add-book-dialog',
  templateUrl: './add-book-dialog.component.html',
  styleUrls: ['./add-book-dialog.component.scss'],
  providers: [AddBookDialogService, {provide: DateAdapter, useClass: MomentDateAdapter}]
})
export class AddBookDialogComponent implements OnInit {

  @Input() public book: Book;
  public title: string;
  public error: boolean = false;

  constructor(public addBookDialogRef: MatDialogRef<AddBookDialogComponent>,
              public selectAuthorsDialog: MatDialog,
              private service: AddBookDialogService) { }

  ngOnInit() {
    if(isNullOrUndefined(this.book)) {
      this.book = new Book();
      this.title = 'Add book';
    } else {
      this.title = 'Update book';
    }
  }

  addOrUpdateBook() {
    this.service.addOrUpdateBook(this.book).subscribe(
      (book: Book) => {
        if(book == null) {
          this.error = true;
        } else {
          this.addBookDialogRef.close(book);
        }
    },error => {
        this.error = true;
      });
  }

  selectAuthors(selectedAuthors: Author[]) {
    this.book.authors = selectedAuthors;
  }

  showAuthorSelectorDialog() {
    const dialogRef = this.selectAuthorsDialog.open(AuthorSelectorDialogComponent);
    dialogRef.componentInstance.oldAuthors = this.book.authors;

    dialogRef.afterClosed().subscribe((authors: Author[]) => {
      if(!isNullOrUndefined(authors)) {
        this.book.authors = authors;
      }
    });
  }
}
