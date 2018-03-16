import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserApiService} from "./user-api/user-api.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers:[
    UserApiService
  ],
  exports: [
    HttpClientModule
  ]
})
export class ApiModule { }
