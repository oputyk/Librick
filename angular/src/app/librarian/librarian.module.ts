import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard/dashboard.component';
import {LibrarianRoutingModule} from "./librarian-routing.module";
import {SharedModule} from "../shared/shared.module";
import {MaterialModule} from "../core/material.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import { BookStorageComponent } from './book-storage/book-storage.component';
import {ApiModule} from "../core/services/api/api.module";
import {BookDataSource} from "./book-storage/book-data-source.service";
import { EditBookDialogComponent } from './book-storage/add-book-dialog/edit-book-dialog.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ChangePasswordDialogComponent} from "../user/change-password-dialog/change-password-dialog.component";
import { AuthorSelectorDialogComponent } from './book-storage/add-book-dialog/author-selector-dialog/author-selector-dialog.component';
import {BookSelectorDialogService} from "./authors/add-author-dialog/book-selector-dialog/book-selector-dialog.service";
import {BookSelectorDialogComponent} from "./authors/add-author-dialog/book-selector-dialog/book-selector-dialog.component";
import {EditAuthorDialogComponent} from "./authors/add-author-dialog/edit-author-dialog.component";
import {AuthorStorageComponent} from "./authors/author-storage.component";
import {AuthorDataSource} from "./authors/author-data-source.service";

@NgModule({
  imports: [
    CommonModule,
    LibrarianRoutingModule,
    SharedModule,
    MaterialModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    DashboardComponent,
    BookStorageComponent,
    EditBookDialogComponent,
    EditAuthorDialogComponent,
    AuthorSelectorDialogComponent,
    BookSelectorDialogComponent,
    AuthorStorageComponent
  ],
  entryComponents: [
    EditBookDialogComponent,
    EditAuthorDialogComponent,
    AuthorSelectorDialogComponent,
    BookSelectorDialogComponent
  ],
  providers: [
    BookDataSource,
    AuthorDataSource
  ]
})
export class LibrarianModule { }
