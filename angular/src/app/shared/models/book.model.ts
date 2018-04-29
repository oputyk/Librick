import {Author} from "./author.model";

export class Book {
  id: number;
  name: string;
  description: string;
  releaseDate: Date;
  authors: Author[];
}
