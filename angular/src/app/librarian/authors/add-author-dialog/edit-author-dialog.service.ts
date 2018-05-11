import { Injectable } from '@angular/core';
import {Book} from "../../../shared/models/book.model";
import {BookApiService} from "../../../core/services/api/book-api/book-api.service";
import {Observable} from "rxjs/Observable";
import {AuthorApiService} from "../../../core/services/api/author-api/author-api.service";
import {Author} from "../../../shared/models/author.model";

@Injectable()
export class EditAuthorDialogService {

  constructor(private authorApiService: AuthorApiService) { }

  addOrUpdateAuthor(author: Author): Observable<Author> {
    return this.authorApiService.addOrUpdateAuthor(author);
  }
}
