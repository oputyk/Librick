import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Book} from "../../shared/models/book.model";
import {BookApiService} from "../../core/services/api/book-api/book-api.service";
import {DataSource} from "@angular/cdk/collections";
import {User} from "../../shared/models/user.model";
import {BookDataSource} from "./book-data-source.service";

@Injectable()
export class BookStorageService {

  constructor(private bookDataSource: BookDataSource) { }

  getBookDataSource(): BookDataSource {
    return this.bookDataSource;
  }

}
