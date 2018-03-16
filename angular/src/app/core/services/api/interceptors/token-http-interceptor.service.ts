/**
 * Created by kamil on 10/03/2018.
 */

import {HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {AuthenticationService} from "../../authentication/authentication.service";
@Injectable()
export class TokenHttpInterceptor  implements HttpInterceptor {
  private isAuthenticated: boolean = false;

  constructor(private authenticationService: AuthenticationService) {
    this.authenticationService.isAuthenticated().subscribe(
      (isAuthenticated: boolean) => {
        this.isAuthenticated = isAuthenticated;
      }
    )
  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let authReq = req;
    if(this.isAuthenticated) {
      authReq = this.addTokenToRequestHeaders(authReq, req);
    }

    return next.handle(authReq);
  }

  private addTokenToRequestHeaders(authReq: HttpRequest<any>, req: HttpRequest<any>) {
    let authorizationHeader = 'Bearer ' + this.authenticationService.getToken();

    authReq = req.clone({headers: req.headers.set('Authorization', authorizationHeader)});
    return authReq;
  }
}
