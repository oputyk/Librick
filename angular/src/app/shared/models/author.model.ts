import {Book} from "./book.model";

export class Author {
  id: Number;
  firstName: string;
  lastName: string;
  birthday: Date;
  books: Book[];
}
