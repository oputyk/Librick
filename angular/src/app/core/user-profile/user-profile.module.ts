import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserProfileComponent} from "./user-profile.component";
import { ChangePasswordDialogComponent } from './change-password-dialog/change-password-dialog.component';
import {MaterialModule} from "../material.module";
import {FormsModule} from "@angular/forms";
import {FlexLayoutModule} from "@angular/flex-layout";
import {ApiModule} from "../services/api/api.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    MaterialModule,
    FlexLayoutModule,
    ApiModule
  ],
  declarations: [
    UserProfileComponent,
    ChangePasswordDialogComponent
  ],
  entryComponents: [
    ChangePasswordDialogComponent
  ],
  exports: [UserProfileComponent]
})
export class UserProfileModule { }
