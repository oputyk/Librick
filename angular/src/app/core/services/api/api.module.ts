import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserApiService} from "./user-api/user-api.service";
import {HttpClientModule} from "@angular/common/http";
import {AuthenticationService} from "./authentication/authentication.service";

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers:[
    UserApiService,
    AuthenticationService
  ],
  exports: [
    HttpClientModule
  ]
})
export class ApiModule { }
