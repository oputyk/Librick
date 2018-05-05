import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Author} from "../../../../shared/models/author.model";
import {AuthorApiService} from "../../../../core/services/api/author-api/author-api.service";
import {isNullOrUndefined} from "util";

@Injectable()
export class AuthorSelectorDialogService {

  constructor(private authorApiService: AuthorApiService) { }

  getAllAuthors(): Observable<Author[]> {
    return this.authorApiService.getAllAuthors();
  }

  isThereAuthor(author: Author, oldAuthors: Author[]): boolean {
    let isThere: boolean = false;

    if(!isNullOrUndefined(oldAuthors)) {
      oldAuthors.forEach(((oldAuthor: Author) => {
        if (oldAuthor.id == author.id) {
          isThere = true;
        }
      }));
    }

    return isThere;
  }

  static getSelectedAuthors(authors: Map<Author, boolean>): Author[] {
    let selectedAuthors: Author[] = [];

    authors.forEach((selected: boolean, author: Author) => {
      if(selected) {
        selectedAuthors.push(author);
      }
    });

    return selectedAuthors;
  }
}
