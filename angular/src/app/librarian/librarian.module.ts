import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard/dashboard.component';
import {LibrarianRoutingModule} from "./librarian-routing.module";
import {SharedModule} from "../shared/shared.module";
import {MaterialModule} from "../core/material.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import { BookStorageComponent } from './book-storage/book-storage.component';
import {ApiModule} from "../core/services/api/api.module";

@NgModule({
  imports: [
    CommonModule,
    LibrarianRoutingModule,
    SharedModule,
    MaterialModule,
    FlexLayoutModule,
    ApiModule
  ],
  declarations: [
    DashboardComponent,
    BookStorageComponent
  ]
})
export class LibrarianModule { }
