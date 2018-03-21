import {isNullOrUndefined} from "util";
import {Observable} from "rxjs/Observable";
/**
 * Created by kamil on 15/03/2018.
 */

export class Link {
  name$: Observable<string>;
  url: string;
  callback: () => void;

  constructor(name: Observable<string>, url: string, callback?: () => void) {
    this.name$ = name;
    this.url = url;

    if(!isNullOrUndefined(callback)) {
      this.callback = callback;
    } else {
      this.callback = () => {};
    }
  }
}
