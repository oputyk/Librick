import { Injectable } from '@angular/core';
import {AuthorDataSource} from "./author-data-source.service";
import {AuthorApiService} from "../../core/services/api/author-api/author-api.service";

@Injectable()
export class AuthorStorageService {

  constructor(private authorDataSource: AuthorDataSource,
              private authorApiService: AuthorApiService) { }

  getAuthorDataSource(): AuthorDataSource {
    return this.authorDataSource;
  }

  deleteAuthor(id: number) {
    return this.authorApiService.deleteAuthor(id);
  }
}
