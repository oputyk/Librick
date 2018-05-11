import {DataSource} from "@angular/cdk/collections";
import {Observable} from "rxjs/Observable";
import {BookApiService} from "../../core/services/api/book-api/book-api.service";
import {Book} from "../../shared/models/book.model";
import {Injectable} from "@angular/core";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Subject} from "rxjs/Subject";

@Injectable()
export class BookDataSource extends DataSource<Book> {
  private allBooksSubject: Subject<Book[]> = new Subject<Book[]>();

  constructor(private bookApiService: BookApiService) {
    super();
  }
  connect(): Observable<Book[]> {
    this.loadBooks();

    return this.allBooksSubject.asObservable();
  }

  disconnect() {}

  reload() {
   this.loadBooks();
  }

  private loadBooks() {
    this.bookApiService.getAllFullBooks().subscribe((books: Book[]) => {
      this.allBooksSubject.next(books);
    });
  }
}
