import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoreRoutingModule } from './core-routing.module';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {ApiModule} from "./services/api/api.module";
import {PublicModule} from "../public/public.module";
import {LibrarianModule} from "../librarian/librarian.module";
import {MatFormField, MatHint} from "@angular/material";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./guards/auth.guard";
import {MaterialModule} from "./material.module";
import {FormsModule} from "@angular/forms";
import {NoopInterceptor} from "@angular/common/http/src/interceptor";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {TokenHttpInterceptor} from "./services/api/interceptors/token-http-interceptor.service";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    CoreRoutingModule,
    MaterialModule,
    ApiModule,
    PublicModule,
    LibrarianModule
  ],
  declarations: [
    HeaderComponent,
    FooterComponent,
    PageNotFoundComponent,
    LoginComponent
  ],
  exports: [
    CoreRoutingModule,
    HeaderComponent,
    FooterComponent
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenHttpInterceptor,
      multi: true,
    }
  ]
})
export class CoreModule { }
