import {Component, Input, OnInit} from '@angular/core';
import {DateAdapter, MatDialogRef} from "@angular/material";
import {ChangePasswordDialogService} from "../../../user/change-password-dialog/change-password-dialog.service";
import {ChangePasswordDialogComponent} from "../../../user/change-password-dialog/change-password-dialog.component";
import {AddBookDialogService} from "./add-book-dialog.service";
import {Book} from "../../../shared/models/book.model";
import {isNullOrUndefined} from "util";
import {MomentDateAdapter} from "@angular/material-moment-adapter";

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

  constructor(public dialogRef: MatDialogRef<ChangePasswordDialogComponent>,
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
    this.book.authors = null;
    this.service.addOrUpdateBook(this.book).subscribe(
      (book: Book) => {
        if(book == null) {
          this.error = true;
        } else {
          this.dialogRef.close(book);
        }
    },error => {
        this.error = true;
      });
  }
}
