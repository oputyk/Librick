import {DataSource} from "@angular/cdk/collections";
import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";
import {Subject} from "rxjs/Subject";
import {Author} from "../../shared/models/author.model";
import {AuthorApiService} from "../../core/services/api/author-api/author-api.service";

@Injectable()
export class AuthorDataSource extends DataSource<Author> {
  private allAuthorsSubject: Subject<Author[]> = new Subject<Author[]>();

  constructor(private authorApiService: AuthorApiService) {
    super();
  }
  connect(): Observable<Author[]> {
    this.loadAuthors();

    return this.allAuthorsSubject.asObservable();
  }

  disconnect() {}

  reload() {
   this.loadAuthors();
  }

  private loadAuthors() {
    this.authorApiService.getAllFullAuthors().subscribe((authors: Author[]) => {
      this.allAuthorsSubject.next(authors);
    });
  }
}
