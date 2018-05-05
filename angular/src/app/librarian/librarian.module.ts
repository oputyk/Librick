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
import { AddBookDialogComponent } from './book-storage/add-book-dialog/add-book-dialog.component';
import {FormsModule} from "@angular/forms";
import {ChangePasswordDialogComponent} from "../user/change-password-dialog/change-password-dialog.component";
import { AuthorSelectorDialogComponent } from './book-storage/add-book-dialog/author-selector-dialog/author-selector-dialog.component';

@NgModule({
  imports: [
    CommonModule,
    LibrarianRoutingModule,
    SharedModule,
    MaterialModule,
    FlexLayoutModule,
    ApiModule,
    FormsModule
  ],
  declarations: [
    DashboardComponent,
    BookStorageComponent,
    AddBookDialogComponent,
    AuthorSelectorDialogComponent
  ],
  entryComponents: [
    AddBookDialogComponent,
    AuthorSelectorDialogComponent
  ],
  providers: [
    BookDataSource
  ]
})
export class LibrarianModule { }
