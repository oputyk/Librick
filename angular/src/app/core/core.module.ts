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

@NgModule({
  imports: [
    CommonModule,
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
    AuthGuard
  ]
})
export class CoreModule { }
