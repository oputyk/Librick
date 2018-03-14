import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {CoreModule} from "./core/core.module";
import {HttpClientModule} from "@angular/common/http";
import {NgHttpLoaderModule} from "ng-http-loader/ng-http-loader.module";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    CoreModule,
    HttpClientModule,
    NgHttpLoaderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
