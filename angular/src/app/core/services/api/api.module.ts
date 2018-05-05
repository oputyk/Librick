import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserApiService} from "./user-api/user-api.service";
import {HttpClientModule} from "@angular/common/http";
import {BookApiService} from "./book-api/book-api.service";
import {AuthorApiService} from "./author-api/author-api.service";

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers:[
    UserApiService,
    BookApiService,
    AuthorApiService
  ],
  exports: [
    HttpClientModule
  ]
})
export class ApiModule { }
