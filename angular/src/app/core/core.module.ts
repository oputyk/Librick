import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoreRoutingModule } from './core-routing.module';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {ApiModule} from "./services/api/api.module";
import {PublicModule} from "../public/public.module";
import {LibrarianModule} from "../librarian/librarian.module";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./guards/auth.guard";
import {MaterialModule} from "./material.module";
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {TokenHttpInterceptor} from "./services/api/interceptors/token-http-interceptor.service";
import { RegisterLibrarianComponent } from './register-librarian/register-librarian.component';
import 'hammerjs';
import {FlexLayoutModule} from "@angular/flex-layout";
import { MenuComponent } from './header/menu/menu.component';
import {AuthenticationService} from "./services/authentication/authentication.service";
import {NavigationLinksProviderService} from "./services/navigation-links-provider.service";
import {UserModule} from "../user/user.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    CoreRoutingModule,
    MaterialModule,
    ApiModule,
    PublicModule,
    LibrarianModule,
    FlexLayoutModule,
    UserModule
  ],
  declarations: [
    HeaderComponent,
    FooterComponent,
    PageNotFoundComponent,
    LoginComponent,
    RegisterLibrarianComponent,
    MenuComponent
  ],
  exports: [
    CoreRoutingModule,
    MaterialModule,
    HeaderComponent,
    FooterComponent,
    FlexLayoutModule
  ],
  providers: [
    AuthenticationService,
    NavigationLinksProviderService,
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenHttpInterceptor,
      multi: true,
    }
  ]
})
export class CoreModule { }
