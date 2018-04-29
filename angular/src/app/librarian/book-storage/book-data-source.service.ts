import {DataSource} from "@angular/cdk/collections";
import {Observable} from "rxjs/Observable";
import {BookApiService} from "../../core/services/api/book-api/book-api.service";
import {Book} from "../../shared/models/book.model";
import {Injectable} from "@angular/core";

@Injectable()
export class BookDataSource extends DataSource<Book> {
  constructor(private bookApiService: BookApiService) {
    super();
  }
  connect(): Observable<Book[]> {
    return this.bookApiService.getBooks();
  }
  disconnect() {}
}
