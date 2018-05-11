import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material';
import {Book} from "../../shared/models/book.model";
import {AuthorStorageService} from "./author-storage.service";
import {AuthorDataSource} from "./author-data-source.service";
import {EditAuthorDialogComponent} from "./add-author-dialog/edit-author-dialog.component";
import {isNullOrUndefined} from "util";
import {Author} from "../../shared/models/author.model";

@Component({
  selector: 'app-author-storage',
  templateUrl: './author-storage.component.html',
  styleUrls: ['./author-storage.component.scss'],
  providers: [AuthorStorageService]
})
export class AuthorStorageComponent implements OnInit {

  authorDataSource: AuthorDataSource;
  displayedColumns =
    ['id', 'firstName', 'lastName', 'birthday', 'books', 'edit', 'delete'];

  constructor(private service: AuthorStorageService,
              public addAuthorDialog: MatDialog) { }

  ngOnInit() {
    this.authorDataSource = this.service.getAuthorDataSource();
  }

  showAddAuthorDialog() {
    const dialogRef = this.addAuthorDialog.open(EditAuthorDialogComponent);

    dialogRef.afterClosed().subscribe((author: Author) => {
      if(!isNullOrUndefined(author)) {
        this.reloadAuthorData();
      }
    })
  }

  showEditAuthorDialog(author: Author) {
    const dialogRef = this.addAuthorDialog.open(EditAuthorDialogComponent);
    dialogRef.componentInstance.author = author;

    dialogRef.afterClosed().subscribe((book: Book) => {
      if(!isNullOrUndefined(book)) {
        this.reloadAuthorData();
      }
    })
  }

  delete(author: Author) {
    this.service.deleteAuthor(author.id).subscribe((success: boolean) => {
      if(success) {
        this.reloadAuthorData();
      }
    });
  }

  private reloadAuthorData() {
    this.authorDataSource.reload();
  }
}
