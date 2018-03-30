import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserProfileComponent} from "./user-profile.component";
import { ChangePasswordDialogComponent } from './change-password-dialog/change-password-dialog.component';
import {MaterialModule} from "../core/material.module";
import {FormsModule} from "@angular/forms";
import {FlexLayoutModule} from "@angular/flex-layout";
import {UserRoutingModule} from "./user-routing.module";

@NgModule({
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule,
    MaterialModule,
    FlexLayoutModule
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
export class UserModule { }
