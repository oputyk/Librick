import {Component, Input, OnInit} from '@angular/core';
import {DateAdapter, MatDialog, MatDialogRef} from "@angular/material";
import {ChangePasswordDialogService} from "../../../user/change-password-dialog/change-password-dialog.service";
import {ChangePasswordDialogComponent} from "../../../user/change-password-dialog/change-password-dialog.component";

import {Book} from "../../../shared/models/book.model";
import {isNullOrUndefined} from "util";
import {MomentDateAdapter} from "@angular/material-moment-adapter";
import {Author} from "../../../shared/models/author.model";
import {
  BookSelectorDialogComponent
} from "./book-selector-dialog/book-selector-dialog.component";
import {EditAuthorDialogService} from "./edit-author-dialog.service";

@Component({
  selector: 'app-add-author-dialog',
  templateUrl: './edit-author-dialog.component.html',
  styleUrls: ['./edit-author-dialog.component.scss'],
  providers: [EditAuthorDialogService, {provide: DateAdapter, useClass: MomentDateAdapter}]
})
export class EditAuthorDialogComponent implements OnInit {

  @Input() public author: Author;
  public title: string;
  public error: boolean = false;

  constructor(public editAuthorDialogRef: MatDialogRef<EditAuthorDialogComponent>,
              public selectBookDialog: MatDialog,
              private service: EditAuthorDialogService) { }

  ngOnInit() {
    if(isNullOrUndefined(this.author)) {
      this.author = new Author();
      this.title = 'Add author';
    } else {
      this.title = 'Update author';
    }
  }

  addOrUpdateAuthor() {
    this.service.addOrUpdateAuthor(this.author).subscribe(
      (author: Author) => {
        if(author == null) {
          this.error = true;
        } else {
          this.editAuthorDialogRef.close(author);
        }
    },error => {
        this.error = true;
      });
  }

  selectBooks(selectedBooks: Book[]) {
    this.author.books = selectedBooks;
  }

  showBookSelectorDialog() {
    const dialogRef = this.selectBookDialog.open(BookSelectorDialogComponent);
    dialogRef.componentInstance.oldBooks = this.author.books;

    dialogRef.afterClosed().subscribe((books: Book[]) => {
      if(!isNullOrUndefined(books)) {
        this.author.books = books;
      }
    });
  }
}
