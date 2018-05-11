import {Book} from "./book.model";

export class Author {
  id: number;
  firstName: string;
  lastName: string;
  birthday: Date;
  books: Book[];
}
