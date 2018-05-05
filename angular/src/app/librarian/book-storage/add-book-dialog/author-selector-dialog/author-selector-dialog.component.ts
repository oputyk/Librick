import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Author} from "../../../../shared/models/author.model";
import {AuthorSelectorDialogService} from "./author-selector-dialog.service";
import {MatCheckboxModule, MatDialogRef, MatTableDataSource} from "@angular/material";
import {isNullOrUndefined} from "util";
import {Book} from "../../../../shared/models/book.model";
import {ChangePasswordDialogComponent} from "../../../../user/change-password-dialog/change-password-dialog.component";

@Component({
  selector: 'app-author-selector-dialog',
  templateUrl: './author-selector-dialog.component.html',
  styleUrls: ['./author-selector-dialog.component.scss'],
  providers: [AuthorSelectorDialogService]
})
export class AuthorSelectorDialogComponent implements OnInit {

  @Input() oldAuthors: Author[];
  public authors: Map<Author, boolean>;
  public authorDataSource: MatTableDataSource<Author>;
  public displayedColumns = ['selection', 'id', 'name', 'birthday'];

  constructor(public authorSelectorDialogRef: MatDialogRef<AuthorSelectorDialogComponent>,
              private service: AuthorSelectorDialogService) {
    this.authors = new Map<Author, boolean>();
  }

  ngOnInit() {
    this.service.getAllAuthors().subscribe((authors: Author[]) => {
      authors.forEach((author: Author) => {
        this.authors.set(author, this.service.isThereAuthor(author, this.oldAuthors));
      });
      this.authorDataSource =
        new MatTableDataSource<Author>(Array.from(this.authors.keys()));
    });
  }

  returnAuthors() {
    this.authorSelectorDialogRef.close(AuthorSelectorDialogService.getSelectedAuthors(this.authors));
  }
}
