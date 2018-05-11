import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {Author} from "../../../../shared/models/author.model";

@Injectable()
export class AuthorApiService {

  constructor(private http: HttpClient) { }

  getAllAuthors(): Observable<Author[]> {
    return this.http.get<Author[]>(`api/author/all`);
  }

  getAllFullAuthors(): Observable<Author[]> {
    return this.http.get<Author[]>(`api/author/all-full`);
  }

  addAuthor(author: Author): Observable<Author> {
    if(author.id == null) {
      return this.addOrUpdateAuthor(author);
    } else {
      throw new Error("Id should be null to create an author.");
    }
  }

  updateAuthor(author: Author): Observable<Author> {
    if(author.id != null) {
      return this.addOrUpdateAuthor(author);
    } else {
      throw new Error("No id (id is null) in the author to be updated.");
    }
  }

  addOrUpdateAuthor(author: Author): Observable<Author> {
    return this.http.post<Author>(`api/author/secure/author`, author);

  }

  deleteAuthor(id: number) {
    return this.http.delete<boolean>(`/api/author/secure/author/${id}`);
  }
}
